package com.survey.survey.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="questions")
public class Questions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String question_number;
    private String question_text;
    private String response_type;
    private String comment_question;

    @ManyToOne
    private Chapter chapter;

    @ManyToOne
    private Surveys survey;

    @ManyToOne
    private Questions parentQuestion;

    public Questions() {}

    public Questions(Long id, Chapter chapter, Surveys survey, Questions parentQuestion, String question_number, String question_text, String response_type, String comment_question) {
        this.id = id;
        this.chapter = chapter;
        this.survey = survey;
        this.parentQuestion = parentQuestion;
        this.question_number = question_number;
        this.question_text = question_text;
        this.response_type = response_type;
        this.comment_question = comment_question;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }

    public Surveys getSurvey() {
        return survey;
    }

    public void setSurvey(Surveys survey) {
        this.survey = survey;
    }

    public Questions getParentQuestion() {
        return parentQuestion;
    }

    public void setParentQuestion(Questions parentQuestion) {
        this.parentQuestion = parentQuestion;
    }

    public String getQuestion_number() {
        return question_number;
    }

    public void setQuestion_number(String question_number) {
        this.question_number = question_number;
    }

    public String getQuestion_text() {
        return question_text;
    }

    public void setQuestion_text(String question_text) {
        this.question_text = question_text;
    }

    public String getResponse_type() {
        return response_type;
    }

    public void setResponse_type(String response_type) {
        this.response_type = response_type;
    }

    public String getComment_question() {
        return comment_question;
    }

    public void setComment_question(String comment_question) {
        this.comment_question = comment_question;
    }

    @Override
    public String toString() {
        return "{id=" + id + ", chapter=" + chapter + ", survey=" + survey + ", parentQuestion=" + parentQuestion + ", question_number='" + question_number + "', question_text='" + question_text + "', response_type='" + response_type + "', comment_question='" + comment_question + "'}";
    }
}
