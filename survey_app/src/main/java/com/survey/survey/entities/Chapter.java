package com.survey.survey.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="chapter")
public class Chapter {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String chapter_number;
    private String chapter_title;

    @ManyToOne
    private Surveys survey;

    public Chapter() {}

    public Chapter(Long id, Surveys survey, String chapter_number, String chapter_title) {
        this.id = id;
        this.survey = survey;
        this.chapter_number = chapter_number;
        this.chapter_title = chapter_title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Surveys getSurvey() {
        return survey;
    }

    public void setSurvey(Surveys survey) {
        this.survey = survey;
    }

    public String getChapter_number() {
        return chapter_number;
    }

    public void setChapter_number(String chapter_number) {
        this.chapter_number = chapter_number;
    }

    public String getChapter_title() {
        return chapter_title;
    }

    public void setChapter_title(String chapter_title) {
        this.chapter_title = chapter_title;
    }

    @Override
    public String toString() {
        return "{id=" + id + ", survey=" + survey + ", chapter_number='" + chapter_number + "', chapter_title='" + chapter_title + "'}";
    }
}

