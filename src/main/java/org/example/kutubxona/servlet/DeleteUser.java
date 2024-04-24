package org.example.kutubxona.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.kutubxona.repo.UserRepo;

import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "deleteUser", value = "/deleteUser")
public class DeleteUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UUID id = UUID.fromString(req.getParameter("userId"));
        UserRepo userRepo=new UserRepo();
        userRepo.delete(id);
        resp.sendRedirect("/admin/admin.jsp");
    }
}
