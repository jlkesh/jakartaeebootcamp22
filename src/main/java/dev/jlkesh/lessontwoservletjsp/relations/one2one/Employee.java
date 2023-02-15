package dev.jlkesh.lessontwoservletjsp.relations.one2one;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column
    private String firstName;
    private String lastName;

    @OneToOne(
            cascade = {CascadeType.ALL},
            fetch = FetchType.LAZY
    )
    private AuthUser user;

}

