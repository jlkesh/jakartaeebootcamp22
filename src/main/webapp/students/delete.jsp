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
        <form method="post" action="/students/delete/${student.getId()}">
            <input type="hidden" name="id" value="${student.getId()}">
            <div class="alert alert-danger">
                <p>Are you sure delete user <i>${student.getFirstName()}</i></p>
            </div>
            <a href="/students" class="btn btn-success">Back</a>
            <button type="submit" class="btn btn-primary">Yes</button>
        </form>
    </div>
</div>
<script src="/resources/js/popper.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
</body>
</html>
