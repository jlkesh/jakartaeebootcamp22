package dev.jlkesh.lessontwoservletjsp.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity(name = "mybook")
@Table(name = "mybookbook")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
    private String author;

    @Column(columnDefinition = "int default 0", nullable = true)
    private int downloadCount;

    @CreationTimestamp
    @Column(nullable = true, columnDefinition = "timestamp default current_timestamp")
    private LocalDateTime createdAt;
}
