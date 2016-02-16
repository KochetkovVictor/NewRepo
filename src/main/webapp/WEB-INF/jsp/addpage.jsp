<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Добавление Юзера</title>
</head>
<body>
<h1>Create New User</h1>

<c:url var="saveUrl" value="/user/add" />
<form:form modelAttribute="newUser" method="POST" action="${saveUrl}">
    <table>
        <tr>
            <td><form:label path="name">First Name:</form:label></td>
            <td><form:input path="name"/></td>
        </tr>

        <tr>
            <td><form:label path="age">Age</form:label></td>
            <td><form:input path="age"/></td>
        </tr>

        <tr>
            <td><form:label path="isAdmin">Is Admin?</form:label></td>
            <td><form:input path="isAdmin"/></td>
        </tr>
    </table>

    <input type="submit" value="Save" />
</form:form>
<a href="/">To the main Page</a>
</body>
</html>
