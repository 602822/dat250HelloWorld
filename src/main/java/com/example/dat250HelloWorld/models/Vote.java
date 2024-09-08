package com.example.dat250HelloWorld.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

public class Vote {
    Instant publishedAt;
    VoteOption option;
    int pollId;


    @JsonCreator
    public Vote(@JsonProperty("option") VoteOption option, @JsonProperty("pollId") int pollId) {
        this.option = option;
        this.publishedAt = Instant.now();
        this.pollId = pollId;


    }

    public Vote() {

    }

    public Instant getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Instant publishedAt) {
        this.publishedAt = publishedAt;
    }

    public VoteOption getOption() {
        return option;
    }

    public void setOption(VoteOption option) {
        this.option = option;
    }

    public int getPollId() {
        return pollId;
    }

    public void setPollId(int pollId) {
        this.pollId = pollId;
    }
}



