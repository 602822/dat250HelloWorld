package com.example.dat250HelloWorld;

import java.util.HashMap;
import java.util.List;

public class PollManager {
    HashMap<User, List<Poll>> userPolls;

    public PollManager(HashMap<User, List<Poll>> userPolls) {
        this.userPolls = userPolls;
    }

    public PollManager() {
    }

    public HashMap<User, List<Poll>> getUserPolls() {
        return userPolls;
    }

    public void setUserPolls(HashMap<User, List<Poll>> userPolls) {
        this.userPolls = userPolls;
    }
}
