package com.demo;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/dispatcher1")
public class DispatcherServlet1 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("msg", "테스트1에서 왔어요");
        PrintWriter out = response.getWriter();
        out.print("<h3>Dispatcher Test1 수행 결과 </h3>");
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/dispatcher2");
        rd.include(request, response);
        out.close();
    }
}
