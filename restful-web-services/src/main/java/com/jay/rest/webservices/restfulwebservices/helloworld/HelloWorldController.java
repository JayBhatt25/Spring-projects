package com.jay.rest.webservices.restfulwebservices.helloworld;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@Bean
	@GetMapping("/hello")
	public String helloWorld() {
		return "Hello World";
	}
}
