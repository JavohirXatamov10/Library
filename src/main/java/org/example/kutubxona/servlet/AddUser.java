package org.example.kutubxona.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.kutubxona.entity.Book;
import org.example.kutubxona.entity.User;
import org.example.kutubxona.entity.enums.Status;
import org.example.kutubxona.repo.UserRepo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "addUser", value ="/addUser")
public class AddUser extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserRepo userRepo=new UserRepo();
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        User user= User.builder()
                .firstName(firstName)
                .lastName(lastName)
                .status(Status.OFF)
                .build();
        userRepo.save(user);
        resp.sendRedirect("/admin/admin.jsp");
    }
}
