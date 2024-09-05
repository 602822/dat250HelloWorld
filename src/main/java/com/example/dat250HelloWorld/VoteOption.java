package com.example.dat250HelloWorld;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class VoteOption {
    String caption;
    int presentationOrder = 0;

    @JsonCreator
    public VoteOption(@JsonProperty("caption") String caption) {
        this.caption = caption;
        this.presentationOrder++;
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
}
