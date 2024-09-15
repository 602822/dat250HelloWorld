package com.example.dat250HelloWorld.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class VoteOption {
    String caption;
    int presentationOrder;
    int numberOfVotes;


    @JsonCreator
    public VoteOption(@JsonProperty("caption") String caption, @JsonProperty("presentationOrder") int presentationOrder) {
        this.caption = caption;
        this.presentationOrder = presentationOrder;
        numberOfVotes = 0;
    }

    public VoteOption() {
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public int getPresentationOrder() {
        return presentationOrder;
    }

    public void setPresentationOrder(int presentationOrder) {
        this.presentationOrder = presentationOrder;
    }

    public int getNumberOfVotes() {
        return numberOfVotes;
    }

    public void setNumberOfVotes(int numberOfVotes) {
        this.numberOfVotes = numberOfVotes;
    }
}
