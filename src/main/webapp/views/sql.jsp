<%@ page import="java.util.Locale" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: jlkesh
  Date: 13/02/23
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sql" uri="jakarta.tags.sql" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%--<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>--%>
<html>
<head>
    <title>Core Tags Library</title>
</head>
<body>
<%--maxIntegerDigits="3" maxFractionDigits="4"--%>
<div>
    <sql:setDataSource
            var="jakarta"
            driver="org.postgresql.Driver"
            url="jdbc:postgresql://localhost:5432/jakartaee?currentSchema=library1"
            user="postgres"
            password="123"
    />

    <sql:query
            dataSource="${jakarta}"
            sql="select * from category;"
            var="result"
    />
    <ul>
        <c:forEach items="${result.rows}" var="row">
            <li>Id: ${row.id}, Name : ${row.name}</li>
        </c:forEach>
    </ul>
</div>
</body>
</html>
