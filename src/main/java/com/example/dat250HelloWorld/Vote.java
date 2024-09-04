package com.example.dat250HelloWorld;
import java.time.Instant;

public class Vote {
    Instant publishedAt;

    public Vote(Instant publishedAt) {
        this.publishedAt = publishedAt;
    }

    public Vote() {
    }

    public Instant getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Instant publishedAt) {
        this.publishedAt = publishedAt;
    }
}
