package com.survey.survey.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="response_options")
public class ResponseOptions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String option_value;
    private String comment_response;
    private String option_test;
    private int question_parent;

    @ManyToOne
    private Questions question;

    public ResponseOptions() {}

    public ResponseOptions(Long id, String option_value, Questions question, String comment_response, String option_test, int question_parent) {
        this.id = id;
        this.option_value = option_value;
        this.question = question;
        this.comment_response = comment_response;
        this.option_test = option_test;
        this.question_parent = question_parent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOption_value() {
        return option_value;
    }

    public void setOption_value(String option_value) {
        this.option_value = option_value;
    }

    public Questions getQuestion() {
        return question;
    }

    public void setQuestion(Questions question) {
        this.question = question;
    }

    public String getComment_response() {
        return comment_response;
    }

    public void setComment_response(String comment_response) {
        this.comment_response = comment_response;
    }

    public String getOption_test() {
        return option_test;
    }

    public void setOption_test(String option_test) {
        this.option_test = option_test;
    }

    public int getQuestion_parent() {
        return question_parent;
    }

    public void setQuestion_parent(int question_parent) {
        this.question_parent = question_parent;
    }

    @Override
    public String toString() {
        return "{id=" + id + ", option_value='" + option_value + "', question=" + question + ", comment_response='" + comment_response + "', option_test='" + option_test + "', question_parent=" + question_parent + "}";
    }
}
