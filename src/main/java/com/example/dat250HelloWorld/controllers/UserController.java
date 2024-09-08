package com.example.dat250HelloWorld.controllers;

import com.example.dat250HelloWorld.PollManager;
import com.example.dat250HelloWorld.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;


@RestController
public class UserController {

    private final PollManager pollManager;

    public UserController(PollManager pollManager) {
        this.pollManager = pollManager;
    }


    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        HashMap<String, User> users = pollManager.getUsers();
        String username = user.getUsername();
        users.put(username, user);
        return ResponseEntity.status(201).body(user);
    }

    @GetMapping("/users")
    public ResponseEntity<HashMap<String, User>> getUsers() {
        HashMap<String, User> users = pollManager.getUsers();
        return ResponseEntity.ok(users);
    }

    @DeleteMapping("/users/{username}")
    public ResponseEntity<HashMap<String, User>> deleteUser(@PathVariable String username) {
        HashMap<String, User> users = pollManager.getUsers();
        if (users.containsKey(username)) {
            users.remove(username);
            return ResponseEntity.status(200).body(users);
        }
        return ResponseEntity.status(404).body(null);
    }

    @DeleteMapping("/users")
    public ResponseEntity<HashMap<String, User>> deleteUsers() {
        HashMap<String, User> users = pollManager.getUsers();
        users.clear();
        return ResponseEntity.status(200).body(users);

    }

    @PutMapping("/users/{username}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable String username) {

        HashMap<String, User> users = pollManager.getUsers();
        if (user != null) {
            users.put(username, user);
            return ResponseEntity.status(200).body(user);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @GetMapping("/users/{username}")
    public ResponseEntity<User> getUser(@PathVariable String username) {
        HashMap<String, User> users = pollManager.getUsers();
        if (users.containsKey(username)) {
            return ResponseEntity.status(200).body(users.get(username));
        }
        return ResponseEntity.status(404).body(null);
    }

}
