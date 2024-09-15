package com.example.dat250HelloWorld.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class User {
    String username;
    String email;
    HashMap<String, Vote> votes;

    public User(String username, String email, HashMap<String,Vote> votes) {
        this.username = username;
        this.email = email;
        this.votes = votes;
    }

    public User() {
    votes = new HashMap<>();
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

    public HashMap<String, Vote> getVotes() {
        return votes;
    }

    public void setVotes(HashMap<String, Vote> votes) {
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
