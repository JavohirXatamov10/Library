        <%@ page import="java.util.UUID" %>
<%@ page import="org.example.kutubxona.repo.UserRepo" %>
<%@ page import="org.example.kutubxona.entity.User" %>
        <%@ page import="org.example.kutubxona.repo.BookRepo" %>
        <%@ page import="org.example.kutubxona.entity.Book" %>
        <%@ page import="java.util.List" %>
        <%@ page import="org.example.kutubxona.entity.enums.Status" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 4/24/2024
  Time: 8:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Booking</title>
    <link rel="stylesheet" href="/static/bootstrap.min.css">
</head>
<body>
<%
    String id = request.getParameter("userId");
    User user = null;
    if (id != null && !id.isEmpty()) {
        try {
            UUID userId = UUID.fromString(id);
            UserRepo userRepo = new UserRepo();
            user = userRepo.findById(userId);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }
    BookRepo bookRepo=new BookRepo();
    List<Book> books = bookRepo.findAll();
    UUID bookId = user.getBook().getId();
    Book chosenBook = bookRepo.findById(bookId);
%>
<div class="row mt-6">
    <div class="col-4 offset-4">
        <div class="card p-2">
            <h1 class="text-center text-muted">Booking</h1>
            <h5 class="text-center"><%=user.getFirstName()%></h5>
            <%if(user.getStatus().equals(Status.OFF)){%>
                <form action="/take/book" method="post">
                    <input value="<%=user.getId()%>" name="userId" type="hidden">
                    <select name="chosenBook" class="form-control mb-3">
                        <%for (Book book : books) {%>
                        <option value="<%=book.getId()%>"><%=book.getName()%></option>
                        <%}%>
                    </select>
                    <button class="btn btn-dark w-100">Borrow</button>
                </form>
            <%}else if(user.getStatus().equals(Status.IN)){%>
                <form action="/return/book" method="post">
                    <input value="<%=user.getId()%>" name="userId" type="hidden">
                    <input value="<%=chosenBook.getId()%>" name="chosenBookId" type="hidden" >
                    <input value="<%=chosenBook.getName()%>" name="chosenBook" type="text" class="form-control">
                    <button class="btn btn-dark w-100 mt-3" >Return book</button>
                </form>
            <%}%>
        </div>
    </div>
</div>
</body>
</html>
