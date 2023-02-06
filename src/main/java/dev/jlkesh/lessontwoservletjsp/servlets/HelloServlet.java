package dev.jlkesh.lessontwoservletjsp.servlets;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet",
        // value = "/home",
        urlPatterns = {"/home", "/main"}
)
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        out.println("<h1>" + message + "</h1>");
        // a();
        // raise event
    }

    public void destroy() {
    }
}