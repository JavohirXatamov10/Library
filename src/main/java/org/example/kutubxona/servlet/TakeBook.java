package org.example.kutubxona.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.kutubxona.entity.Book;
import org.example.kutubxona.entity.User;
import org.example.kutubxona.entity.enums.Status;
import org.example.kutubxona.repo.BookRepo;
import org.example.kutubxona.repo.UserRepo;

import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "booking", value = "/take/book")
public class TakeBook extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserRepo userRepo=new UserRepo();
        BookRepo bookRepo=new BookRepo();
        UUID chosenUserId = UUID.fromString(req.getParameter("userId"));
        UUID chosenBookId = UUID.fromString(req.getParameter("chosenBook"));
        User user = userRepo.findById(chosenUserId);
        Book chosenBook = bookRepo.findById(chosenBookId);
        BookRepo.mergeToUser(user,chosenBook);
        resp.sendRedirect("/admin/admin.jsp");
    }
}
