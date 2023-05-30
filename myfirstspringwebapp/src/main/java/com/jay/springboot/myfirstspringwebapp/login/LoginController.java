package com.jay.springboot.myfirstspringwebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name") // We want to access the value of name globally inside this controller
public class LoginController {
	
	private AuthenticationService authService;
	
	public LoginController(AuthenticationService authService) {
		super();
		this.authService = authService;
	}

	@RequestMapping(value="login", method=RequestMethod.GET)
	public String goToLoginPage() {
		return "login";
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String validateUser(@RequestParam String name, @RequestParam String password, ModelMap model) {
		if(authService.authenticate(name, password)) {
			// Any data we put into models will ONLY be accessible in the page we are returning
			model.put("name", name);
			model.put("password", password);
			return "welcome";
		}
		
		model.put("errorMessage", "Invalid credentials. Please try again.");
		return "login";
	}
}
