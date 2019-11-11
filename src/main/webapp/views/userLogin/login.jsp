<%--
  Created by IntelliJ IDEA.
  User: moringaschool
  Date: 10/25/19
  Time: 12:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.8.10/css/mdb.min.css" rel="stylesheet">
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script type="text/javascript"
            src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/umd/popper.min.js"></script>
    <script type="text/javascript"
            src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script type="text/javascript"
            src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.8.10/js/mdb.min.js"></script>
</head>

<body>
<br><br><br><br>

<form action="login" method="post">
    <div id="login">
        <div class="container">
            <div id="login-row" class="row justify-content-center align-items-center">
                <div id="login-column" class="col-md-6">
                    <div id="login-box" class="col-md-12">
                        <form id="login-form" class="form" action="" method="post">
                            <h3 class="text-center">Login OR
                                <a href="register" class="text-info">Register here</a>
                            </h3>
                            <p><span style="color:red"><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></span></p>
                            <p><span style="color:red"><%=(request.getAttribute("errorMsg") == null) ? "" : request.getAttribute("errorMsg")%></span></p>

                            <div class="form-group">
                                <label for="userId">Librarian Id OR Student RegNo</label><br>
                                <input type="text" required name="userId" id="userId" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="password">Password:</label><br>
                                <input type="password" name="password" id="password" class="form-control">
                                <input type="checkbox" onclick="myFunction()">Show Password

                            </div>
                            <div class="form-group">
                                <select required name="userType" id="" class="btn">
                                    <option>LOGIN AS</option>
                                    <option>LIBRARIAN</option>
                                    <option>STUDENT</option>
                                </select>
                            </div>

                            <div class="form-group">
                                <input type="submit" name="submit" class="btn btn-info btn-md" value="Login">
                            </div>


                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>


</form>

<div class="dropdown" style="margin-left: 45%; margin-bottom: 18%">
    <a class="btn btn-info dropdown-toggle" href="#" role="button" id="dropdownMenuLink"
       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
        FORGOT PASSWORD?
    </a>
    <p><span>${message}</span></p>

    <div class="dropdown-menu">
        <form class="px-4 py-3" action="resetPassword" method="post">
            <div class="form-group">
                <label for="email">Email address</label>
                <input type="email" required name="email" class="form-control" id="email" placeholder="Recovery Email">
            </div>

            <button type="submit" class="btn btn-info btn-md">Send Password Link</button>
        </form>
        <%--<div class="dropdown-divider"></div>--%>
        <%--<a class="dropdown-item" href="#">New around here? Sign up</a>--%>
        <%--<a class="dropdown-item" href="#">Forgot password?</a>--%>
    <%--</div>--%>
</div>

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
<script>
    function myFunction() {
        var x = document.getElementById("password");
        if (x.type === "password") {
            x.type = "text";
        } else {
            x.type = "password";
        }
    }

</script>

</body>

</html>
