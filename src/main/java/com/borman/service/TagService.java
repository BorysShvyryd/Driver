package com.borman.service;

import com.borman.entity.Tag;
import com.borman.repository.TagRepository;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;


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

    public List<Tag> findTagsByName(String findStr) {
        return tagRepository.findAll().stream()
                .filter(o -> o.getName().toLowerCase().contains(findStr.toLowerCase()))
                .collect(Collectors.toList());
    }
}
