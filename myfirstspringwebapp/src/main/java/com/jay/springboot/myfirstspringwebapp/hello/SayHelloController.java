package com.jay.springboot.myfirstspringwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {
	
	@RequestMapping("say-hello") // endpoint name is say-hello
	@ResponseBody // Returns the result returned by the method as it is
	public String sayHello() {
		return "Hello!";
	}
	
	//JSP is a view technology
	// All jsp files need to be inside the path below -
	// /src/main/resources/META-INF/resources/WEB-INF/jsp/<file-name>.jsp
	
	@RequestMapping("say-hello-jsp") // endpoint name is say-hello
	public String sayHelloJsp() {
		return "sayHello";
	}
}
