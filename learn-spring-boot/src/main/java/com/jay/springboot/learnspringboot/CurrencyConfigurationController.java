package com.jay.springboot.learnspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConfigurationController {
	
	@Autowired
	private CurrencyServicesConfiguration config;
	
	@RequestMapping("/currency-config")
	public CurrencyServicesConfiguration retreiveConfig() {
		return config;
	}
}
