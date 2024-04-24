package org.example.kutubxona.servlet;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.kutubxona.entity.Admin;
import org.example.kutubxona.repo.AdminRepo;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

@WebServlet(name = "Login", value = "/login")
public class LoginCheckAndSendEmailmessage extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        Admin admin=AdminRepo.findByEmail(email);
        if (admin!=null){
            if(isEqual(admin, password)){                                                        //sendmessage function
                req.getSession().setAttribute("temp",admin);
                int randomNumber=generaterandomNumber();
                req.getSession().setAttribute("randomNumber",randomNumber);
                sendMessage(email,randomNumber);
                resp.sendRedirect("/auth/code.jsp");
                return;
            }
        }
        throw new RuntimeException("Bad critical");
    }

    private boolean isEqual(Admin admin, String password) {
        return admin.getPassword().equals(password);
    }

    private int generaterandomNumber() {
        Random random=new Random();
        return random.nextInt(1000,10_000);
    }

    private void sendMessage(String sentToEmail, int random) {
            try {
                Properties properties = new Properties();
                properties.put("mail.smtp.host", "smtp.gmail.com");
                properties.put("mail.smtp.port", "465");
                properties.put("mail.smtp.ssl.enable", "true");
                properties.put("mail.smtp.auth", "true");
                String libraryEmail = "geroyboy70@gmail.com";
                String libraryPassword = "ezpuswzxlzajklyt";
                Session session = Session.getInstance(properties, new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(libraryEmail, libraryPassword);
                    }
                });
                Message message = new MimeMessage(session);
                message.setSubject("Your code: ");
                message.setText(random + "");
                message.setFrom(new InternetAddress("geroyboy70@gmail.com"));
                message.setRecipient(Message.RecipientType.TO, new InternetAddress(sentToEmail));
                Transport.send(message);
            }catch (Exception e){
                throw new RuntimeException(e);
            }

    }
}
