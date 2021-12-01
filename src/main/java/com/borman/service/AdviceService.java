package com.borman.service;

import com.borman.entity.Advice;
import com.borman.repository.AdviceRepository;
import org.springframework.stereotype.Service;

@Service
public class AdviceService {

    private final AdviceRepository adviceRepository;

    public AdviceService(AdviceRepository adviceRepository) {
        this.adviceRepository = adviceRepository;
    }

    public Advice getAdviceById(Long id) {
        return adviceRepository.getById(id);
    }

    public void saveAdvice(Advice advice) {
        adviceRepository.save(advice);
    }

    public void deleteAdvice(Advice advice) {
        adviceRepository.delete(advice);
    }

}
