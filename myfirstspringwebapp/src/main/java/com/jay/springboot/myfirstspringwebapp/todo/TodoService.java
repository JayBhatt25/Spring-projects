package com.jay.springboot.myfirstspringwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

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
	
	public List<Todo> addNewTodo(String username, String description, LocalDate targetDate){
		Todo todo = new Todo(++todosCount, username, description, targetDate, false);
		todos.add(todo);
		return todos;
	}
}
