package dev.jlkesh.lessontwoservletjsp.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    private long id;
    private String firstName;
    private String lastName;
    private short age;
    private Date createdAt;
}
