package dev.jlkesh.lessontwoservletjsp.servlets.student;

import dev.jlkesh.lessontwoservletjsp.dao.StudentDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.Clock;
import java.time.ZonedDateTime;
import java.util.Objects;

@WebServlet(name = "StudentServlet", value = "/students")
public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentDao studentDao = StudentDao.getInstance();
        short page = Short.parseShort(Objects.requireNonNullElse(request.getParameter("page"), "0"));
        short size = Short.parseShort(Objects.requireNonNullElse(request.getParameter("size"), "3"));
        long totalCount = studentDao.totalCount();
        long pageCount = totalCount / size;
        long currentPage = page;
        request.setAttribute("students", studentDao.findAll(page, size));
        request.setAttribute("pageCount", pageCount);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("hasPrevious", currentPage > 0);
        request.setAttribute("hasNext", currentPage < pageCount);
        request.setAttribute("previous", page - 1);
        request.setAttribute("next", page + 1);
//        response.setIntHeader("Refresh", 2);
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
