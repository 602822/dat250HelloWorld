package com.example.dat250HelloWorld;

import org.springframework.stereotype.Component;

import java.util.HashMap;


@Component
public class PollManager {
    HashMap<String, User> users;

    HashMap<Integer, Poll> polls;

    public PollManager(HashMap<String, User> users, HashMap<Integer, Poll> polls) {
        this.users = users;
        this.polls = polls;
    }

    public PollManager() {
        users = new HashMap<>();
        polls = new HashMap<>();
    }


    public HashMap<String,User> getUsers() {
        return users;
    }

    public void setUsers(HashMap<String, User> users) {
        this.users = users;
    }

    public HashMap<Integer, Poll> getPolls() {
        return polls;
    }

    public void setPolls(HashMap<Integer, Poll> polls) {
        this.polls = polls;
    }
}
