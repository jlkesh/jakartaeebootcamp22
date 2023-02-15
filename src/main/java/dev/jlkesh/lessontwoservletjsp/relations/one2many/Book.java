package dev.jlkesh.lessontwoservletjsp.relations.one2many;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "new_book")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String title;

    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private Author author;
}
