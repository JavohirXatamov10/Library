package org.example.kutubxona.repo;

import org.example.kutubxona.entity.Admin;
import org.example.kutubxona.entity.BaseEntity;

import java.util.UUID;

import static org.example.kutubxona.repo.BaseRepo.entityManager;

public class AdminRepo extends BaseRepo<Admin,UUID> {
    public static Admin findByEmail(String email) {
        return entityManager.createQuery("select  t from Admin t where t.email=: email",Admin.class).setParameter("email",email).getSingleResult();
    }
}
