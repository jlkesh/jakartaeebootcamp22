package dev.jlkesh.lessontwoservletjsp.relations.one2one;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthUser {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(unique = true, nullable = false, name = "user_name")
    private String username;
    @Column(nullable = false, name = "password")
    private String password;

    @OneToOne(
            targetEntity = Employee.class,
            mappedBy = "user",
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private Employee employee;

    @Override
    public String toString() {
        return "AuthUser{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                /*", employee=" + employee +*/
                '}';
    }
}
