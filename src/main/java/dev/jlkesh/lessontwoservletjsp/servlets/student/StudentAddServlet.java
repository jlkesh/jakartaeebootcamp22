package dev.jlkesh.lessontwoservletjsp.servlets.student;

import dev.jlkesh.lessontwoservletjsp.dao.StudentDao;
import dev.jlkesh.lessontwoservletjsp.dto.StudentCreateDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.java.Log;

import java.io.IOException;


@Log
@WebServlet(name = "StudentAddServlet", value = "/students/add")
public class StudentAddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/students/add.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentDao studentDao = StudentDao.getInstance();
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        short age = Short.parseShort(req.getParameter("age"));
        studentDao.save(new StudentCreateDTO(firstName, lastName, age));
        log.info("Student added [Name : %s, Age : %s]".formatted(firstName + " " + lastName, age));
        resp.sendRedirect("/students");
    }
}
