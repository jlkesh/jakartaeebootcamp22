package dev.jlkesh.lessontwoservletjsp.dao;

import dev.jlkesh.lessontwoservletjsp.dto.StudentCreateDTO;
import dev.jlkesh.lessontwoservletjsp.domain.Student;
import dev.jlkesh.lessontwoservletjsp.dto.StudentUpdateDTO;
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
    public static final String FIND_ALL_QUERY = "select * from lessontwo.student order by created_at desc offset ? limit ?";
    public static final String UPDATE_STUDENT_QUERY = """
            update lessontwo.student set first_name = ?, last_name = ?, age = ?  where id = ?;""";
    public static final String TOTAL_COUNT = "select count(0) from lessontwo.student;";

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
                student.setCreatedAt(resultSet.getTimestamp("created_at"));
            }
            return student;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Student> findAll(short page, short size) {
        List<Student> students = new ArrayList<>();
        Connection connection = getConnection();
        try (PreparedStatement pr = connection.prepareStatement(FIND_ALL_QUERY)) {
            pr.setShort(1, (short) (page * size));
            pr.setShort(2, size);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                students.add(Student.builder()
                        .id(rs.getLong("id"))
                        .firstName(rs.getString("first_name"))
                        .lastName(rs.getString("last_name"))
                        .age(rs.getShort("age"))
                        .createdAt(rs.getTimestamp("created_at"))
                        .build());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    public Student findById(long studentID) {
        Connection connection = getConnection();
        try (PreparedStatement pr = connection.prepareStatement("select * from lessontwo.student t where t.id = ?;")) {
            pr.setLong(1, studentID);
            ResultSet rs = pr.executeQuery();

            if (rs.next())
                return Student.builder()
                        .id(rs.getLong("id"))
                        .firstName(rs.getString("first_name"))
                        .lastName(rs.getString("last_name"))
                        .age(rs.getShort("age"))
                        .createdAt(rs.getTimestamp("created_at"))
                        .build();
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteById(long id) {
        Connection connection = getConnection();
        try (PreparedStatement pr = connection.prepareStatement("delete  from lessontwo.student t where t.id = ?;")) {
            pr.setLong(1, id);
            pr.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(@NonNull StudentUpdateDTO dto) {
        Connection connection = getConnection();
        try (PreparedStatement pr = connection.prepareStatement(UPDATE_STUDENT_QUERY)) {
            pr.setString(1, dto.firstName());
            pr.setString(2, dto.lastName());
            pr.setShort(3, dto.age());
            pr.setLong(4, dto.id());
            pr.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public long totalCount() {
        Connection connection = getConnection();
        try (PreparedStatement pr = connection.prepareStatement(TOTAL_COUNT)) {
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                return rs.getLong(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }
}
