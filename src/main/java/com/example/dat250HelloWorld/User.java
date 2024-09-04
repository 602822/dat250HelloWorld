package com.example.dat250HelloWorld;

import java.util.ArrayList;
import java.util.List;

public class User {
    String username;
    String email;
    List<Poll> userPolls;

    public User(String username, String email, List<Poll> userPolls) {
        this.username = username;
        this.email = email;
        this.userPolls = userPolls;
    }

    public User() {
        userPolls = new ArrayList<Poll>();
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

    public List<Poll> getUserPolls() {
        return userPolls;
    }

    public void setUserPolls(List<Poll> userPolls) {
        this.userPolls = userPolls;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", userPolls=" + userPolls +
                '}';
    }
}
