package dev.jlkesh.lessontwoservletjsp.relations.one2many;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import dev.jlkesh.lessontwoservletjsp.relations.one2many.Author;
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
import java.util.Set;

@WebServlet(name = "OneToManyServlet", value = "/OneToManyServlet")
public class OneToManyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .setPrettyPrinting().create();

        var emf = Persistence.createEntityManagerFactory("persistence_unit");
        var em = emf.createEntityManager();
        em.getTransaction().begin();

        Author author = Author.builder()
                .name("Abdulla Qodiriy")
                .build();

        Book book = Book.builder()
                .title("Otgan Kunlar")
                .author(author)
                .build();
        Book book1 = Book.builder()
                .title("Anvar va Ra'no")
                .author(author)
                .build();
        Book book2 = Book.builder()
                .title("Uloqda")
                .author(author)
                .build();



        // em.persist(author);

        em.persist(book);
        em.persist(book1);
        em.persist(book2);

        em.getTransaction().commit();
        PrintWriter writer = response.getWriter();
        writer.println("success");

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
