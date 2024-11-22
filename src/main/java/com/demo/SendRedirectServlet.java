package com.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/portal.do")
public class SendRedirectServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String param = request.getParameter("site");
        if (param.equals("naver")) {
            response.sendRedirect("http://www.naver.com");
        } else if (param.equals("google")) {
            response.sendRedirect("http://www.google.com");
        }
    }
}
