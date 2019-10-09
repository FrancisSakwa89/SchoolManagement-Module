<%--
  Created by IntelliJ IDEA.
  User: moringaschool
  Date: 10/4/19
  Time: 12:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Author Section</title>
</head>
<body>
<form method="POST" action="author" name="add">
    <% String action = request.getParameter("action");
        System.out.println(action);
    %>
    <% if (action.equalsIgnoreCase("edit")) {%>
    Author Name : <input type="text" name="authorName"
                       value="<c:out value="${author.name}" />" readonly="readonly"/> (You Can't Change this)<br />
    <%} else {%>
    Author Name : <input type="text" name="authorName"
                       value="<c:out value="${author.name}" />" /> <br />
    <%}%>

    <br>
    <%--Add author--%>

    <% if (action.equalsIgnoreCase("add")) {%>
    Author Name : <input type="text" name="authorName"
                         value="<c:out value="${author.name}" />" readonly="readonly"/> (You Can't Change this)<br />
    <%} else {%>
    New Author Name : <input type="text" name="authorName"
                         value="<c:out value="${author.name}" />" /> <br />
    <%}%>
    <input  type="submit" value="Submit" />
</form>
</body>
</html>
