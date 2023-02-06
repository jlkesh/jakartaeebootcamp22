package dev.jlkesh.lessontwoservletjsp.servlets.student;

import dev.jlkesh.lessontwoservletjsp.dao.StudentDao;
import dev.jlkesh.lessontwoservletjsp.domain.Student;
import dev.jlkesh.lessontwoservletjsp.dto.StudentCreateDTO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.time.Clock;
import java.time.ZonedDateTime;
import java.util.List;

@WebServlet(name = "StudentServlet", value = "/students")
public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentDao studentDao = StudentDao.getInstance();
        request.setAttribute("current_time", ZonedDateTime.now(Clock.systemDefaultZone()));
        request.setAttribute("students", studentDao.findAll());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/students/students.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!req.getMethod().equalsIgnoreCase("get"))
            resp.sendError(405, "Method not allowed");
        else
            super.service(req, resp);
    }

}
