package com.example.SpringBootWeb1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Controller
public class HelloController {
	
//	@RequestMapping("/")
//	public String homeController() {
//		System.out.println("In home");
//		return "index.jsp";
//	}

	@RequestMapping("/")
	public String addition(HttpServletRequest req) {
		int a=Integer.parseInt(req.getParameter("n1"));
		int b=Integer.parseInt(req.getParameter("n2"));
		int res=a+b;
		req.setAttribute("result", res);
		System.out.println("in add");
		return "index.jsp";
	}
}
