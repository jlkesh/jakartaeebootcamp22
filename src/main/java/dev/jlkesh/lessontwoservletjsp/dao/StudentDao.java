package dev.jlkesh.lessontwoservletjsp.dao;

import dev.jlkesh.lessontwoservletjsp.dto.StudentCreateDTO;
import dev.jlkesh.lessontwoservletjsp.domain.Student;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StudentDao extends DAO {

    private static final ThreadLocal<StudentDao> studentDaoThreadLocal = ThreadLocal.withInitial(StudentDao::new);

    public static StudentDao getInstance() {
        return studentDaoThreadLocal.get();
    }

    public static final String INSERT_STUDENT_QUERY = """
            insert into lessontwo.student (first_name, last_name, age) values (?, ? , ?) returning id, created_at;""";

    public Student save(@NonNull StudentCreateDTO dto) {
        Student student = Student.builder()
                .firstName(dto.firstName())
                .lastName(dto.lastName())
                .age(dto.age())
                .build();
        Connection connection = getConnection();
        try (PreparedStatement pr = connection.prepareStatement(INSERT_STUDENT_QUERY)) {
            pr.setString(1, student.getFirstName());
            pr.setString(2, student.getLastName());
            pr.setShort(3, student.getAge());
            ResultSet resultSet = pr.executeQuery();
            if (resultSet.next()) {
                student.setId(resultSet.getLong("id"));
                student.setCreatedAt(resultSet.getTimestamp("created_at").toLocalDateTime());
            }
            return student;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        Connection connection = getConnection();
        try (PreparedStatement pr = connection.prepareStatement("select * from lessontwo.student order by created_at desc ")) {
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                students.add(Student.builder()
                        .id(rs.getLong("id"))
                        .firstName(rs.getString("first_name"))
                        .lastName(rs.getString("last_name"))
                        .age(rs.getShort("age"))
                        .createdAt(rs.getTimestamp("created_at").toLocalDateTime())
                        .build());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }
}
