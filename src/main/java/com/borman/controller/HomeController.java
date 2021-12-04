package com.borman.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {



    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/create-user")
    public String createUser() {
//        User user = new User();
//        user.setUsername("admin");
//        user.setPassword("admin");
//        userService.saveUser(user);
        return "-created-";
    }

}
