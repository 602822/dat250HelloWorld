package com.example.dat250HelloWorld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VoteController {


    @GetMapping("/users/{username}/vote")
    public String vote(@PathVariable String username) {

    }




}
