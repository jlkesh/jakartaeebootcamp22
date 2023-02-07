package dev.jlkesh.lessontwoservletjsp.servlets.student;

import dev.jlkesh.lessontwoservletjsp.dao.StudentDao;
import dev.jlkesh.lessontwoservletjsp.domain.Student;
import dev.jlkesh.lessontwoservletjsp.dto.StudentUpdateDTO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.extern.java.Log;

import java.io.IOException;

@Log
@WebServlet(name = "StudentUpdateServlet", urlPatterns = "/students/update/*")
public class StudentUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentDao studentDao = StudentDao.getInstance();
        String pathInfo = request.getPathInfo();
        long studentID = Long.parseLong(pathInfo.substring(1));
        Student student = studentDao.findById(studentID);
        request.setAttribute("student", student);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/students/update.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentDao studentDao = StudentDao.getInstance();
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        short age = Short.parseShort(request.getParameter("age"));
        Long id = Long.parseLong(request.getParameter("id"));
        StudentUpdateDTO studentUpdateDTO = new StudentUpdateDTO(id, firstName, lastName, age);
        studentDao.update(studentUpdateDTO);
        response.sendRedirect("/students");
    }
}
