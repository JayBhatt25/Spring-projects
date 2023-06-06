package com.jay.springboot.myfirstspringwebapp.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name") // We want to access the value of name globally inside this controller
public class WelcomeController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String goToWelcomePage(ModelMap model) {
		model.put("name", getCurrentUsername());
		return "welcome";
	}
	
	private String getCurrentUsername() {
		 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		 return authentication.getName();
	}
}
