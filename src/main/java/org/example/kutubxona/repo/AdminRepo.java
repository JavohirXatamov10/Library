package org.example.kutubxona.repo;

import org.example.kutubxona.entity.Admin;

import java.util.UUID;



public class AdminRepo extends BaseRepo<Admin,UUID> {
    public static Admin findByEmail(String email) {
        return entityManager.createQuery("select  t from Admin t where t.email=: email",Admin.class)
                .setParameter("email",email).getSingleResult();
    }
}
