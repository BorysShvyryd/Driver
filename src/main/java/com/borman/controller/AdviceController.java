package com.borman.controller;

import com.borman.entity.Advice;
import com.borman.entity.Test;
import com.borman.service.AdviceService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/tips")
@AllArgsConstructor
public class AdviceController {

    private final AdviceService adviceService;


    @GetMapping("/{id}/quiz")
    public ResponseEntity<Test> quizTip(@PathVariable Long id) {

        return ResponseEntity.ok(adviceService.getAdviceById(id).getTest());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Advice> tipsByIdGet(@PathVariable Long id) {
        return ResponseEntity.ok(adviceService.getAdviceById(id));
    }

    @DeleteMapping("/{id}")
    public void tipsByIdDelete(@PathVariable Long id) {
        adviceService.deleteAdviceById(id);
    }

    @PutMapping("/{id}")
    public void tipsByIdUpdate(@PathVariable Long id, @Valid @RequestBody final Advice advice) {
        advice.setId(id);
        adviceService.saveAdvice(advice);
    }

    @PostMapping("/tip")
    public void tipsCreate(@Valid @RequestBody final Advice advice) {
        adviceService.saveAdvice(advice);
    }
}
