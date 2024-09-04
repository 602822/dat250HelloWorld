package com.example.dat250HelloWorld;

import org.springframework.stereotype.Component;

import java.util.HashMap;


@Component
public class PollManager {
    HashMap<String, User> users;

    public PollManager(HashMap<String, User> users) {
        this.users= users;
    }

    public PollManager() {
        users = new HashMap<>();
    }


    public HashMap<String,User> getUsers() {
        return users;
    }

    public void setUsers(HashMap<String, User> users) {
        this.users = users;
    }
}
