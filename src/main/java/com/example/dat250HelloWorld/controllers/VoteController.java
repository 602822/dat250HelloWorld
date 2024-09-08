package com.example.dat250HelloWorld.controllers;

import com.example.dat250HelloWorld.PollManager;
import com.example.dat250HelloWorld.models.User;
import com.example.dat250HelloWorld.models.Vote;
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
        HashMap<String, User> users = pollManager.getUsers();
        if (users.containsKey(username)) {
            User user = users.get(username);
            List<Vote> votes = user.getVotes();
            return new ResponseEntity<>(votes, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PostMapping("/users/{username}/votes")
    public ResponseEntity<Vote> createUserVote(@PathVariable String username, @RequestBody Vote vote) {
        HashMap<String, User> users = pollManager.getUsers();
        if (users.containsKey(username)) {
            User user = users.get(username);
            List<Vote> votes = user.getVotes();
            votes.add(vote);
            return new ResponseEntity<>(vote, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/users/{username}/votes/{voteId}")
    public ResponseEntity<Vote> updateUserVote(@PathVariable String username, @RequestBody Vote vote, @PathVariable int voteId) {
        HashMap<String, User> users = pollManager.getUsers();
        if (users.containsKey(username)) {
            User user = users.get(username);
            List<Vote> votes = user.getVotes();
            votes.set(voteId, vote);
            return new ResponseEntity<>(vote, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/users/{username}/votes")
    public ResponseEntity<List<Vote>> deleteUserVotes(@PathVariable String username) {
        HashMap<String, User> users = pollManager.getUsers();
        if (users.containsKey(username)) {
            User user = users.get(username);
            List<Vote> votes = user.getVotes();
            votes.clear();
            return new ResponseEntity<>(votes, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/users/{username}/votes/{voteId}")
    public ResponseEntity<List<Vote>> deleteUserVoteById(@PathVariable String username, @PathVariable int voteId) {
        HashMap<String, User> users = pollManager.getUsers();
        if (users.containsKey(username)) {
            User user = users.get(username);
            List<Vote> votes = user.getVotes();
            if(votes.get(voteId) != null) {
                votes.remove(voteId);
                return new ResponseEntity<>(votes, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/users/{username}/votes/{voteId}")
    public ResponseEntity<Vote> getUserVoteById(@PathVariable String username, @PathVariable int voteId) {
        HashMap<String, User> users = pollManager.getUsers();
        if (users.containsKey(username)) {
            User user = users.get(username);
            List<Vote> votes = user.getVotes();
            if(votes.get(voteId) != null) {
                Vote vote = votes.get(voteId);
                return new ResponseEntity<>(vote, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }





}
