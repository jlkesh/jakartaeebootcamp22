<%--
  Created by IntelliJ IDEA.
  User: jlkesh
  Date: 13/02/23
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Use Bean</title>
</head>
<body>
<jsp:useBean id="timer" scope="application" class="dev.jlkesh.lessontwoservletjsp.TimerService"/>

<%= timer.currentTime() %>

</body>
</html>
