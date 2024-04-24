        <%@ page import="java.util.UUID" %>
<%@ page import="org.example.kutubxona.repo.UserRepo" %>
<%@ page import="org.example.kutubxona.entity.User" %><%--
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
    } else {
        // Handle the case where userId parameter is missing or empty
        // Log the error or show an appropriate message
    }
%>

<h1><%=user.getFirstName()%></h1>

</body>
</html>
