package com.borman.controller;

import com.borman.entity.Test;
import com.borman.service.TestService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/api/quiz")
public class QuizController {

    private final TestService testService;


    @GetMapping("/{id}")
    public ResponseEntity<Test> quizTip(@PathVariable Long id) {

        return ResponseEntity.ok(testService.getTestById(id));
    }

    @DeleteMapping("/{id}")
    public void tipsByIdDelete(@PathVariable Long id) {
        testService.deleteTest(testService.getTestById(id));
    }

    @PutMapping("/{id}")
    public void tipsByIdUpdate(@PathVariable Long id, @Valid @RequestBody final Test test) {
        test.setId(id);
        testService.saveTest(test);
    }

    @PostMapping
    public void tipsCreate(@Valid @RequestBody final Test test) {
        testService.saveTest(test);
    }
}
