<%--
  Created by IntelliJ IDEA.
  User: jlkesh
  Date: 13/02/23
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Expression Language Test</title>
</head>
<body>
<p>${12 > 2 or 5 > 15}</p>
<p> 12 ge 12 = ${ 12 ge 12}</p>
<p> 14 ge 12 = ${ 14 ge 12}</p>
<p> 10 ge 12 = ${ 10 ge 12}</p>
<p> 12 gt 12 = ${ 12 gt 12}</p>
<p> 14 gt 12 = ${ 14 gt 12}</p>
<p> 10 gt 12 = ${ 10 gt 12}</p>
<p> 13 mod 2 eq 1 = ${ 13 mod 2 eq 1}</p>
<p> 13 mod 2  = ${ 13 mod 2 }</p>
<p>1 div 3 = ${1 div 3}</p>
</body>
</html>
