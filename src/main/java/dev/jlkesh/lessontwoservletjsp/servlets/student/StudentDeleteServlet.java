package dev.jlkesh.lessontwoservletjsp.servlets.student;

import dev.jlkesh.lessontwoservletjsp.dao.StudentDao;
import dev.jlkesh.lessontwoservletjsp.domain.Student;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "StudentDeleteServlet", urlPatterns = "/students/delete/*")
public class StudentDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentDao studentDao = StudentDao.getInstance();
        String pathInfo = request.getPathInfo();
        long studentID = Long.parseLong(pathInfo.substring(1));
        Student student = studentDao.findById(studentID);
        request.setAttribute("student", student);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/students/delete.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentDao studentDao = StudentDao.getInstance();
        studentDao.deleteById(Long.parseLong(request.getParameter("id")));
        response.sendRedirect("/students");
    }
}
