<%@ page import="java.util.Locale" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: jlkesh
  Date: 13/02/23
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%--<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>--%>
<html>
<head>
    <title>Core Tags Library</title>
</head>
<body>
<%--maxIntegerDigits="3" maxFractionDigits="4"--%>
<c:set value="<%=new Date()%>" var="cd" />
<fmt:formatNumber  type="currency" var="fmtNumnber" value="${109/6}" />
<c:out value="${fmtNumnber}"/>
<br />
<fmt:formatDate value="${cd}" var="fd" type="date" />
<c:out value="${fd}"/>
<br />
<fmt:formatDate value="${cd}" var="fd2" type="time" />
<c:out value="${fd2}"/>
<br />
<fmt:formatDate value="${cd}" var="fd3" type="both" />
<c:out value="${fd3}"/>
<fmt:setLocale value="ru" scope="session" />
<fmt:setBundle basename="messages" />
<div>
    <fmt:message key="hello" var="message" />
    ${message}
</div>
</body>
</html>
