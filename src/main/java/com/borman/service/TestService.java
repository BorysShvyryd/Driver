package com.borman.service;

import com.borman.entity.Test;
import com.borman.repository.TestRepository;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    private final TestRepository testRepository;

    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    public Test getTestById(Long id) {
        return testRepository.getById(id);
    }

    public void saveTest(Test test) {
        testRepository.save(test);
    }

    public void deleteTest(Test test) {
        testRepository.delete(test);
    }
}
