package com.borman.service;

import com.borman.entity.Tag;
import com.borman.repository.TagRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor public class TagService {

    private final TagRepository tagRepository;


    public Tag getTagById(Long id) {
        return tagRepository.getById(id);
    }

    public void saveTag(Tag tag) {
        tagRepository.save(tag);
    }

    public void deleteTag(Tag tag) {
        tagRepository.delete(tag);
    }
}
