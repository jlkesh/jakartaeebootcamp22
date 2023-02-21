package dev.jlkesh.lessontwoservletjsp.servlet;

import dev.jlkesh.lessontwoservletjsp.ValidationUtils;
import dev.jlkesh.lessontwoservletjsp.dao.AuthUserDAO;
import dev.jlkesh.lessontwoservletjsp.dto.ErrorDTO;
import dev.jlkesh.lessontwoservletjsp.entity.AuthUser;
import jakarta.persistence.RollbackException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.validation.*;

import java.io.IOException;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

@WebServlet(name = "AuthUserServlet", value = "/AuthUserServlet")
public class AuthUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        int age = Integer.parseInt(request.getParameter("age"));
        String about = request.getParameter("about");
        AuthUserDAO authUserDAO = new AuthUserDAO();
        AuthUser authUser = AuthUser.builder()
                .email(email)
                .about(about)
                .age(age)
                .build();
        Set<ErrorDTO> violations = ValidationUtils.validate(authUser, AuthUser.class);
        if (violations.isEmpty())
            authUserDAO.save(authUser);
        else {
            violations.forEach(System.out::println);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
