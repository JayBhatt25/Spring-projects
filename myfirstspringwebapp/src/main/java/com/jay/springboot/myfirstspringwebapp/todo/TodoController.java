package com.jay.springboot.myfirstspringwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name") // We want to access name that we got from login controller
public class TodoController {
	
	private TodoService todoService;
	
	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}



	@RequestMapping("list-todos")
	public String goToTodosPage(ModelMap model) {
		List<Todo> todos = todoService.findByUsername("Jay");
		model.addAttribute("todos", todos);
		return "todos";
	}
	
	@RequestMapping(value="add-todo", method=RequestMethod.GET)
	public String createNewTodo(ModelMap model) {
//		List<Todo> todos = todoService.findByUsername("Jay");
//		Todo todo = new Todo(todos.size() + 1,"Jay",description, LocalDate.now().plusDays(todos.size() + 1), false);
//		todos.add(todo);
//		model.addAttribute("todos", todos);
		return "addTodo";
	}
	
	@RequestMapping(value="add-todo", method=RequestMethod.POST)
	public String goToAddTodoPage(@RequestParam String description,ModelMap model) {
		description = description.strip();
		String username = (String)model.get("name");
		if(username.isEmpty()) {
			model.put("errorMessage", "Please login to add new items");
			return "login";
		} else if(description.isEmpty()) {
			model.put("errorMessage", "Description cannot be empty");
			return "addTodo";
		} else {
			List<Todo> todos = todoService.addNewTodo(username, description, LocalDate.now().plusMonths(1));
			model.addAttribute("todos", todos);
			return "redirect:list-todos";
		}
		
	}
}
