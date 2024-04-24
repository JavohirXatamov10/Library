package org.example.kutubxona.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.kutubxona.entity.Admin;
import org.example.kutubxona.entity.User;

import java.io.IOException;

@WebServlet(name = "checkCode",value = "/check/emailCode")
public class CheckEmailCodeSendAdminSection extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String codeFromEmail =(req.getParameter("codeEmail"));
        String randomNumber = String.valueOf( req.getSession().getAttribute("randomNumber"));
        if (randomNumber.equals(codeFromEmail)){
            Admin admin = (Admin) req.getSession().getAttribute("temp");
            req.getSession().setAttribute("currentUser",admin);
            resp.sendRedirect("../admin/admin.jsp");
        }
    }
}
