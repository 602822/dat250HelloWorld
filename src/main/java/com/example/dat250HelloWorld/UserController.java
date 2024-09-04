package com.example.dat250HelloWorld;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;



@RestController
public class UserController {

    private final PollManager pollManager;

    public UserController(PollManager pollManager) {
        this.pollManager = pollManager;
    }


    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
       HashMap<String,User> users = pollManager.getUsers();
        String username = user.getUsername();
        users.put(username, user);
        pollManager.setUsers(users);
        return ResponseEntity.status(201).body(user);
    }

    @GetMapping("/users")
    public ResponseEntity<HashMap<String,User>> getUsers() {
        HashMap<String, User> users = pollManager.getUsers();
        System.out.println(users);
        return ResponseEntity.ok(users);
    }


}
