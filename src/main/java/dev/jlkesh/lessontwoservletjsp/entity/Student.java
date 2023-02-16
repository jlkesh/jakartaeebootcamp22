package dev.jlkesh.lessontwoservletjsp.entity;


import dev.jlkesh.lessontwoservletjsp.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
/*@Converts({
        @Convert(attributeName = "fullName",converter = ),
        @Convert,
        @Convert,
        @Convert,
})*/
public class Student implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    /*@Convert(converter = LevelConvertor.class)*/
    private Level level;

    public enum Level {
        FRESHMAN,
        SOPHOMORE
    }

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "createdAt", column = @Column(name = "ldgnfdgfdkgjfdg")),
    })
    private Auditable auditable;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", level=" + level +
                ", auditable=" + auditable +
                '}' + "\n";
    }
}

@Converter(autoApply = true)
class LevelConvertor implements AttributeConverter<Student.Level, String> {
    @Override
    public String convertToDatabaseColumn(Student.Level attribute) {
        return switch (attribute) {
            case FRESHMAN -> "*";
            case SOPHOMORE -> "**";
            default -> "-";
        };
    }

    @Override
    public Student.Level convertToEntityAttribute(String dbData) {
        return switch (dbData) {
            case "*" -> Student.Level.FRESHMAN;
            case "**" -> Student.Level.SOPHOMORE;
            default -> null;
        };
    }
}
