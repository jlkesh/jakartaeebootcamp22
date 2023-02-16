package dev.jlkesh.lessontwoservletjsp;

import dev.jlkesh.lessontwoservletjsp.dao.StudentDAO;
import dev.jlkesh.lessontwoservletjsp.entity.Student;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "StudentServlet", value = "/StudentServlet")
public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentDAO dao = new StudentDAO();
        Student student = Student.builder()
                .fullName("Fayzullo Yusupov")
                .level(Student.Level.SOPHOMORE)
                .build();
        dao.save(student);
        response.getWriter().println(student);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
