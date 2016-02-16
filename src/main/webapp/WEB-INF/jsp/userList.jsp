<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title>
    Список пользователей
</title>
<style>
    ul.hr {
        margin: 0; /* Обнуляем значение отступов */
        padding: 4px; /* Значение полей */
    }
    ul.hr li {
        display: inline; /* Отображать как строчный элемент */
        margin-right: 5px; /* Отступ слева */
        border: 1px solid #000; /* Рамка вокруг текста */
        padding: 3px; /* Поля вокруг текста */
    }
</style>
<body>
<h2>UserList</h2>

<table >
    <tr>
        <th width="80">User ID</th>
        <th width="120">User Name</th>
        <th width="120">User Age</th>
        <th width="120">User isAdmin</th>
        <th width="120">User Created Date</th>
        <th width="60">Edit</th>
        <th width="60">Delete</th>
    </tr>
    <c:forEach items="${listOfUsers}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.age}</td>
            <td>${user.isAdmin}</td>
            <td>${user.createdDate}</td>
            <td><a href="<c:url value='/edit/${user.id}/' />" >Edit</a></td>
            <td><a href="<c:url value='/remove/${user.id}/' />" >Delete</a></td>
        </tr>
    </c:forEach>
</table>
<c:choose>
    <c:when test="${allUsersListSize%10>0}">
        <c:set var="endPage" value="${allUsersListSize/10+1}"/>
    </c:when>
    <c:otherwise>
        <c:set var="endPage" value="${allUsersListSize/10}"/>
    </c:otherwise>
    </c:choose>
<div>
    <ul class="hr">
<c:forEach begin="1" end="${endPage}" var="page">
        <li><a href="<c:url value='/ListUsers?page=${page}&count=10'/>">${page}</a></li>
</c:forEach>

</div>
<a href="/">To the main Page</a>
</body>
</html>
