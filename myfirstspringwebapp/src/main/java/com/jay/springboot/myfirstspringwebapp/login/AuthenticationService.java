package com.jay.springboot.myfirstspringwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	
	public boolean authenticate(String name, String password) {
		
		if(name.equalsIgnoreCase("Jay") && password.equalsIgnoreCase("Jay123")) {
			return true;
		}
		return false;
	}
}
