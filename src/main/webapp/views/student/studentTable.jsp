<%--
  Created by IntelliJ IDEA.
  User: moringaschool
  Date: 11/20/19
  Time: 3:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/includes/navbar.jsp"%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.8.10/css/mdb.min.css" rel="stylesheet">
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/umd/popper.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.8.10/js/mdb.min.js"></script>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://code.jquery.com/jquery-2.1.3.min.js"></script>
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
<br><br>
<main>
    <div class="container my-5">
        <div class="card-body text-center">
            <h4 class="card-title">Library Details</h4>
            <p class="card-text">This a student's view</p>
        </div>
        <div class="card">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th scope="col">Book Title</th>
                    <th scope="col">ISBN Number</th>
                    <th scope="col">Author</th>
                    <th scope="col">Is Available</th>
                    <th scope="col">Action</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <c:forEach items="${books}" var="book">
                <tr>

                    <td>${book.title}</td>
                    <td>${book.isbn}</td>
                    <td>
                        <c:forEach items="${book.authors}" var="author">
                            ${author.name.firstName} ${author.name.middleName} ${author.name.lastName}
                        </c:forEach>
                    </td>
                    <%--<td>--%>
                        <%--<c:forEach items="${book.publisher}" var="publisher">--%>
                            <%--${publisher.publisherName} ${publisher.publisherCity} ${publisher.publisherCountry}--%>
                        <%--</c:forEach>--%>
                    <%--</td>--%>
                    <td>${book.isAvailableStr}</td>
                    <td><a class="btn btn-sm btn-info" href="books"><i class="fas fa-info-circle"></i> Borrow</a> </td>
                </tr>

                </c:forEach>
                </tbody>
            </table>
        </div>

    </div>
</main>

</body>
<style>

    footer {

        margin-top: 20px;
        padding-top: 20px;
    }
</style>
</html>

