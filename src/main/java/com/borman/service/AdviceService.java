package com.borman.service;

import com.borman.entity.Advice;
import com.borman.repository.AdviceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AdviceService {

    private final AdviceRepository adviceRepository;


    public Advice getAdviceById(Long id) {
        return adviceRepository.getById(id);
    }

    public List<Advice> getAllAdvices() {
        return adviceRepository.findAll();
//        return adviceRepository.findAll().stream().limit(1).collect(Collectors.toList());
    }

    public void saveAdvice(Advice advice) {
        adviceRepository.save(advice);
    }

    public void deleteAdvice(Advice advice) {
        adviceRepository.delete(advice);
    }

}
