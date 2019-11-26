<%--
  Created by IntelliJ IDEA.
  User: moringaschool
  Date: 8/27/19
  Time: 1:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/includes/navbar.jsp"%>
<html>
<head>
    <title>ALL BOOKS</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
    <!-- Bootstrap core CSS -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <!-- Material Design Bootstrap -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.8.10/css/mdb.min.css" rel="stylesheet">
    <!-- JQuery -->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <!-- Bootstrap tooltips -->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/umd/popper.min.js"></script>
    <!-- Bootstrap core JavaScript -->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <!-- MDB core JavaScript -->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.8.10/js/mdb.min.js"></script>
    <meta charset="utf-8">

    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <script src="https://code.jquery.com/jquery-2.1.3.min.js"></script>
    <!------ Include the above in your HEAD tag ---------->
</head>
<% //In case, if Admin session is not set, redirect to Login page
    response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Cache-Control", "no-store, must-revalidate" );
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
    if((request.getSession(false).getAttribute("userId")== null) )
    {
%>
<jsp:forward page="/views/userLogin/login.jsp"></jsp:forward>
<%} %>
<body>
<br><br><br>
<%--<%--%>
<%--if (session.getAttribute("username") == null) {--%>
<%--response.sendRedirect("index.jsp");--%>
<%--}--%>

<%--%>--%>

<br><br>
<h1 style="text-align: center">ALL BOOKS</h1>
<p><span style="color:red"><%=(request.getAttribute("dltMsg") == null) ? "" : request.getAttribute("dltMsg")%></span></p>
<p><span style="color:red"><%=(request.getAttribute("notDltMsg") == null) ? "" : request.getAttribute("notDltMsg")%></span></p>
<table class="table table-bordered" style="margin-left: 15%;width:70%">
    <thead>
    <tr>
        <th scope="col">Book Title</th>
        <th scope="col">ISBN Number</th>
        <th scope="col">Author</th>
        <th scope="col">Publisher</th>
        <th scope="col">Availability</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach items="${books}" var="book">
        <tr>
                <%--        <th scope="row">1</th>--%>
                <%--<td><%=(request.getAttribute("title")) %></td>--%>
            <td>${book.title}</td>
            <td>${book.isbn}</td>
            <td>
        <c:forEach items="${book.authors}" var="author">
            ${author.name.firstName} ${author.name.middleName} ${author.name.lastName},
        </c:forEach>
            </td>
            <%--<td>${book.category}</td>--%>
            <%--<td>${post.date}</td>--%>
            <%--<td>${post.user.userName}</td>--%>
            <%--<td>${count}</td>--%>
            <td><a href="details?id=${book.id}" ><button class="btn btn-info">View</button></a></td>
            <td><a href="delete?id=${book.id}"><button class=" btn btn-danger btn-sm"><i class="fas fa-delete fa-2x" aria-hidden="true"></i>Delete</button></a></td>
                <%--<a href="addPost"><button class="btn btn-danger btn-small"><i class="fas fa-delete fa-2x" aria-hidden="true"></i>Delete</button></a>--%>

        </tr>

    </c:forEach>
    </tbody>
</table>

</body>
</html>
