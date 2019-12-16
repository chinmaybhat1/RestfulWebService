package com.rest.webservice.restfulwebservices.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class HelloWorldController {

	@Autowired
	private MessageSource messageSource;

	@GetMapping("/hello-world")
	public String helloWorld() {
		return "Hello World";
	}

	@GetMapping("/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World");
	}

	@GetMapping("/hello/{name}")
	public HelloWorldBean helloUser(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello %s", name));
	}

	@GetMapping("/hello-internationalized")
	public String helloInternationalized(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
		return messageSource.getMessage("good.morning.message", null, locale);
	}
}
