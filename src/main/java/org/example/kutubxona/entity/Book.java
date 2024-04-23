package org.example.kutubxona.entity;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.UUID;

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
}
