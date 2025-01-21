package org.example;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class App {
    public static void main(String[] args) {
        System.out.println("Starting embedded Tomcat server...");

        // Create a Tomcat instance
        Tomcat tomcat = new Tomcat();

        // Set the port for the server
        tomcat.setPort(8090);

        // Add a context with a valid temporary directory as docBase
        String tempDir = System.getProperty("java.io.tmpdir");
        Context context = tomcat.addContext("", tempDir);
        System.out.println("Context added: " + tempDir);

        // Add the servlet to the context
        Tomcat.addServlet(context, "helloServlet", new HelloServlet());
        context.addServletMappingDecoded("/hello", "helloServlet");

        // Start the Tomcat server
        try {
            tomcat.start();
            System.out.println("Tomcat started at http://localhost:8080/hello");
            // Keep the server running
            tomcat.getServer().await();
        } catch (LifecycleException e) {
            e.printStackTrace();
            System.err.println("Failed to start Tomcat: " + e.getMessage());
        }
    }
}
