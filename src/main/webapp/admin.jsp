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
<% if (session.getAttribute("users_count") != null) { %>
<h1>
    Active Users Count : <%= session.getAttribute("users_count") %>
</h1>
<% } %>
<%= request.getServletPath() %>
</body>
</html>
