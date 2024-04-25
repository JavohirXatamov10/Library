package org.example.kutubxona.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.kutubxona.entity.Book;
import org.example.kutubxona.entity.User;
import org.example.kutubxona.repo.BookRepo;
import org.example.kutubxona.repo.UserRepo;

import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "returnBook", value = "/return/book")
public class ReturnBook extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UUID chosenUserId = UUID.fromString(req.getParameter("userId"));
        UserRepo userRepo=new UserRepo();
        UUID chosenBookId = UUID.fromString(req.getParameter("chosenBookId"));
        BookRepo bookRepo=new BookRepo();
        User user = userRepo.findById(chosenUserId);
        Book chosenBook = bookRepo.findById(chosenBookId);
        BookRepo.remove(user,chosenBook);
        resp.sendRedirect("/admin/admin.jsp");
    }
}
