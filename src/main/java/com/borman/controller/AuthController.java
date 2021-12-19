package com.borman.controller;

import com.borman.dto.UserCreationDTO;
import com.borman.dto.UserLoginDTO;
import com.borman.entity.Role;
import com.borman.entity.User;
import com.borman.service.EmailService;
import com.borman.service.JwtProvider;
import com.borman.service.RoleService;
import com.borman.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final EmailService emailService;
    private final JwtProvider jwtProvider;
    private final UserService userService;
    private final RoleService roleService;

    @PostMapping("/login")
    public User login(@RequestBody UserLoginDTO userLoginDTO){
        return userLoginDTO.userLoginDTOToUser(userLoginDTO);
    }

    @PostMapping("/signup")
    public ResponseEntity<String> verificationUserEmail(@RequestBody String email, HttpServletRequest request) {

        if (userService.findUserByEmail(email) != null) {
            return ResponseEntity.status(1).build();
        }

        if (!email.matches("[_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.([a-zA-Z]{2,}){1}")) {
            return ResponseEntity.notFound().build();
        }

        String token = jwtProvider.generateToken(email);
        emailService.SendEmail(email
                , "Service DRIVE"
                , "Aby uzyskać dalszą rejestrację, kliknij link: https://" +
                        request.getHeader("host") +
                        "/api/auth/signup/" +
                        token);
        return ResponseEntity.ok().body("ok");
    }

    @PostMapping("/signup/{token}")
    public void registrationUserPost(@PathVariable String token, @RequestBody UserCreationDTO userCreationDTO) {

        if (!jwtProvider.validateToken(token)) {

        }
        userCreationDTO.setEmail(jwtProvider.getLoginFromToken(token));
        User user = userCreationDTO.userCreationDTOToUser(userCreationDTO);
        user.setEnabled(1);
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(roleService.getRoleUser());
        user.setRoles(roleSet);
        userService.saveUser(user);
    }
}