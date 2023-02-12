package dev.jlkesh.lessontwoservletjsp.servlets;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/*@WebServlet(name = "dev.jlkesh.lessontwoservletjsp.servlets.InitParameters",
        urlPatterns = "/init",
        initParams = {
                @WebInitParam(name = "name", value = "Shengoo"),
                @WebInitParam(name = "password", value = "123")
        })*/
public class InitParameters extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.println("name = " + getServletConfig().getInitParameter("name"));
        writer.println("password = " + getServletConfig().getInitParameter("password"));
    }
}
