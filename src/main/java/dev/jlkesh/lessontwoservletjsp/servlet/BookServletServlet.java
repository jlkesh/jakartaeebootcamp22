package dev.jlkesh.lessontwoservletjsp.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import dev.jlkesh.lessontwoservletjsp.relations.one2many.Book;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

@WebServlet(name = "BookServletServlet", value = "/BookServletServlet")
public class BookServletServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .setPrettyPrinting().create();
        var emf = Persistence.createEntityManagerFactory("persistence_unit");
        var em = emf.createEntityManager();
        em.getTransaction().begin();
       /* var book = Book.builder()
                .title(request.getParameter("title"))
                .build();
        em.persist(book);*/
        var books = em.createNativeQuery("select * from new_book;", Book.class).getResultList();
        System.out.println(books);
        em.getTransaction().commit();
        var jsonDATA = gson.toJson(books);
        PrintWriter writer = response.getWriter();
        writer.println(jsonDATA);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public static class LocalDateTimeAdapter extends TypeAdapter<LocalDateTime> {
        @Override
        public void write(JsonWriter out, LocalDateTime value) throws IOException {
            out.value(value.toString());
        }

        @Override
        public LocalDateTime read(JsonReader in) throws IOException {
            return LocalDateTime.parse(in.nextString());
        }
    }
}
