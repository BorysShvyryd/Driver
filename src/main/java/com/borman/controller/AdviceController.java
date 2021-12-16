package com.borman.controller;

import com.borman.entity.Advice;
import com.borman.entity.Test;
import com.borman.service.AdviceService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tips")
@AllArgsConstructor
public class AdviceController {

    private static final int MAX_NEW_TIPS_VIEW = 5;
    private final AdviceService adviceService;


    @GetMapping("/tip/{id}")
    public ResponseEntity<Advice> tipForToday() {

        int numberTips = adviceService.getAllAdvices().size();
        if (numberTips > 0) {
            Random rnd = new Random();
            int idByTipRandom = rnd.nextInt(numberTips) + 1;
            return ResponseEntity.ok(adviceService.getAdviceById((long) idByTipRandom));
        }
        return null;
    }

    @GetMapping("/new-tips")
    public ResponseEntity<List<Advice>> newTips() {

        return ResponseEntity.ok(adviceService.getAllAdvices().stream()
                .sorted((a, b) -> (int) (b.getId() - a.getId()))
                .limit(MAX_NEW_TIPS_VIEW)
                .collect(Collectors.toList()));
    }

    @GetMapping("/popular-tips")
    public ResponseEntity<List<Advice>> popularTips() {

        return ResponseEntity.ok(adviceService.getAllAdvices().stream()
                .sorted((a, b) -> (int) (b.getRecommendation() - a.getRecommendation()))
                .limit(MAX_NEW_TIPS_VIEW)
                .collect(Collectors.toList()));
    }

    @GetMapping("/tip/{id}/quiz")
    public ResponseEntity<Test> quizTip(@PathVariable Long id) {

        return ResponseEntity.ok(adviceService.getAdviceById(id).getTest());
    }

    @GetMapping("/tip/{id}")
    public ResponseEntity<Advice> tipsByIdGet(@PathVariable Long id) {
        return ResponseEntity.ok(adviceService.getAdviceById(id));
    }

    @DeleteMapping("/tip/{id}")
    public void tipsByIdDelete(@PathVariable Long id) {
        adviceService.deleteAdviceById(id);
    }

    @PutMapping("/tip/{id}")
    public void tipsByIdUpdate(@PathVariable Long id, @RequestBody final Advice advice) {
        advice.setId(id);
        adviceService.saveAdvice(advice);
    }

    @PostMapping("/tip")
    public void tipsCreate(@RequestBody final Advice advice) {
        adviceService.saveAdvice(advice);
    }
}
