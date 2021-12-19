package com.borman.service;

import com.borman.entity.Advice;
import com.borman.repository.AdviceRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AdviceService {

    private static final int MAX_NEW_TIPS_VIEW = 5;
    private final AdviceRepository adviceRepository;


    public Advice getAdviceById(Long id) {
        return adviceRepository.getById(id);
    }

    public List<Advice> getAllAdvices() {
        return adviceRepository.findAll();
    }

    public Advice saveAdvice(Advice advice) {
        return adviceRepository.save(advice);
    }

    public void deleteAdvice(Advice advice) {
        adviceRepository.delete(advice);
    }

    public void deleteAdviceById(Long id) {
        adviceRepository.deleteById(id);
    }

    public boolean existById(Long id) {
        return adviceRepository.existsById(id);
    }

    public Advice getTipForToday() {
        int numberTips = adviceRepository.findAll().size();
        if (numberTips > 0) {
            Random rnd = new Random();
            int idByTipRandom = rnd.nextInt(numberTips) + 1;
            return adviceRepository.getById((long) idByTipRandom);
        }
        return null;
    }

    public List<Advice> getPopularTips() {
        return adviceRepository.findAll().stream()
                .sorted((a, b) -> (int) (b.getRecommendation() - a.getRecommendation()))
                .limit(MAX_NEW_TIPS_VIEW)
                .collect(Collectors.toList());
    }

    public List<Advice> getLastTips() {
        return adviceRepository.findAll().stream()
                .sorted((a, b) -> (int) (b.getId() - a.getId()))
                .limit(MAX_NEW_TIPS_VIEW)
                .collect(Collectors.toList());
    }
}
