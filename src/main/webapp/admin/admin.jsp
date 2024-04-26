<%@ page import="org.example.kutubxona.repo.UserRepo" %>
<%@ page import="org.example.kutubxona.entity.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Objects" %>
<%@ page import="org.example.kutubxona.entity.enums.Status" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Search</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="../static/boost_css.css">
</head>
<body>
<%
    String search = Objects.requireNonNullElse(request.getParameter("search"),"");
    int totalPageAmount=UserRepo.totalPageAmount(search);
    int p = Integer.parseInt(Objects.requireNonNullElse(request.getParameter("page"), "1"));
    //List<User> users = userRepo.findAll(p,search);
    List<User>users=UserRepo.findAllForUserPagination(p,search);
%>
<nav class="navbar navbar-inverse">
    <div class="container">
        <ul class="nav navbar-nav navbar-left">
            <li>
                <form class="navbar-form" role="search" action="" method="get">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Search" name="search" value="<%=search%>">
                    </div>
                        <button type="submit" class="btn btn-default">Search</button>
                    </form>
            </li>
        </ul>
        <ul class="nav navbar-nav navbar-right my-3">
            <li><a href="/logout">Log out</a></li>
            <li><a href="../admin/addUser.jsp"><span class="glyphicon glyphicon-log-in"></span> Add user</a></li>
        </ul>
    </div>
</nav>
<div class="row">
        <div class="col-md-10 offset2">
            <table class="table table-striped m-2">
                <thead>
                <tr>
                    <th>First name</th>
                    <th>Last name</th>
                    <th>Book name</th>
                    <th>Action</th>
                    <th>Changes</th>

                    <th>Function</th>
                </tr>
                </thead>
                <tbody>
                <%for (User user : users) { %>
                <tr>
                    <td><%=user.getFirstName()%></td>
                    <td><%=user.getLastName()%></td>
                    <td><%=user.getBookName()%></td>
                    <td>
                    <%if (user.getStatus().equals(Status.OUT)){%>
                        <a href="/admin/book.jsp?userId=<%= user.getId()%>" class="btn btn-danger">Book</a>
                        <%} else {%>
                        <a href="/admin/book.jsp?userId=<%= user.getId()%>" class="btn btn-success">Book</a>
                        <%}%>
                    </td>

                    <td>
                        <%if (user.getStatus().equals(Status.OUT) ) {%>
                             <a href="/changesOut?userId=<%= user.getId()%>" class="btn btn-info">Out</a>
                        <%} else {%>
                        <a href="/changesOut?userId=<%= user.getId()%>" class="btn btn-success">Out</a>
                        <%}%>
                        <%if(user.getStatus().equals(Status.OFF)){%>
                        <a href="/changesIn?userId=<%= user.getId()%>" class="btn btn-success">IN</a>
                        <%}else{%>
                        <a href="#" class="disabled btn btn-danger">IN</a>
                        <%}%>
                    </td>
                    <td>
                        <a href="/deleteUser?userId=<%= user.getId()%>" class="btn btn-default">Delete</a>
                    </td>
                </tr>
                <%}%>
                </tbody>
            </table>
        </div>
    </div>

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-12"> <!-- Full-width column -->
            <nav aria-label="Page navigation example">
                <ul class="pagination">
                    <%if (p!=1){%>
                        <li class="page-item"><a class="page-link" href="?page=<%=p-1%>&search<%=search%>">Previous</a></li>
                    <%}%>
                    <%for (int i = 1; i <=totalPageAmount ; i++) { %>
                    <li class="page-item  <%=p==i ? "active": "" %>"><a class="page-link" href="?page=<%=i%>&search<%=search%>"><%=i%></a></li>
                    <%}%>
                    <%if (p!=totalPageAmount){%>
                    <li class="page-item"><a class="page-link" href="?page=<%=p+1%>&search<%=search%>">Next</a></li>
                    <%}%>
                </ul>
            </nav>
        </div>
    </div>
</div>
</body>
</html>
