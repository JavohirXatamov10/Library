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

@WebServlet(name ="ButtonIn", value = "/changesIn")
public class InButton extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UUID chosenUserId = UUID.fromString(req.getParameter("userId"));
        UserRepo userRepo=new UserRepo();
        User user = userRepo.findById(chosenUserId);
        if(user.getStatus().equals(Status.OFF)){
        resp.sendRedirect("/admin/book.jsp?userId"+chosenUserId);
        }else if (user.getStatus().equals(Status.OUT)){
            resp.sendRedirect(req.getHeader("referer"));
        }
    }
}
