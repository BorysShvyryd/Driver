package com.borman.service;

import com.borman.entity.SeeAlso;
import com.borman.repository.SeeAlsoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SeeAlsoService {

    private final SeeAlsoRepository seeAlsoRepository;


    public SeeAlso getSeeAlsoById(Long id) {
        return seeAlsoRepository.getById(id);
    }

    public void saveSeeAlso(SeeAlso seeAlso) {
        seeAlsoRepository.save(seeAlso);
    }

    public void deleteSeeAlso(SeeAlso seeAlso) {
        seeAlsoRepository.delete(seeAlso);
    }
}
