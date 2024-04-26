package org.example.kutubxona.repo;

import jakarta.persistence.TypedQuery;
import org.example.kutubxona.entity.Book;
import org.example.kutubxona.entity.User;
import org.example.kutubxona.entity.enums.Status;

import java.util.List;
import java.util.UUID;

public class UserRepo extends BaseRepo<User, UUID>{
    public static int totalPageAmount(String search) {
        TypedQuery<Long> query = entityManager.createQuery("select count(t) from User t where t.firstName ILIKE : search or t.lastName ILIKE : search", Long.class);
        query.setParameter("search","%"+search+"%");
        return (int) Math.ceil(query.getSingleResult()/3.0);
    }
    public static List<User> findAllForUserPagination(int page, String search) {
        TypedQuery<User> typedQuery = entityManager.createQuery("SELECT t FROM User t" +
                " WHERE t.firstName ILIKE :search or t.lastName ilike :search " +
                "order by firstName", User.class);
        typedQuery.setParameter("search", "%" + search + "%");
        typedQuery.setMaxResults(3);
        typedQuery.setFirstResult((page - 1) * 3);
        return typedQuery.getResultList();
    }

    public static void makeChanges(User chosenUser, Book chosenBook) {
        begin();
        chosenUser.setBook(chosenBook);
        chosenUser.setStatus(Status.OUT);
        commit();
    }
}
