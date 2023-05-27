package com.jay.springboot.learnspringboot;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;




@ConfigurationProperties(prefix = "currency-services")
@Component
public class CurrencyServicesConfiguration {
	
String url, name, key;
	
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	
}
