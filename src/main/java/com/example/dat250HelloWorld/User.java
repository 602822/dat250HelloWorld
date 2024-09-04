package com.example.dat250HelloWorld;

import java.util.ArrayList;
import java.util.List;

public class User {
    String username;
    String email;
    List<Vote> votes;

    public User(String username, String email, List<Vote> votes) {
        this.username = username;
        this.email = email;
        this.votes = votes;
    }

    public User() {
    votes = new ArrayList<>();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", votes=" + votes +
                '}';
    }
}
