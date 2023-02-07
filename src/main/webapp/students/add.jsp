<%--
  Created by IntelliJ IDEA.
  User: jlkesh
  Date: 06/02/23
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Students List</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
</head>
<body>
<div class="row">
    <div class="col-md-10 offset-1">
        <h1 class="text-center">Student Create Page</h1>
        <form method="post">
            <div class="mb-3">
                <label for="firstName" class="form-label">Student First Name</label>
                <input type="text" class="form-control" id="firstName" name="firstName">
            </div>
            <div class="mb-3">
                <label for="lastName" class="form-label">Student Last Name</label>
                <input type="text" class="form-control" id="lastName" name="lastName">
            </div>

            <div class="mb-3">
                <label for="age" class="form-label">Student Age</label>
                <input type="number" class="form-control" id="age" name="age">
            </div>

            <button type="submit" class="btn btn-primary">Save Student</button>
        </form>
    </div>
</div>
<script src="/resources/js/popper.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
</body>
</html>
