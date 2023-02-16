package dev.jlkesh.lessontwoservletjsp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity(name = "bo")
@Table(
        name = "book"
        /*indexes = {
                @Index(
                        name = "passport_number_serial",
                        columnList = {"serial", "number"},
                        unique = true
                )
        }*/
        /*uniqueConstraints = {
                @UniqueConstraint(
                        name = "passport_number_serial",
                        columnNames = {"title","sdlvfjdnjgfdns"}
                )
        }*/
)
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name = "get_all_order_createdat", query = "select t from bo t order by t.createdAt desc")
public class Book {
    @Id
    /*@SequenceGenerator(
            name = "book_id_sequence",
            sequenceName = "book_new_id_seq",
            initialValue = 1,
            allocationSize = 2
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_id_sequence")*/
    /*@UuidGenerator(style = UuidGenerator.Style.RANDOM)
    @GeneratedValue(strategy = GenerationType.UUID)*/
    @TableGenerator(
            name = "book_book",
            table = "sequences_table",
            pkColumnName = "GEN_KEY",
            valueColumnName = "value",
            pkColumnValue = "book",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "book_book")
    private int id;

    private String title;

/*    @CreationTimestamp
    @Column(columnDefinition = "timestamp default current_timestamp")
    *//*@OrderBy(value = "desc")*//*
    private LocalDateTime createdAt;*/
}
