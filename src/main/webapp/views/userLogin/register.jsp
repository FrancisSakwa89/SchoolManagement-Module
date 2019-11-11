<%--
  Created by IntelliJ IDEA.
  User: moringaschool
  Date: 10/26/19
  Time: 12:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
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
<br><br><br>

<form action="register" method="post" enctype="multipart/form-data">
    <div id="login">
        <div class="container">
            <div id="login-row" class="row justify-content-center align-items-center">
                <div id="login-column" class="col-md-6">
                    <div id="login-box" class="col-md-12">
                        <form id="login-form" class="form" action="" method="post">
                            <h3 class="text-center">Create Account
                            </h3>
                            <p><span style="color:red"><%=(request.getAttribute("dMsg") == null) ? "" : request.getAttribute("dMsg")%></span></p>
                            <div class="form-group">
                                <label for="userId">Librarian Id OR Student RegNo</label><br>
                                <input type="text" required name="userId" id="userId" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="email">Email</label><br>
                                <input type="email" required name="email" id="email" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="file">upload photo</label><br>
                                <input type="file" name="photo" id="file" size="10" required="required">
                            </div>

                            <div class="form-group">
                                <label for="username">Username</label><br>
                                <input type="text" required name="username" id="username" class="form-control">
                            </div>

                            <div class="form-group">
                                <label for="password">Password:</label><br>
                                <input type="password" name="password" id="password" class="form-control">
                            </div>

                            <div class="form-group">
                                <select required name="user" id="" class="btn">
                                    <option>REGISTER AS</option>
                                    <option>LIBRARIAN</option>
                                    <option>STUDENT</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <input type="submit" name="submit" class="btn btn-success btn-md" value="Create Account">
                            </div>
                            <div id="register-link" class="text-right">
                                <a href="login" class="text-info">Back to Login</a>
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
