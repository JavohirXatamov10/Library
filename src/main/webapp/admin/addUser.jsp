<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 4/24/2024
  Time: 2:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add User</title>
    <link rel="stylesheet" href="../static/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <div class="card-header">
                    <h2>Add User</h2>
                    <form action="/addUser" method="post">
                        <div class="form-group">
                            <label for="firstName">First Name:</label>
                            <input name="firstName" type="text" class="form-control" id="firstName" placeholder="Enter first name" required>
                        </div>
                        <div class="form-group">
                            <label for="lastName">Last Name:</label>
                            <input name="lastName" type="text" class="form-control" id="lastName" placeholder="Enter last name" required>
                        </div>
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
