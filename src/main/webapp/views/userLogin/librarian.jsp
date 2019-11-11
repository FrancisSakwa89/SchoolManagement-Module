<%--
  Created by IntelliJ IDEA.
  User: moringaschool
  Date: 10/26/19
  Time: 1:29 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/includes/navbar.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.8.10/css/mdb.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>


    <title>Admin Page</title>
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
<br><br><br><br><br><br><br>
<div style="text-align: center">
<h2>Librarian's Home</h2>
    Welcome your Librarian id is: <%=request.getAttribute("userId") %>, You logged in as:<%=request.getAttribute("userType") %>
    <br>
    <div class="btn-group">
        <button type="button" class="btn btn-info "><i class="fa fa-download"></i>Actions</button>
        <button type="button" class="btn btn-info dropdown-toggle px-3" data-toggle="dropdown"
                aria-haspopup="true" aria-expanded="false">
            <span class="sr-only"></span>
        </button>
        <div class="dropdown-menu">
            <a class="dropdown-item" href="addBook">Add Book</a>
            <a class="dropdown-item" href="api/books/getAvailableBooks">Books Available</a>
            <a class="dropdown-item" href="api/issues/list">Issue History</a>
            <a class="dropdown-item" href="api/returns/list">Return History</a>
            <a class="dropdown-item" href="api/books/getBookBorrowed">Borrowed Books</a>
            <a class="dropdown-item" href="allBooks">All Books</a>
        </div>
    </div>
    <%--<a href="addBook"><button class="btn btn-info">Add Book</button></a>--%>
    <%--<a href="api/books/getAvailableBooks"><button class="btn btn-info">Available Books</button></a>--%>
    <%--<a href="api/issues/list"><button class="btn btn-info">Issue History</button></a>--%>
    <%--<a href="api/returns/list"><button class="btn btn-info">Returned Books History</button></a>--%>
    <%--<a href="api/books/getBookBorrowed"><button class="btn btn-info">Borrowed Books</button></a>--%>
    <%--<a href="allBooks"><button class="btn btn-info">All Books</button></a>--%>
    <%--&lt;%&ndash;<a href="logout">Logout</a>&ndash;%&gt;--%>
</div>


</body>
</html>

