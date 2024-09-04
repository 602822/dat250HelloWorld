package com.example.dat250HelloWorld;

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
    public ResponseEntity<String> deleteUser(@PathVariable String username) {
        HashMap<String, User> users = pollManager.getUsers();
        if(users.containsKey(username)) {
            users.remove(username);
            return ResponseEntity.status(200).body("user with username: " + username + " was deleted.");
        }
        return ResponseEntity.status(404).body("user with username: " + username + " was not found.");
    }

    @DeleteMapping("/users")
    public ResponseEntity<String> deleteUsers() {
        HashMap<String, User> users = pollManager.getUsers();
        users.clear();
        return ResponseEntity.status(200).body("all users deleted.");

    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        HashMap<String, User> users = pollManager.getUsers();
        String username = user.getUsername();
        if(users.containsKey(username)) {
            users.put(username, user);
            return ResponseEntity.status(200).body(user);
        }
        return ResponseEntity.status(404).body(null);

    }




}
