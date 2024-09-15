package com.example.dat250HelloWorld.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

public class Vote {
    Instant publishedAt;
    VoteOption option;
   int pollId;
   int voteOptionId;



    @JsonCreator
    public Vote(@JsonProperty("option") VoteOption option, @JsonProperty("pollId") int pollId, @JsonProperty("voteOptionId") int voteOptionId) {
        this.option = option;
        this.publishedAt = Instant.now();
        this.pollId = pollId;
        this.voteOptionId = voteOptionId;

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

    public int getVoteOptionId() {
        return voteOptionId;
    }

    public void setVoteOptionId(int voteOptionId) {
        this.voteOptionId = voteOptionId;
    }
}



