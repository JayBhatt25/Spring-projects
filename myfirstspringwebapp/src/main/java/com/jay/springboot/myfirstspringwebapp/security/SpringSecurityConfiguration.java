package com.jay.springboot.myfirstspringwebapp.security;


import static org.springframework.security.config.Customizer.withDefaults;
import java.util.function.Function;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
	
	
	//manually creating users
	// We are using InMemoryDetailsManager i.e created users will reset with every launch
	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {
		// Using lambda expression to encode password using our created passwordEncoder
		
		UserDetails userDetails = createNewUser("Jay", "Jay123");
		UserDetails userDetails2 = createNewUser("Messi", "Messi123");
		
		return new InMemoryUserDetailsManager(userDetails,userDetails2);
	}

	private UserDetails createNewUser(String username, String password) {
		Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input) ;
		
		UserDetails userDetails = User.builder()
		.passwordEncoder(passwordEncoder )		
		.username(username)
		.password(password)
		.roles("USER","ADMIN")
		.build();
		return userDetails;
	}
	
	// telling spring security that we want to use BCrypt password encoder
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	// spring security by default protects all urls
	// Also by default spring security does not allow html frames
	// h2-console uses frames thus when we access h2-console it shows unauthorized
	// We have to disable CSRF(cross site request forgery) to access h2-console
	// also configure to allow these frames
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests(
			auth -> auth.anyRequest().authenticated()
		);
		
		http.formLogin(withDefaults());
		
		http.csrf().disable();
		http.headers().frameOptions().disable();
		return http.build();
	}
}
