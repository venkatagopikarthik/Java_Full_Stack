package org.example;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {
    
    protected void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
        // Log to the console
        System.out.println("Handling GET request...");

        // Set the content type for the response
        res.setContentType("text/plain");

        // Write a response message
        res.getWriter().write("Hello, World! This is a servlet running on embedded Tomcat.");
    }
}
