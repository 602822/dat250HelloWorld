package com.example.dat250HelloWorld;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class PollController {

    private final PollManager pollManager;

    public PollController(PollManager pollManager) {
        this.pollManager = pollManager;
    }


    @PostMapping("/users/{username}/pools")
    public ResponseEntity<Poll> createPoll(@RequestBody Poll poll, @PathVariable String username) {

        HashMap<String, User> users = pollManager.getUsers();
        User user = users.get(username);

        if (user != null) {
            List<Poll> userPolls = user.getUserPolls();
            userPolls.add(poll);
            user.setUserPolls(userPolls);

            return new ResponseEntity<>(poll, HttpStatusCode.valueOf(201));
        }

        return new ResponseEntity<>(HttpStatusCode.valueOf(404));

    }

    @DeleteMapping("/users/{username}/polls")
    public ResponseEntity<Poll> deleteUserPolls(@PathVariable String username) {
        HashMap<String, User> users = pollManager.getUsers();
        User user = users.get(username);
        if (user != null) {
            List<Poll> userPolls = user.getUserPolls();
            userPolls.clear();
            return new ResponseEntity<>(HttpStatusCode.valueOf(204));
        }
        return new ResponseEntity<>(HttpStatusCode.valueOf(404));
    }

    @DeleteMapping("/users/{username}/polls/{id}")
    public ResponseEntity<Poll> deleteUserPollById(@PathVariable String username, @PathVariable int id) {
        HashMap<String, User> users = pollManager.getUsers();
        User user = users.get(username);
        if (user != null) {
            List<Poll> userPolls = user.getUserPolls();
            Poll poll = userPolls.remove(id);
            return new ResponseEntity<>(poll, HttpStatusCode.valueOf(200));
        }
        return new ResponseEntity<>(HttpStatusCode.valueOf(404));
    }


    @GetMapping("/users/{username}/polls")
    public ResponseEntity<List<Poll>> getUserPolls(@PathVariable String username) {
        HashMap<String, User> users = pollManager.getUsers();
        User user = users.get(username);
        if (user != null) {
            List<Poll> userPolls = user.getUserPolls();
            return new ResponseEntity<>(userPolls, HttpStatusCode.valueOf(200));
        }
        return new ResponseEntity<>(HttpStatusCode.valueOf(404));
    }

    @GetMapping("/users/{username}/polls/{id}")
    public ResponseEntity<Poll> getUserPollById(@PathVariable String username, @PathVariable int id) {
        HashMap<String, User> users = pollManager.getUsers();
        User user = users.get(username);
        if (user != null) {
            Poll poll = user.getUserPolls().get(id);
            return new ResponseEntity<>(poll, HttpStatusCode.valueOf(200));
        }
        return new ResponseEntity<>(HttpStatusCode.valueOf(404));
    }


}
