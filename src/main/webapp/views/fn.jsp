<%--
  Created by IntelliJ IDEA.
  User: jlkesh
  Date: 13/02/23
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<html>
<head>
    <title>Function Tags Example</title>
</head>
<body>
<c:set var="name" value="Javohir" />
<c:if test="${fn:contains(name, 'She')}">
  <h1>${name} contains Ja</h1>
</c:if>

<c:forEach items="${fn:split('Java, Python, Scala, Groovy', ',')}" var="a">
  <li>${a}</li>
</c:forEach>

</body>
</html>