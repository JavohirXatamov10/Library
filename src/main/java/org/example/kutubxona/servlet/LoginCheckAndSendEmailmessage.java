package org.example.kutubxona.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.kutubxona.entity.Admin;
import org.example.kutubxona.repo.AdminRepo;

import java.io.IOException;
import java.util.Random;

@WebServlet(name = "Login", value = "/login")
public class LoginCheckAndSendEmailmessage extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        Admin admin=AdminRepo.findByEmail(email);
        if (admin!=null){
            if(admin.getPassword().equals(password)){
            int random=generaterandomNumber();
                req.getSession().setAttribute("random",random);
                sendMessage(email,random);
                resp.sendRedirect("/auth/code.jsp");
            }
        }
        throw new RuntimeException("Bad critical");
    }

    private int generaterandomNumber() {
        Random random=new Random();
        return random.nextInt(1000,10_000);
    }

    private void sendMessage(String email, int random) {

    }
}
