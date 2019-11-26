<%--
  Created by IntelliJ IDEA.
  User: moringaschool
  Date: 10/26/19
  Time: 10:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

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
<br><br><br><br>
<form action="acc" method="post">
    <div id="login">
        <div class="container">
            <div id="login-row" class="row justify-content-center align-items-center">
                <div id="login-column" class="col-md-6">
                    <div id="login-box" class="col-md-12">
                        <table class="table table-bordered" style="margin-left:5%;width:50%">
                            <thead>
                            <tr>
                                <th scope="col">Username</th>
                                <th scope="col">Photo</th>
                                <th scope="col">Occupation</th>
                                <th scope="col">Edit</th>
                                <th scope="col">Change Password</th>

                            </tr>
                            </thead>
                            <tbody>
                            <%--<c:forEach items="${user}" var="user">--%>
                                <tr>
                                    <td>${user.userName}</td>
                                    <td></td>
                                    <td>${user.userType}</td>
                                    <td>
                                        <a href="upAcc?userId=${user.userId}" class="btn btn-success">Edit</a>
                                    </td>
                                    <td>
                                        <a href="newPass" class="btn btn-success" >Change Password</a>
                                    </td>
                                </tr>

                            <%--</c:forEach>--%>
                            </tbody>
                        </table>

                    </div>
                    </div>
                </div>
            </div>
        </div>
    </div>


</form>


<%--<a href="upAcc?userId=${user.userId}" ><button class="btn btn-success" type="submit" style="text-align: center">Edit</button></a>--%>


<style>
    body {
        /*margin: 0;*/
        /*padding: 0;*/
        /*height: 70vh;*/
    }

    #login .container #login-row #login-column #login-box {
        margin-top: 40px;
        max-width: 600px;
        height: 320px;
    }

    #login .container #login-row #login-column #login-box #login-form {
        padding: 20px;
    }

    #login .container #login-row #login-column #login-box #login-form #register-link {
        margin-top: -75px;
    }
</style>

</body>
</html>
