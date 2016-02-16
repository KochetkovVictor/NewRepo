<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title>Главная страница</title>
<head>
    <title>Main & Adding page</title>
</head>
<body>

<h1>
    Main Page
</h1>
<br>
<div>
    <a href="<s:url value="/user/add"/>">Добавить пользователя</a>
</div>
<div>
    <a href="<s:url value="/ListUsers?page=1&count=10"/>">Сисок пользователей</a>
</div>
<br>
<h3> Finding User </h3>

<c:url var="findByName" value="/user/${user.name}"/>
<form:form action="${findByName}" commandName="user" method="get">
    <table>
        <tr>
            <td>
                <form:label path="name">
                    <spring:message text="Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="name" />
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit"  value="<spring:message text="Find User"/>" />
            </td>
        </tr>

    </table>
</form:form>
</body>
</html>
