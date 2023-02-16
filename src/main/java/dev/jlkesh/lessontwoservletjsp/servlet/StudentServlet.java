package dev.jlkesh.lessontwoservletjsp.servlet;

import dev.jlkesh.lessontwoservletjsp.dao.StudentDAO;
import dev.jlkesh.lessontwoservletjsp.entity.Auditable;
import dev.jlkesh.lessontwoservletjsp.entity.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@WebServlet(name = "StudentServlet", value = "/StudentServlet")
public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentDAO dao = new StudentDAO();

        int size = Integer.parseInt(Objects.requireNonNullElse(request.getParameter("size"), "10"));
        int page = Integer.parseInt(Objects.requireNonNullElse(request.getParameter("page"), "1"));

//        List<Student> students = dao.getPage(page, size);
        /*Student t = new Student();
        t.setFullName("EJ");
        t.setLevel(Student.Level.FRESHMAN);
        t.setAuditable(new Auditable());
        dao.save(t);*/
        Student student = dao.findById(1);
        response.getWriter().println(student);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
