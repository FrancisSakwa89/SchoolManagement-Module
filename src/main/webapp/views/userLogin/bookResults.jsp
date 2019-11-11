<%--
  Created by IntelliJ IDEA.
  User: moringaschool
  Date: 10/27/19
  Time: 12:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/includes/navbar.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<% //In case, if Student session is not set, redirect to Login page
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
<br><br><br><br><br><br><br><br>

<div style="text-align: center">
    <h2>Search Results</h2>
    Welcome you searched for book ISBN: <%=request.getAttribute("bookIsbn") %>, And We got: <%=request.getAttribute("count") %> Book(s)
    <br>
<a href="api/books/sb"><button class="btn btn-info">View</button></a>

</div>
</body>
</html>
