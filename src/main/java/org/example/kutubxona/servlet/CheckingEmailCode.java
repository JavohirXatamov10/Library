package org.example.kutubxona.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "checkCode",value = "/chack/emailCode")
public class CheckingEmailCode extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String codeFromEmail =(req.getParameter("code"));
        String randomNumber = (String) req.getSession().getAttribute("randomNumber");
        if (randomNumber.equals(codeFromEmail)){
            resp.sendRedirect("/admin/admin.jsp");
        }
    }
}
