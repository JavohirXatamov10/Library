package org.example.kutubxona.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.UUID;

import static org.example.kutubxona.repo.BaseRepo.entityManager;

//@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    @NotBlank
    private String authorName;
//    @Builder // Bookni baseIn
//   public Book(UUID id, @NotBlank String name,String authorName) {
//        super(id, name);
//        this.authorName=authorName;
//    }
}
