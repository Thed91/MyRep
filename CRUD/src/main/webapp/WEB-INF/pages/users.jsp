<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>

<html>
<head>
    <title>User list</title>
</head>
<body>
<h1 align="center">User list</h1>
<div align="center">
    <c:url var="searchAction" value="/search"/>
    <form:form action="${searchAction}" commandName="search">
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
    <c:forEach var="user" items="${userList}">
        <tr align="center">
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.age}</td>
            <td><c:if test="${user.admin}">Admin</c:if></td>
            <td>${user.createDate}</td>
            <td><a href="<c:url value='/edit/${user.id}/?page=${page}'/>">Edit</a></td>
            <td><a href="<c:url value='/delete/${user.id}'/>">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</div>
<div align="center">
    Pages:
    <c:choose>
        <c:when test="${records%10==0}">
            <c:forEach begin="0" end="${records/10-1}" var="thisPage">
                <a href="/?page=${thisPage}"> ${thisPage+1}</a>
            </c:forEach>
        </c:when>
        <c:when test="${records%10!=0}">
            <c:forEach begin="0" end="${records/10}" var="thisPage">
                <a href="/?page=${thisPage}"> ${thisPage+1}</a>
            </c:forEach>
        </c:when>
    </c:choose>
</div>
<div align="center">
<c:url var="addAction" value="/users/add"/>
<form:form action="${addAction}" commandName="user">
    <c:if test="${!empty user.name}">

        <div>
            <div>
                <form:label path="id">
                    <spring:message text="ID"/>
                </form:label>
            </div>
            <form:input path="id" readonly="true" size="8" disabled="true"/>
            <form:hidden path="id"/>
        </div>
    </c:if>
    <div>
        <div>
            <form:label path="name">
                <spring:message text="Name"/>
            </form:label>
        </div>
        <form:input path="name"/>
    </div>

    <div>
        <div>
            <form:label path="age">
                <spring:message text="Age"/>
            </form:label>
        </div>
        <form:input path="age"/>
    </div>
    <div>
        <div>
            Admin?
        </div>
        <div><form:checkbox path="admin"/></div>
    </div>

    <div class="button">
        <c:if test="${!empty user.name}">
            <input type="submit"
                   value="<spring:message text="Edit User"/>"/>
        </c:if>
        <c:if test="${empty user.name}">
            <input type="submit"
                   value="<spring:message text="Add User"/>"/>
        </c:if>
    </div>
</form:form>
</div>
</body>
</html>
