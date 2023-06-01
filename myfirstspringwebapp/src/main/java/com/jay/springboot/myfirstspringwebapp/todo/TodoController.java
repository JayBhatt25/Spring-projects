package com.jay.springboot.myfirstspringwebapp.todo;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

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
		//Sorting list by target date
		todos.sort(new Comparator<Todo>() {

			@Override
			public int compare(Todo o1, Todo o2) {
				// TODO Auto-generated method stub
			
				return o1.getTargetDate().compareTo(o2.getTargetDate());
			}
		});
		model.addAttribute("todos", todos);
		return "todos";
	}
	
	@RequestMapping(value="add-todo", method=RequestMethod.GET)
	public String goToAddTodoPageo(ModelMap model) {
		String username = (String)model.get("name");
		Todo todo = new Todo(0,username,"", LocalDate.now().plusYears(1), false);
		model.put("todo", todo);
		return "addTodo";
	}
	
	@RequestMapping(value="add-todo", method=RequestMethod.POST)
	public String createNewTodo(ModelMap model,@Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "addTodo";
		}
		String username = (String)model.get("name");
		todoService.addNewTodo(username, todo.getDescription(), todo.getTargetDate(), false);
		return "redirect:list-todos";
	}
	
	@RequestMapping(value="delete-todo", method=RequestMethod.GET)
	public String deleteTodo(@RequestParam long id ,ModelMap model) {
		todoService.deleteTodoById(id);
		return "redirect:list-todos";
	}
	
	@RequestMapping(value="update-todo", method=RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam long id ,ModelMap model) {
		Todo todo = todoService.findById(id);
		model.put("todo", todo);
		return "addTodo";
	}
	
	@RequestMapping(value="update-todo", method=RequestMethod.POST)
	public String updateTodo(ModelMap model,@Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "addTodo";
		}
		String username = (String)model.get("name");
		todo.setUsername(username);
		todoService.updateTodo(todo);
		return "redirect:list-todos";
	}
}
