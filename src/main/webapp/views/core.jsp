<%--
  Created by IntelliJ IDEA.
  User: jlkesh
  Date: 13/02/23
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>--%>
<html>
<head>
    <title>Core Tags Library</title>
</head>
<body>
<c:set var="message" value="Hello PDP"/>

<h1><c:out value="${message}"/></h1>

<c:if test="${12 > 3}">
    <h1>12 greater then 3</h1>
</c:if>
<c:set var="i" value="23"/>
<c:choose>
    <c:when test="${i > 44}">${i} katta 44</c:when>
    <c:when test="${i < 44}">${i} kichik 44</c:when>
</c:choose>
<ul>
    <c:forTokens items="Spring, Quarkus, Micronaut, Spark, Vertx" var="lang" delims=", ">
        <li><c:out value="${lang}"/></li>
    </c:forTokens>
</ul>

<%--<c:redirect url="https://kun.uz" />--%>
<c:catch var="e">
    <%
        int a = 123 / 0;
    %>
</c:catch>
<c:if test="${e != null}">
    <c:out value="${e.getMessage()}" />
</c:if>
</body>
</html>
