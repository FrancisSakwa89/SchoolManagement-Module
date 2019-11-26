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
    <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.8.10/css/mdb.min.css" rel="stylesheet">
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/umd/popper.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.8.10/js/mdb.min.js"></script>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://code.jquery.com/jquery-2.1.3.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/all.js" integrity="sha384-xymdQtn1n3lH2wcu0qhcdaOpQwyoarkgLVxC/wZ5q7h9gHtxICrpcaSUfygqZGOe" crossorigin="anonymous"></script>

</head>
<body>
<br><br><br>
<div class="container h-100">
    <div class="row h-100 align-items-center justify-content-center">

        <div class="col-lg-5 col-md-8 col-sm-10 col-12">
            <form id="bsform" class="card shadow px-2 pt-4" action="register" method="post" enctype="multipart/form-data">
                <div class="card-header pt-3 border-0 ">
                    <h2 class="h3 text-secondary text-center m-0 font-weight-light">Create Account</h2>
                </div>
                <div class="card-body">
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
                        <label for="pass2">Confirm Password:</label><br>
                        <input type="password" name="pass2" id="pass2" class="form-control">
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
                    <p class="text-center mt-3 mb-4 text-info">
                        Already have an account?
                        <a class="font-weight-bold" href="login">Login</a>
                    </p>
                </div>

                </form>
                    </div>

                </div>

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
</body>
</html>
