package org.example.kutubxona.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.kutubxona.entity.User;
import org.example.kutubxona.entity.enums.Status;
import org.example.kutubxona.repo.UserRepo;
import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "OutButton", value = "/changesOut")
public class OutButton extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UUID chosenUserId = UUID.fromString(req.getParameter("userId"));
        UserRepo userRepo=new UserRepo();
        User chosenUser = userRepo.findById(chosenUserId);
        if (!chosenUser.getStatus().equals(Status.OFF)){
            resp.sendRedirect("/admin/book.jsp?userId="+chosenUserId);
        }else{
            resp.sendRedirect("/admin/admin.jsp");
        }
    }
}
