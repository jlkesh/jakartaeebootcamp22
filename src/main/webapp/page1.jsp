<%--
  Created by IntelliJ IDEA.
  User: jlkesh
  Date: 12/02/23
  Time: 09:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Page 1</title>
</head>
<body>
<% if (session.getAttribute("username") != null) { %>
<h1>
    Username : <%= session.getAttribute("username") %>
</h1>
<p>
    Email :  <%= session.getAttribute("email") %>
</p>
<% } %>
<%= request.getServletPath() %>
</body>
</html>
