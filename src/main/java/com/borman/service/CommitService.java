package com.borman.service;

import com.borman.entity.Commit;
import com.borman.repository.CommitRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CommitService {

    private final CommitRepository commitRepository;


    public Commit getCommitById(Long id) {
        return commitRepository.getById(id);
    }

    public void saveCommit(Commit commit) {
        commitRepository.save(commit);
    }

    public void deleteCommit(Commit commit) {
        commitRepository.delete(commit);
    }
}
