package dev.jlkesh.lessontwoservletjsp.dao;

import dev.jlkesh.lessontwoservletjsp.StudentCreateDTO;
import dev.jlkesh.lessontwoservletjsp.domain.Student;
import lombok.NonNull;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDao extends DAO {

    public static final String INSERT_STUDENT_QUERY = """
            insert into lessontwo.student (first_name, last_name, age) values (?, ? , ?) returning id, created_at;""";

    public Student save(@NonNull StudentCreateDTO dto) {
        try {
            Student student = Student.builder()
                    .firstName(dto.firstName())
                    .lastName(dto.lastName())
                    .age(dto.age())
                    .build();
            PreparedStatement pr = getConnection().prepareStatement(INSERT_STUDENT_QUERY);
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
}
