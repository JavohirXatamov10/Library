package org.example.kutubxona.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.kutubxona.entity.Admin;
import org.example.kutubxona.entity.User;

import java.io.IOException;
//@WebFilter(filterName = "filter", urlPatterns = "/admin/*")
public class Filter{ //implements jakarta.servlet.Filter {
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest req = (HttpServletRequest) servletRequest;
//        HttpServletResponse resp = (HttpServletResponse) servletResponse;
//        Admin currentUser = (Admin)req.getSession().getAttribute("currentUser");
//        if (currentUser!=null){
//            filterChain.doFilter(req,resp);
//            return;
//        }
//        resp.sendRedirect("/404");
//    }
}
