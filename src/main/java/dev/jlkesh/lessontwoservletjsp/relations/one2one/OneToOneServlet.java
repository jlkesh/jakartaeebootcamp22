package dev.jlkesh.lessontwoservletjsp.relations.one2one;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import dev.jlkesh.lessontwoservletjsp.entity.Book;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

@WebServlet(name = "OneToOneServlet", value = "/OneToOneServlet")
public class OneToOneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .setPrettyPrinting().create();
        var emf = Persistence.createEntityManagerFactory("persistence_unit");
        var em = emf.createEntityManager();
        em.getTransaction().begin();

     /*   var authUser = new AuthUser();
        authUser.setUsername("jlkesh");
        authUser.setPassword("123");*/
        /*var authUser = em.find(AuthUser.class, "9166305c-3fff-4083-a437-57e10bd85e46");*/
       /* var employee = new Employee();
        employee.setFirstName("Asrorxoja");
        employee.setLastName("Yo'ldoshev");
        employee.setUser(authUser);
        authUser.setEmployee(employee);*/
        /*em.persist(authUser);
         */

        AuthUser authUser = em.find(AuthUser.class, "9e906ba1-5cb1-4d3f-93eb-7352d6796cdf");
        em.remove(authUser);

        em.getTransaction().commit();


        PrintWriter writer = response.getWriter();
        writer.println("success");
//        writer.println(gson.toJson(employee));

    }/**/

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
