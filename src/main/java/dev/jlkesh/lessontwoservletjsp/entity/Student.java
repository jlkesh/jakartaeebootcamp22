package dev.jlkesh.lessontwoservletjsp.entity;


import dev.jlkesh.lessontwoservletjsp.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Getter
@Setter
public class Student implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    @Enumerated(EnumType.STRING)
    private Level level;

    public enum Level {
        FRESHMAN,
        SOPHOMORE
    }

    @Embedded
    private Auditable auditable;
}
