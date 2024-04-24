<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 4/23/2024
  Time: 7:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Code</title>
    <link rel="stylesheet" href="../static/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <div class="card-header">
                    <h3 class="text-center">Enter Verification Code</h3>
                </div>
                <div class="card-body">
                    <form action="/check/emailCode" method="POST">
                        <div class="form-group">
                            <label for="code">Verification Code</label>
                            <input type="text" class="form-control" id="code" name="codeEmail" required>
                        </div>
                        <button type="submit" class="btn btn-primary btn-block">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>


</form>

</body>
</html>
