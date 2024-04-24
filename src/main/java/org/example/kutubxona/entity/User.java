package org.example.kutubxona.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.kutubxona.entity.enums.Status;

import java.util.List;
import java.util.UUID;

import static org.example.kutubxona.repo.BaseRepo.entityManager;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @OneToOne (cascade = CascadeType.PERSIST)
    private Book book;
    @Enumerated(EnumType.STRING)
    private Status status;


    public Object getBookName() {
        if (book != null) {
            // Assuming Book entity has a method getName() to retrieve its name
            return book.getName();
        } else {
            return "No book";
        }
    }
}

