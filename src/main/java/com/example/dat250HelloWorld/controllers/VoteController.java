package com.example.dat250HelloWorld.controllers;

import com.example.dat250HelloWorld.PollManager;
import com.example.dat250HelloWorld.models.User;
import com.example.dat250HelloWorld.models.Vote;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;


@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class VoteController {

    private final PollManager pollManager;

    public VoteController(PollManager pollManager) {
        this.pollManager = pollManager;
    }

    @GetMapping("/users/{username}/votes")
    public ResponseEntity<HashMap<String, Vote>> getUserVotes(@PathVariable String username) {
        HashMap<String, User> users = pollManager.getUsers();
        if (users.containsKey(username)) {
            User user = users.get(username);
            HashMap<String, Vote> votes = user.getVotes();
            return new ResponseEntity<>(votes, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PostMapping("/users/{username}/votes")
    public ResponseEntity<Vote> createUserVote(@PathVariable String username, @RequestBody Vote vote) {
        HashMap<String, User> users = pollManager.getUsers();
        if (users.containsKey(username)) {
            User user = users.get(username);
            HashMap<String, Vote> votes = user.getVotes();
            int pollId = vote.getPollId();
            int voteOptionId = vote.getVoteOptionId();
            votes.put(pollId + String.valueOf(voteOptionId), vote);
            return new ResponseEntity<>(vote, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/users/{username}/votes/")
    public ResponseEntity<Vote> updateUserVote(@PathVariable String username, @RequestBody Vote vote) {
        HashMap<String, User> users = pollManager.getUsers();
        if (users.containsKey(username)) {
            User user = users.get(username);
            HashMap<String, Vote> votes = user.getVotes();
            int voteOptionId = vote.getVoteOptionId();
            int pollId = vote.getPollId();
            votes.put(pollId + String.valueOf(voteOptionId), vote);
            return new ResponseEntity<>(vote, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/users/{username}/votes")
    public ResponseEntity<HashMap<String, Vote>> deleteUserVotes(@PathVariable String username) {
        HashMap<String, User> users = pollManager.getUsers();
        if (users.containsKey(username)) {
            User user = users.get(username);
            HashMap<String, Vote> votes = user.getVotes();
            votes.clear();
            return new ResponseEntity<>(votes, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/users/{username}/votes/{pollId}/{voteOptionId}")
    public ResponseEntity<HashMap<String, Vote>> deleteUserVoteById(@PathVariable String username, @PathVariable int pollId, @PathVariable int voteOptionId) {
        HashMap<String, User> users = pollManager.getUsers();
        if (users.containsKey(username)) {
            User user = users.get(username);
            HashMap<String, Vote> votes = user.getVotes();

            String id = pollId + String.valueOf(voteOptionId);

            if (votes.get(id) != null) {
                votes.remove(id);
                return new ResponseEntity<>(votes, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/users/{username}/votes/")
    public ResponseEntity<Vote> getUserVoteById(@PathVariable String username, int pollId, int voteOptionId) {
        HashMap<String, User> users = pollManager.getUsers();
        if (users.containsKey(username)) {
            User user = users.get(username);
            HashMap<String, Vote> votes = user.getVotes();
            String id = pollId + String.valueOf(voteOptionId);
            if (votes.get(id) != null) {
                Vote vote = votes.get(id);
                return new ResponseEntity<>(vote, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
