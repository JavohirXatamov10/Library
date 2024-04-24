package org.example.kutubxona.repo;

import jakarta.persistence.TypedQuery;
import org.example.kutubxona.entity.User;

import java.util.UUID;

public class UserRepo extends BaseRepo<User, UUID>{
    public static int totalPageAmount(String search) {
        TypedQuery<Long> query = entityManager.createQuery("select count(t) from User t where t.firstName ilike : search", Long.class);
        query.setParameter("search","%"+search+"%");
        return (int) Math.ceil(query.getSingleResult()/3.0);
    }

}
