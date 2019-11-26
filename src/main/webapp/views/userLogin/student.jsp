<%--
  Created by IntelliJ IDEA.
  User: moringaschool
  Date: 10/26/19
  Time: 1:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/views/student/studentDash.jsp"%>


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

</body>
</html>
