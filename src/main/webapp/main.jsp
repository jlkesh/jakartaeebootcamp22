<%@ page import="java.util.Arrays" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main Page</title>
</head>
<body>

<% Cookie c =  Arrays.stream(request.getCookies()).filter(cookie -> cookie.getName().equals("JSESSION")).findFirst().get(); %>

<%=c.getValue()%>


</body>
</html>
