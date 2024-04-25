package org.example.kutubxona.repo;

import org.example.kutubxona.entity.Book;
import org.example.kutubxona.entity.User;
import org.example.kutubxona.entity.enums.Status;
import java.util.UUID;
public class BookRepo extends BaseRepo<Book, UUID> {
    public static void mergeToUser(User user, Book chosenBook) {
        begin();
        user.setStatus(Status.IN);
        user.setBook(chosenBook);
        commit();
    }
    public static void remove(User user, Book chosenBook) {
        begin();
        user.setStatus(Status.OFF);
        entityManager.remove(chosenBook);
        commit();
    }
}
