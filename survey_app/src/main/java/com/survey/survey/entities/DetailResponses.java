package com.survey.survey.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="detail_responses")
public class DetailResponses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int response_option;
    private String response_text;

    @ManyToOne
    private Questions question;

    @ManyToOne
    private Responses response;

    public DetailResponses() {}

    public DetailResponses(Long id, int response_option, Questions question, Responses response, String response_text) {
        this.id = id;
        this.response_option = response_option;
        this.question = question;
        this.response = response;
        this.response_text = response_text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getResponse_option() {
        return response_option;
    }

    public void setResponse_option(int response_option) {
        this.response_option = response_option;
    }

    public Questions getQuestion() {
        return question;
    }

    public void setQuestion(Questions question) {
        this.question = question;
    }

    public Responses getResponse() {
        return response;
    }

    public void setResponse(Responses response) {
        this.response = response;
    }

    public String getResponse_text() {
        return response_text;
    }

    public void setResponse_text(String response_text) {
        this.response_text = response_text;
    }

    @Override
    public String toString() {
        return "{id=" + id + ", response_option=" + response_option + ", question=" + question + ", response=" + response + ", response_text='" + response_text + "'}";
    }
}
