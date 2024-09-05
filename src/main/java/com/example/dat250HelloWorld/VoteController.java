package com.example.dat250HelloWorld;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class VoteController {

    private final PollManager pollManager;

    public VoteController(PollManager pollManager) {
        this.pollManager = pollManager;
    }

    @GetMapping("/users/{username}/votes")
    public ResponseEntity<List<Vote>> getUserVotes(@PathVariable String username) {
        HashMap<String, User> users = pollManager.users;
        if (users.containsKey(username)) {
            User user = users.get(username);
            List<Vote> votes = user.getVotes();
            return new ResponseEntity<>(votes, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PostMapping("/users/{username}/votes")
    public ResponseEntity<Vote> createUserVote(@PathVariable String username, @RequestBody Vote vote) {
        HashMap<String, User> users = pollManager.users;
        if (users.containsKey(username)) {
            User user = users.get(username);
            List<Vote> votes = user.getVotes();
            votes.add(vote);
            return new ResponseEntity<>(vote, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/users/{username}/votes/{id}")
    public ResponseEntity<Vote> updateUserVote(@PathVariable String username, @RequestBody Vote vote, @PathVariable int id) {
        HashMap<String, User> users = pollManager.users;
        if (users.containsKey(username)) {
            User user = users.get(username);
            List<Vote> votes = user.getVotes();
            votes.set(id, vote);
            return new ResponseEntity<>(vote, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }






}
