package com.borman.controller;

import com.borman.entity.Advice;
import com.borman.service.AdviceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tips")
@AllArgsConstructor
public class AdviceController {

    private final AdviceService adviceService;


    @PostMapping
    public ResponseEntity<List<Advice>> tipsForToday() {
        return new ResponseEntity<>(adviceService.getAllAdvices(), HttpStatus.OK);
    }
}
