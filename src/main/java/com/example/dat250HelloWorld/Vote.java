package com.example.dat250HelloWorld;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

public class Vote {
    Instant publishedAt;
    VoteOption option;


    @JsonCreator
    public Vote(@JsonProperty("option") VoteOption option) {
        this.option = option;
        this.publishedAt = Instant.now();
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
}
