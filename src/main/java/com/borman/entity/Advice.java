package com.borman.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Blob;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class Advice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private String title;

    @Lob
    private Blob photo;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    private String advice_text;

    @OneToOne
    private Test test;

    @OneToMany
    private List<Commit> commits;

    private Long recommendation;

    @OneToMany
    private List<Tag> tags;

    private Long share;

    @OneToMany
    private List<SeeAlso> seeAlso;
}
