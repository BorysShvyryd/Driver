package com.borman.controller;

import com.borman.entity.Advice;
import com.borman.entity.Test;
import com.borman.exception.EntityNotFoundException;
import com.borman.service.AdviceService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/tips")
@AllArgsConstructor
public class AdviceController {

    private final AdviceService adviceService;


    @GetMapping
    public ResponseEntity<List<Advice>> allAdvices() {
        List<Advice> adviceList = adviceService.getAllAdvices();

        return adviceList != null &&  !adviceList.isEmpty()
                ? ResponseEntity.ok().body(adviceList)
                : ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}/quiz")
    public ResponseEntity<Test> quizTip(@PathVariable Long id) {
        final Test test = adviceService.getAdviceById(id).getTest();

        return test != null
                ? ResponseEntity.ok().body(test)
                : ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Advice> tipsByIdGet(@PathVariable Long id) {
        final Advice advice = adviceService.getAdviceById(id);

        return advice != null
                ? ResponseEntity.ok().body(advice)
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN') || (@adviceService.getAdviceById(#id) == @userRepository.getByEmail(authentication.principal))")
    public void tipsByIdDelete(@PathVariable Long id) {
        if (adviceService.existById(id)) {
            adviceService.deleteAdviceById(id);
        } else {
            throw new EntityNotFoundException(Advice.class, "id", id.toString());
        }
    }

    @PutMapping("/{id}")
    public void tipsByIdUpdate(@PathVariable Long id, @Valid @RequestBody final Advice advice) {
        if (adviceService.existById(id)) {
            advice.setId(id);
            adviceService.saveAdvice(advice);
        } else {
            throw new EntityNotFoundException(Advice.class, "id", id.toString());
        }
    }

    @PostMapping("/tip")
    public void tipsCreate(@Valid @RequestBody final Advice advice) {
        adviceService.saveAdvice(advice);
    }
}
