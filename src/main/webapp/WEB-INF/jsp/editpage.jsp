<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit choosen user</title>
</head>
<c:url var="editUrl" value="/edit/${editeduser.id}/"/>
<form:form modelAttribute="editeduser" method="POST" action="${editUrl}">
    <table>
        <tr>
            <td><form:label path="id">ID:</form:label></td>
            <td><form:input path="id" disabled="true"/></td>
        </tr>
        <tr>
            <td><form:label path="name">First Name:</form:label></td>
            <td><form:input path="name" disabled="false"/></td>
        </tr>

        <tr>
            <td><form:label path="age">Age</form:label></td>
            <td><form:input path="age" disabled="false"/></td>
        </tr>

        <tr>
            <td><form:label path="isAdmin">Is Admin?</form:label></td>
            <td><form:input path="isAdmin" disabled="false"/></td>
        </tr>
    </table>

    <input type="submit" value="Edit" />
</form:form>
<a href="/">To the main Page</a>
</body>
</html>
