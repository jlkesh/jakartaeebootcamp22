package dev.jlkesh.lessontwoservletjsp.dao;

import dev.jlkesh.lessontwoservletjsp.entity.Student;
import jakarta.persistence.TypedQuery;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.awt.event.WindowFocusListener;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StudentDAO extends BaseDAO<Student, Integer> {
    private static final ThreadLocal<StudentDAO> daoThreadLocal = ThreadLocal.withInitial(StudentDAO::new);

    public List<Student> getPage(int page, int size) {
        begin();
        TypedQuery<Student> query = em.createQuery("from Student ", Student.class);
        query.setFirstResult((page - 1) * size);
        query.setMaxResults(size);
        commit();
        return query.getResultList();
    }


}
