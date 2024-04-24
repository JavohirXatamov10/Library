<%@ page import="org.example.kutubxona.repo.UserRepo" %>
<%@ page import="org.example.kutubxona.entity.User" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Search</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
<%
    UserRepo userRepo = new UserRepo();
    List<User> users = userRepo.findAll();
%>

<nav class="navbar navbar-inverse">
    <div class="container">
        <ul class="nav navbar-nav navbar-left">
            <li>
                <form class="navbar-form" role="search" action="" method="post">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Search" name="query" value="">
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
                    <td><a href="">Book</a></td>
                    <td>
                        <a href="/changeStatus?userId=<%= user.getId()%>" class="btn btn-success">OUT</a>
                        <a href="/changeStatus?userId=<%= user.getId()%>" class="btn btn-info">IN</a>

                    </td>
                    <td>
                        <a href="/delete?userId=<%= user.getId()%>" class="btn btn-danger">Delete</a>
                    </td>

                </tr>
                <%}%>
                </tbody>
            </table>
        </div>
    </div>


</body>
</html>
