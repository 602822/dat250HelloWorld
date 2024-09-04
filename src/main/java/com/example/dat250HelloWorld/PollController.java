package com.example.dat250HelloWorld;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class PollController {

    private final PollManager pollManager;
    int id = 0;

    public PollController(PollManager pollManager) {
        this.pollManager = pollManager;
    }


    @PostMapping("/pools")
    public ResponseEntity<Poll> createPoll(@RequestBody Poll poll) {

        HashMap<Integer, Poll> polls = pollManager.getPolls();

        if (poll != null) {
            polls.put(id, poll);
            id++;
            return new ResponseEntity<>(poll, HttpStatusCode.valueOf(201));
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    @DeleteMapping("/polls")
    public ResponseEntity<Poll> deletePolls() {
        HashMap<Integer, Poll> polls = pollManager.getPolls();
        polls.clear();
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/polls")
    public ResponseEntity<HashMap<Integer, Poll>> getPolls() {
        HashMap<Integer, Poll> polls = pollManager.getPolls();
        return new ResponseEntity<>(polls, HttpStatusCode.valueOf(200));

    }

    @PutMapping("/polls/{id}")
    public ResponseEntity<HashMap<Integer, Poll>> updatePoll(@RequestBody Poll poll, @PathVariable int id) {
       if(poll != null) {
           HashMap<Integer, Poll> polls = pollManager.getPolls();
           polls.put(id, poll);
           return new ResponseEntity<>(polls, HttpStatusCode.valueOf(200));
       }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }


}
