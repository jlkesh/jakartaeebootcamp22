package dev.jlkesh.lessontwoservletjsp.entity;

import dev.jlkesh.lessontwoservletjsp.ValidAbout;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthUser implements BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Email(regexp = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-]+)(\\.[a-zA-Z]{2,5}){1,2}$")
    @NotBlank(message = "Email null bololmaydida")
    @UniqueEmail(clazz = AuthUser.class)
    private String email;
    @Min(value = 18, message = "{value} dan kichkina bololmaydida")
    private int age;
    @ValidAbout(wordCount = 3)
    private String about;
}
