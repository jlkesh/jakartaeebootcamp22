<%--
  Created by IntelliJ IDEA.
  User: jlkesh
  Date: 06/02/23
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Students List</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
</head>
<body>
<div class="row">
    <div class="col-md-10 offset-1">
        <h1>Students List</h1>
        <a href="/students/add" class="btn btn-success">Add</a>
        <nav aria-label="...">
            <ul class="pagination">
                <li class="page-item disabled">
                    <a class="page-link">Previous</a>
                </li>
                <c:set value="${currentPage}" var="cur"/>
                <c:forEach begin="0" end="${pageCount}" var="i">
                    <li class="page-item ${cur == i ? "active":""}">
                        <a class="page-link" href="?page=${i}">${i+1}</a>
                    </li>
                </c:forEach>
                <li class="page-item">
                    <a class="page-link" href="#">Next</a>
                </li>
            </ul>
        </nav>
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">First Name</th>
                <th scope="col">Last Name</th>
                <th scope="col">Age</th>
                <th scope="col">Created At</th>
                <th scope="col">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${students}" var="student">
                <tr>
                    <td>${student.getId()}</td>
                    <td>${student.getFirstName()}</td>
                    <td>${student.getLastName()}</td>
                    <td>${student.getAge()}</td>
                    <td>${student.getCreatedAt()}</td>
                    <td>
                        <a class="btn btn-warning" href="/students/update/${student.getId()}">Update</a> ||
                        <a class="btn btn-danger" href="/students/delete/${student.getId()}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<script src="/resources/js/popper.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
</body>
</html>
