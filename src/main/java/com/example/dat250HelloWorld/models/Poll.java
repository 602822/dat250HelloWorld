package com.example.dat250HelloWorld.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Poll {
    String question;
    Instant publishedAt;
    Instant validUntil;
    List<VoteOption> options;


    @JsonCreator
    public Poll(@JsonProperty("question") String question, @JsonProperty("hoursValid") long hoursValid, @JsonProperty("options") List<VoteOption> options) {
        this.question = question;
        this.publishedAt = Instant.now();
        this.validUntil = this.publishedAt.plus(hoursValid, ChronoUnit.HOURS);
        this.options = options;

    }

    public Poll() {
        this.options = new ArrayList<>();
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Instant getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Instant publishedAt) {
        this.publishedAt = publishedAt;
    }

    public Instant getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(Instant validUntil) {
        this.validUntil = validUntil;
    }

    public List<VoteOption> getOptions() {
        return options;
    }

    public void setOptions(List<VoteOption> options) {
        this.options = options;
    }

}


