package com.example.dat250HelloWorld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Dat250HelloWorldApplication {

	public static void main(String[] args) {
		SpringApplication.run(Dat250HelloWorldApplication.class, args);
	}

	@GetMapping("/hello/{name}")
	public String hello(@PathVariable String name) {
		return String.format("Hello %s!", name);

	}
}
