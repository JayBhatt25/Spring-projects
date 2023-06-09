package com.jay.springboot.myfirstspringwebapp.todo;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoResource {
	TodoRepository repository;
	
	public TodoResource(TodoRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/users/{username}/todos")
	public List<Todo> retrieveTodos(@PathVariable String username) {
		return repository.findByUsername(username);
	}
}
