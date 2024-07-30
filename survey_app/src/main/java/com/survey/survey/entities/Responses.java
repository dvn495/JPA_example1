package com.survey.survey.entities;

import java.sql.Time;
import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="responses")
public class Responses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Time response_time;
    private Timestamp response_date;
    private String name_respondent;

    @ManyToOne
    private Surveys survey;

    public Responses() {}

    public Responses(Long id, Time response_time, Timestamp response_date, Surveys survey, String name_respondent) {
        this.id = id;
        this.response_time = response_time;
        this.response_date = response_date;
        this.survey = survey;
        this.name_respondent = name_respondent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Time getResponse_time() {
        return response_time;
    }

    public void setResponse_time(Time response_time) {
        this.response_time = response_time;
    }

    public Timestamp getResponse_date() {
        return response_date;
    }

    public void setResponse_date(Timestamp response_date) {
        this.response_date = response_date;
    }

    public String getName_respondent() {
        return name_respondent;
    }

    public void setName_respondent(String name_respondent) {
        this.name_respondent = name_respondent;
    }

    public Surveys getSurvey() {
        return survey;
    }

    public void setSurvey(Surveys survey) {
        this.survey = survey;
    }

    @Override
    public String toString() {
        return "{id=" + id + ", response_time=" + response_time + ", response_date=" + response_date + ", survey=" + survey + ", name_respondent='" + name_respondent + "'}";
    }
}
