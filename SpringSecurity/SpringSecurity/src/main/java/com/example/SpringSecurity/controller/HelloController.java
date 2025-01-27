package com.example.SpringSecurity.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/")
public class HelloController {
	@GetMapping("/hello")
	public String helloMethod(HttpServletRequest req) {
		return "Hello Welcome .... To My World....!!"+req.getSession().getId();
	}
	@GetMapping("/about")
	public String aboutMethod(HttpServletRequest req) {
		return "Hello Welcome .... This is GOPI KARTHIK....!!"+req.getSession().getId();
	}
	@GetMapping("/cart")
	public String cartMethod(HttpServletRequest req) {
		return "Hello Welcome .... This is CART OF YOUR INTRESTS....!!"+req.getSession().getId();
	}
	

}
