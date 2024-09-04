package com.example.dat250HelloWorld;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

        HashMap<String, User> users = pollManager.getUserPolls();
        User user = users.get(username);

      if (user != null) {
          List<Poll> userPolls = user.getUserPolls();
          userPolls.add(poll);
          user.setUserPolls(userPolls);

          return new ResponseEntity<>(poll, HttpStatusCode.valueOf(201));
      }

      return  new ResponseEntity<>(HttpStatusCode.valueOf(404));



    }



}
