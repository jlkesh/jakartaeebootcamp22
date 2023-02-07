# Core Tags Example 

````html
<c:if test="${4 != 4}">
    <h1>Hello</h1>
    <c:out value="${UUID.randomUUID()}"></c:out>
</c:if>

<c:choose>
    <c:when test="${12 > 23}">
        <h1>12 kichik 23 dan</h1>
    </c:when>

    <c:otherwise>
        <h1>Bye</h1>
    </c:otherwise>
</c:choose>
<c:set var="salary" value="${2000*2}"/>
<c:out value="${salary}"/>

<c:set var="salary" value="${2000*5}"/>
<p>Before Remove Value:
    <c:out value="${salary}"/>
</p>
<c:remove var="salary"/>
<p>After Remove Value:
    <c:out value="${salary}"/>
</p>
<c:catch var="catchException">
    <% int x = 5 / 0;%>
</c:catch>

<c:if test="${catchException != null}">
    <p>The exception is : ${catchException} <br/>
        There is an exception: ${catchException.message}</p>
</c:if>
<c:import var="data" url="http://localhost:8080"/>
<c:out value="${data}"/>
````

# Formatting Tags Example
### NumberFormat

````html
<c:set var="balance" value="120000.2309"/>
<fmt:formatNumber value="${balance}" type="currency"/>
<fmt:formatNumber type="number" maxIntegerDigits="3" value="${balance}"/>
<fmt:formatNumber type="number" maxFractionDigits="3" value="${balance}"/>
<fmt:formatNumber type="number" groupingUsed="true" value="${balance}"/>
<fmt:formatNumber type="percent" maxIntegerDigits="3" value="${balance}"/>
<fmt:formatNumber type="percent" minFractionDigits="10" value="${balance}"/>
<fmt:formatNumber type="percent" maxIntegerDigits="3" value="${balance}"/>
<fmt:setLocale value="en_US"/> 
<fmt:formatNumber value="${balance}" type="currency"/>
````
### DateFormat
````html
<c:set var="now" value="<% = new java.util.Date()%>"/>
<fmt:formatDate type="time" value="${now}"/>
<fmt:formatDate type="date" value="${now}"/>
<fmt:formatDate type="both" value="${now}"/>
<fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${now}"/>
<fmt:formatDate type="both" dateStyle="medium" timeStyle="medium" value="${now}"/>
<fmt:formatDate type="both" dateStyle="long" timeStyle="long" value="${now}"/>
<fmt:formatDate pattern="yyyy-MM-dd" value="${now}"/>
````
### Bundle and Message
````html
<fmt:bundle basename="settings" >
    <fmt:message key="url"/>
</fmt:bundle>

<fmt:setLocale value = "uz"/>
<fmt:setBundle basename = "messages" var = "lang"/>

<fmt:message key = "one" bundle = "${lang}"/>
<fmt:message key = "two" bundle = "${lang}"/>
<fmt:message key = "three" bundle = "${lang}"/>
````


# Function Tags Example
````html

<c:set var="message" value="Java, Scala, Python, Groovy"/>

<c:if test="${fn:contains(message, 'Scala')}">
    <h2>
        <c:out value="${fn:toLowerCase(message)}"></c:out>
    </h2>
</c:if>

<c:if test="${fn:containsIgnoreCase(message, 'java')}">
    <h2>
        <c:out value="${fn:toUpperCase(message)}"></c:out>
    </h2>
</c:if>

</body>
````
# SQL Tags Example

```html
<sql:setDataSource var="jakartaee" driver="org.postgresql.Driver"
                   url="jdbc:postgresql://localhost:5432/jakartaee?currentSchema=lessontwo"
                   user="postgres" password="123"/>
<sql:query dataSource="${jakartaee}" sql="select * from student" var="result"/>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>FirstName</th>
        <th>LastName</th>
        <th>Age</th>
        <th>Created At</th>
    </tr>
    </thead>
    <c:forEach items="${result.rows}" var="row">
        <tbody>
        <tr>
            <td>${row.id}</td>
            <td>${row.first_name}</td>
            <td>${row.last_name}</td>
            <td>${row.age}</td>
            <td>${row.created_at}</td>
        </tr>
        </tbody>
    </c:forEach>
</table>
```

# XML Tags Example

````html

<c:set var="xmltext">
    <books>
        <book>
            <name>Spring Boot In Action</name>
            <author>LXC</author>
            <price>20</price>
        </book>

        <book>
            <name>Reactive Spring</name>
            <author>Josh Long</author>
            <price>50</price>
        </book>
    </books>
</c:set>
<x:parse xml="${xmltext}" var="output"/>

<ul class="list">
    <x:forEach select="$output/books/book/name" var="item">
        <li>Book Name:
            <x:out select="$item"/>
        </li>
    </x:forEach>
</ul>
````