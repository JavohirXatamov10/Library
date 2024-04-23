package org.example.kutubxona.entity;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Entity
public class Admin extends BaseEntity {

    @NotBlank
    private String email;
    @NotBlank
    private String password;

@Builder
    public Admin(UUID id, @NotBlank String name,String email,String password) {
        super(id, name);
        this.email=email;
        this.password=password;
    }
}
