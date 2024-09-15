package com.example.dat250HelloWorld.controllers;

import com.example.dat250HelloWorld.PollManager;
import com.example.dat250HelloWorld.models.Poll;
import com.example.dat250HelloWorld.models.VoteOption;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class PollController {

    private final PollManager pollManager;
    int id = 0;

    public PollController(PollManager pollManager) {
        this.pollManager = pollManager;
    }


    @PostMapping("/polls")
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
    public ResponseEntity<HashMap<Integer, Poll>> deletePolls() {
        HashMap<Integer, Poll> polls = pollManager.getPolls();
        polls.clear();
        return new ResponseEntity<>(polls, HttpStatus.OK);
    }

    @DeleteMapping("/polls/{pollId}")
    public ResponseEntity<HashMap<Integer, Poll>> deletePollById(@PathVariable int pollId) {
        HashMap<Integer, Poll> polls = pollManager.getPolls();
        if (polls.containsKey(pollId)) {
            polls.remove(pollId);
            return new ResponseEntity<>(polls, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @GetMapping("/polls")
    public ResponseEntity<HashMap<Integer, Poll>> getPolls() {
        HashMap<Integer, Poll> polls = pollManager.getPolls();
        return new ResponseEntity<>(polls, HttpStatusCode.valueOf(200));

    }

    @PutMapping("/polls/{pollId}")
    public ResponseEntity<HashMap<Integer, Poll>> updatePoll(@RequestBody Poll poll, @PathVariable int pollId) {
        if (poll != null) {
            HashMap<Integer, Poll> polls = pollManager.getPolls();
            polls.put(pollId, poll);
            return new ResponseEntity<>(polls, HttpStatusCode.valueOf(200));
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    @GetMapping("/polls/{pollId}")
    public ResponseEntity<Poll> getPollById(@PathVariable int pollId) {
        HashMap<Integer, Poll> polls = pollManager.getPolls();
        if (polls.containsKey(pollId)) {
            return new ResponseEntity<>(polls.get(pollId), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/polls/{pollId}/{voteOptionId}/increase")
    public ResponseEntity<HashMap<Integer, Poll>> increaseVotesPoll(@RequestBody Poll poll, @PathVariable int pollId, @PathVariable int voteOptionId) {
        if (poll != null) {
            List<VoteOption> options = poll.getOptions();

            for (VoteOption option : options) {
                if (option.getPresentationOrder() == voteOptionId) {
                    option.setNumberOfVotes(option.getNumberOfVotes() + 1);
                    break;
                }
            }


            HashMap<Integer, Poll> polls = pollManager.getPolls();
            polls.put(pollId, poll);
            return new ResponseEntity<>(polls, HttpStatusCode.valueOf(200));
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    @PutMapping("/polls/{pollId}/{voteOptionId}/decrease")
    public ResponseEntity<HashMap<Integer, Poll>> decreaseVotesPoll(@RequestBody Poll poll, @PathVariable int pollId, @PathVariable int voteOptionId) {
        if (poll != null) {
            List<VoteOption> options = poll.getOptions();

            for (VoteOption option : options) {
                if (option.getPresentationOrder() == voteOptionId) {
                    int currentNumberOfVotes = option.getNumberOfVotes();
                    if (currentNumberOfVotes > 0) {
                        option.setNumberOfVotes(option.getNumberOfVotes() - 1);
                    }
                    break;
                }
            }
            HashMap<Integer, Poll> polls = pollManager.getPolls();
            polls.put(pollId, poll);
            return new ResponseEntity<>(polls, HttpStatusCode.valueOf(200));
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

}
