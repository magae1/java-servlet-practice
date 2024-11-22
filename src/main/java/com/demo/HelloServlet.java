package com.demo;

import java.io.*;
import java.util.Enumeration;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        System.out.println("init() 호출됨");
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println(">>> " + request.getContentLength());
        System.out.println("doGet() 호출됨");
        response.setContentType("text/html");
        System.out.println(message);
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<button> 버튼 </button>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}