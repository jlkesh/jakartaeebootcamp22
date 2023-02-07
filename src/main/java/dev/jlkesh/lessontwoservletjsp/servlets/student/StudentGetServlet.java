package dev.jlkesh.lessontwoservletjsp.servlets.student;

import com.google.gson.Gson;
import dev.jlkesh.lessontwoservletjsp.dao.StudentDao;
import dev.jlkesh.lessontwoservletjsp.domain.Student;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "StudentGetServlet", urlPatterns = "/students/get/*")
public class StudentGetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long studentID = Long.parseLong(request.getPathInfo().substring(1));
        Student student = StudentDao.getInstance().findById(studentID);
        Gson gson = new Gson();
        String jsonDATA = gson.toJson(student);
        response.setContentType("application/json");
        response.getWriter().println(jsonDATA);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
