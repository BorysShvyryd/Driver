package com.borman.repository;

import com.borman.entity.SeeAlso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeeAlsoRepository extends JpaRepository<SeeAlso, Long> {
}
