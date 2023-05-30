package com.jay.springboot.myfirstspringwebapp.todo;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
