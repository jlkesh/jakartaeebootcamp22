package dev.jlkesh.lessontwoservletjsp.servlet;

import dev.jlkesh.lessontwoservletjsp.entity.BookBook;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "BookServlet", urlPatterns = "/book")
public class BookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("persistence_unit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        BookBook bookBook = entityManager
                .createQuery("select b from mybook b where b.id = :id", BookBook.class)
                .setParameter("id", 9)
                .getSingleResult();
        System.out.println("bookBook = " + bookBook);

        /*for (BookBook bookBook : fromBookBook.getResultList()) {
            System.out.println(bookBook);
        }*/

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        String author = req.getParameter("author");
        BookBook bookBook = BookBook.builder()
                .title(title)
                .description(description)
                .author(author)
                .build();
        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("persistence_unit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(bookBook);
        entityManager.getTransaction().commit();
    }
}
