<%--
  Created by IntelliJ IDEA.
  User: moringaschool
  Date: 10/26/19
  Time: 1:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/includes/navbar.jsp"%>

<html>
<head>
        <title>StudentPage</title>
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
    <h2>Student's Home</h2>
    Welcome and your student Reg Number is: <%=request.getAttribute("userId") %>, You logged in as:<%=request.getAttribute("userType") %>
    <br>
    <a href="stuDetails"><button class="btn btn-info">Lib Details</button></a>
    <a href="allBooks"><button class="btn btn-info">All Books</button></a>
    <a href="books"><button class="btn btn-info">Borrow Book</button></a>
    <a href="returnBook"><button class="btn btn-info">Return Book</button></a>
    <a href="renewBook"><button class="btn btn-info">Renew Book</button></a>
    <%--<a href="logout">Logout</a>--%>

</div>
</body>
</html>
