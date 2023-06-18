package com.jay.rest.webservices.restfulwebservices.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
public class BasicAuthenticationSecurityConfig {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http ) throws Exception {
		http.authorizeHttpRequests(
				auth -> auth
				.requestMatchers(HttpMethod.OPTIONS,"/**").permitAll()  // the frontend sends options request first before any other,so we need to enable it
				.anyRequest().authenticated()
				);
		// httpBasic is included because we want a popup to appear for username and password instead of an entire dedicated page
		http.httpBasic(Customizer.withDefaults());
		
		// We want to disable csrf, so it is essential to make the app stateless
		http.sessionManagement(
				session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				);
		
		http.csrf(csrf -> csrf.disable());
		return http.build();
	}
}
