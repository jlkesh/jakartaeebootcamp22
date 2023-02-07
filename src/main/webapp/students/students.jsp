<%--
  Created by IntelliJ IDEA.
  User: jlkesh
  Date: 06/02/23
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<html>
<head>
    <title>Students List</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
</head>
<body>
<div class="row">
    <div class="col-md-10 offset-1">
        <h1>Students List</h1>
        <%--        <a href="/students/add" class="btn btn-success">Add</a>--%>
        <button class="btn btn-success" data-bs-target="#exampleModalToggle" data-bs-toggle="modal">Add</button>
        <nav aria-label="...">
            <ul class="pagination mt-2">
                <c:if test="${hasPrevious}">
                    <li class="page-item">
                        <a class="page-link" href="?page=${previous}">Previous</a>
                    </li>
                </c:if>
                <c:set value="${currentPage}" var="cur"/>
                <c:forEach begin="0" end="${pageCount}" var="i">
                    <li class="page-item ${cur == i ? "active":""}">
                        <a class="page-link" href="?page=${i}">${i+1}</a>
                    </li>
                </c:forEach>
                <c:if test="${hasNext}">
                    <li class="page-item">
                        <a class="page-link" href="?page=${next}">Next</a>
                    </li>
                </c:if>
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
                    <td><fmt:formatDate type="date" value="${student.getCreatedAt()}" var="fd"/>
                            ${fd}
                    </td>
                    <td>
                        <button class="btn btn-warning" data-bs-target="#updateStudentModal" data-bs-toggle="modal" onclick="update(${student.getId()})">Update</button> ||
                        <a class="btn btn-danger" href="/students/delete/${student.getId()}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>


<div class="modal fade" id="exampleModalToggle" aria-hidden="true" aria-labelledby="exampleModalToggleLabel"
     tabindex="-1">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalToggleLabel">Create Student</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form method="post" action="/students/add">
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

                    <button type="submit" class="btn btn-success">Save Student</button>
                </form>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="updateStudentModal" aria-hidden="true" aria-labelledby="UpdateStudentModalLabel"
     tabindex="-1">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="UpdateStudentModalLabel">Update Student</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form method="post" action="/students/update/">
                    <input type="hidden" id="u_id" name="id" />
                    <div class="mb-3">
                        <label for="u_firstName" class="form-label">Student First Name</label>
                        <input type="text" class="form-control" id="u_firstName" name="firstName">
                    </div>
                    <div class="mb-3">
                        <label for="u_lastName" class="form-label">Student Last Name</label>
                        <input type="text" class="form-control" id="u_lastName" name="lastName">
                    </div>

                    <div class="mb-3">
                        <label for="u_age" class="form-label">Student Age</label>
                        <input type="number" class="form-control" id="u_age" name="age">
                    </div>
                    <button type="submit" class="btn btn-success">Update Student</button>
                </form>
            </div>
        </div>
    </div>
</div>
<script src="/resources/js/main.js"></script>
<script src="/resources/js/popper.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
</body>
</html>
