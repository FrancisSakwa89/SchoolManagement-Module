<%--
  Created by IntelliJ IDEA.
  User: moringaschool
  Date: 10/5/19
  Time: 12:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/includes/body.jsp"%>
<html>
<head>
    <title>Sales</title>
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
</head>
<body>
<br><br><br><br>
<table class="table table-bordered" style="margin-left: 15%;width:70%">
    <thead>
    <tr>
        <th scope="col">Book Id</th>
        <th scope="col">Availability</th>
        <th scope="col">ISBN no.</th>
        <th scope="col">Publisher Id</th>
        <%--<th scope="col"></th>--%>
        <th scope="col">Title</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach items="${books}" var="book">
        <tr>
            <td>${book.id}</td>
            <td>${book.isAvailable}</td>
            <td>${book.isbn}</td>
            <td>${book.publisher}</td>
            <td>${book.title}</td>

        </tr>

    </c:forEach>
    </tbody>
</table>

<div style="margin-left: 30%">
    <a href="/index.jsp"><button class="btn btn-outline-info" type="reset">Back</button></a>
</div>
<br><br>
</body>
</html>
