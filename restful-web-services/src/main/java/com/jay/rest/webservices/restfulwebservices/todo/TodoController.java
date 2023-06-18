package com.jay.rest.webservices.restfulwebservices.todo;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



import jakarta.validation.Valid;

@RestController
@CrossOrigin
public class TodoController {
	
private TodoRepository repository;
	
	public TodoController(TodoRepository todoRepository) {
		super();
		this.repository = todoRepository;
	}
	
	
	@GetMapping("/")
	public String mappingForRootPath() {
		return "Success";
	}
	
	@GetMapping("/basicAuth")
	public String basicAuth() {
		return "Success";
	}

	@GetMapping("/users/{username}/todos")
	public List<Todo> retrieveTodos(@PathVariable String username) {

		List<Todo> todos = repository.findByUsername(username);
		//Sorting list by target date
		todos.sort(new Comparator<Todo>() {

			@Override
			public int compare(Todo o1, Todo o2) {
				// TODO Auto-generated method stub
			
				return o1.getTargetDate().compareTo(o2.getTargetDate());
			}
		});
		
		return todos;
	}
	
	@GetMapping("/users/{username}/todos/{id}")
	public Todo retrieveTodoById(@PathVariable String username, @PathVariable long id) {
		return repository.findById(id).orElse(null);
	}
	
	@DeleteMapping("/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodoById(@PathVariable String username, @PathVariable long id) {
		 repository.deleteById(id);
		 return ResponseEntity.noContent().build();
		
	}
	
	@PutMapping("/users/{username}/todos/{id}")
	public Todo updateTodo(@PathVariable String username, @PathVariable long id, @RequestBody Todo todo) {
		todo.setUsername(username);
		todo.setId(id);
		todo.setDone(false);
		return repository.save(todo);
	}
	
	@PostMapping("/users/{username}/todos")
	public Todo updateTodo(@PathVariable String username, @RequestBody Todo todo) {
		todo.setUsername(username);
		todo.setDone(false);
		LocalDate.parse(todo.getTargetDate().toString());
		return repository.save(todo);
		
	}
	
	@PatchMapping("/users/{username}/todos/{id}")
	public boolean ToggleDone(@PathVariable String username, @PathVariable long id) {
		Todo todo = repository.findById(id).orElse(null);
		if(todo == null) return false;
		if(todo.isDone()) {
			todo.setDone(false);
		} else {
			todo.setDone(true);
		}
		repository.save(todo);
		return true;
	}
	
	
}
