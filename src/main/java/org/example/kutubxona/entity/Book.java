package org.example.kutubxona.entity;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.UUID;

import static org.example.kutubxona.repo.BaseRepo.entityManager;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
public class Book extends BaseEntity {

    @NotBlank
    private String authorName;
    @Builder

    public Book(UUID id, @NotBlank String name,String authorName) {
        super(id, name);
        this.authorName=authorName;
    }


    public Object getName() {
        Book book = entityManager.find(Book.class, id);
        return book.getName();
    }
}
