package com.borman.controller;


import com.borman.entity.Advice;
import com.borman.service.AdviceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@AllArgsConstructor
public class HomeController {

    private final AdviceService adviceService;

    @GetMapping("/")
    public Map<String, List<Advice>> index() {

        Map<String, List<Advice>> map = new HashMap<>();

        List<Advice> tipForToday = new ArrayList<>();
        tipForToday.add(adviceService.getTipForToday());
        List<Advice> popularTips = adviceService.getPopularTips();
        List<Advice> lastTips = adviceService.getLastTips();

        map.put("tipForToday", tipForToday);
        map.put("popularTips", popularTips);
        map.put("lastTips", lastTips);

        return map;
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
