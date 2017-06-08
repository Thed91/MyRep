<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Search</title>
</head>
<body>
<h3><a href="/"><input type="submit" value="Back to main menu"></a></h3>
<h1 align="center">Search list</h1>
<div align="center">
    <c:url var="searchAction" value="/search"/>
    <form:form action="${searchAction}">
    <form method="post" action="search">
        <input type="text" name="searchName" placeholder="Enter search name"/>
        <input type="submit" value="Search"/>
    </form>
</div>
</form:form>
</div>
<br>
<div><table align="center" border="2">
    <th>ID</th>
    <th>NAME</th>
    <th>AGE</th>
    <th>ADMIN?</th>
    <th>CREATE DATE</th>
    <th>EDIT?</th>
    <th>DELETE?</th>
    <c:forEach var="user" items="${searchList}">
        <tr align="center">
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.age}</td>
            <td><c:if test="${user.admin}">Admin</c:if></td>
            <td>${user.createDate}</td>
            <td><a href="<c:url value='/edit/${user.id}'/>">Edit</a></td>
            <td><a href="<c:url value='/delete/${user.id}'/>">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</div>
</body>
</html>
