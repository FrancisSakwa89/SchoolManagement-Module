<%--
  Created by IntelliJ IDEA.
  User: moringaschool
  Date: 10/30/19
  Time: 4:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/includes/navbar.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<br><br>
<br><br>

<form action="newPass" method="post">
    <div id="login">
        <div class="container">
            <div id="login-row" class="row justify-content-center align-items-center">
                <div id="login-column" class="col-md-6">
                    <div id="login-box" class="col-md-12">
                        <form id="login-form" class="form" action="" method="post">
                            <h3 class="text-center">SET YOUR NEW PASSWORD</h3>
                            <div class="form-group">
                                <label for="userId">Your Librarian Id/Student RegNo</label><br>
                                <input type="text" name="userId" id="userId" class="form-control">
                            </div>

                            <div class="form-group">
                                <label for="newPass">New Password:</label><br>
                                <input type="text" required name="newPass" id="newPass" class="form-control">
                            </div>
                                <div class="form-group">
                                    <input type="submit" name="submit" class="btn btn-success btn-md" value="Confirm">
                                    <input type="reset" name="reset" class="btn btn-danger btn-md" value="Cancel">
                                </div>


                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>


</form>



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
