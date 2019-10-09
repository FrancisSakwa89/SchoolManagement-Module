<%--
  Created by IntelliJ IDEA.
  User: moringaschool
  Date: 10/4/19
  Time: 12:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Show All Authors</title>
</head>
<body>
<table border=1>
    <thead>
    <tr>
        <th>Author Id</th>
        <th>Author Name</th>
        <th colspan=2>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${author}" var="author">
        <tr>
            <td><c:out value="${user.id}" /></td>
            <td><c:out value="${user.author}" /></td>
            <td><a href="author?action=edit&authorId=<c:out value="${user.name}"/>">Update</a></td>
            <td><a href="author?action=delete&authorId=<c:out value="${user.name}"/>">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<p><a href="author?action=add">Add Author</a></p>
</body>
</html>
