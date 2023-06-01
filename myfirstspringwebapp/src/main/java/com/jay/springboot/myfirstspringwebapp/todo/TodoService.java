package com.jay.springboot.myfirstspringwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
	
	private static int todosCount = 0;
	
	private static List<Todo> todos = new ArrayList<Todo>();
	static {
		todos.add(new Todo(++todosCount, "Jay Bhatt", "Learn Spring", LocalDate.now().plusDays(7), false));
		todos.add(new Todo(++todosCount, "Jay Bhatt", "Learn GraphQL", LocalDate.now().plusDays(14), false));
		todos.add(new Todo(++todosCount, "Jay Bhatt", "Learn Angular", LocalDate.now().plusDays(21), false));
		todos.add(new Todo(++todosCount, "Jay Bhatt", "Learn Vue", LocalDate.now().plusDays(28), false));
	}
	
	public List<Todo> findByUsername(String username){
		return todos;
	}
	
	public void addNewTodo(String username, String description, LocalDate targetDate, boolean done){
		Todo todo = new Todo(++todosCount, username, description, targetDate, done);
		todos.add(todo);
		return;
	}
	
	public void deleteTodoById(long id){
		// lambda function used to select item to remove = todo -> todo.getId() == id
		Predicate<? super Todo> predicate = todo -> todo.getId() == id ;
		todos.removeIf(predicate);
		return;
	}

	public Todo findById(long id) {
		// TODO Auto-generated method stub
		Predicate<? super Todo> predicate = todo -> todo.getId() == id ;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void updateTodo(@Valid Todo todo) {
		// TODO Auto-generated method stub
		deleteTodoById(todo.getId());
		todos.add(todo);
	}
		
}
