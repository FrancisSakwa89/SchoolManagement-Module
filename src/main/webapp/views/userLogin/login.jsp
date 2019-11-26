<%--
  Created by IntelliJ IDEA.
  User: moringaschool
  Date: 11/18/19
  Time: 4:59 PM
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
<div class="container h-100">
    <div class="row h-100 align-items-center justify-content-center">

        <div class="col-lg-5 col-md-8 col-sm-10 col-12">
            <form id="bsform" class="card shadow px-2 pt-4" action="login" method="post">
                <div class="card-header pt-3 border-0 ">
                    <h2 class="h3 text-secondary text-center m-0 font-weight-light">Please Sign In</h2>
                </div>
                <p><span style="color:red"><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></span></p>
                <p><span style="color:red"><%=(request.getAttribute("errorMsg") == null) ? "" : request.getAttribute("errorMsg")%></span></p>

                <div class="card-body">
                    <div class="form-group">
                        <label for="userId">Librarian Id OR Student RegNo</label><br>
                        <input type="text" required name="userId" id="userId" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="password">Password:</label><br>
                        <input type="password" name="password" id="password" class="form-control">
                        <input type="checkbox" onclick="myFunction()">Show Password

                    </div>
                    <div class="d-flex font-weight-bold justify-content-center">
                        <div class="col-auto">
                            <a class="text-secondary" data-toggle="modal" data-target="#modalSubscriptionForm">Forgot password?</a>
                        </div>
                    </div>
                    <div class="card-footer bg-white border-0 px-0 mt-4">
                        <button type="submit" class="btn btn-lg btn-block btn-success">
                            Sign In
                        </button>
                        <p class="text-center mt-3 mb-4 text-secondary">
                            Doesn't have an account?
                            <a class="font-weight-bold" href="register">Sign Up</a>
                        </p>

                    </div>
                </div>
            </form>
        </div>

    </div>
</div>

<div class="modal fade" tabindex="-1" id="modalSubscriptionForm" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header text-center">
                <h4 class="modal-title w-100 font-weight-bold">Password Link</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form action="resetPassword" method="post">
                <div class="modal-body mx-3">
                    <div class="md-form mb-4">
                        <i class="fas fa-envelope prefix grey-text"></i>
                        <input type="email" id="form2" class="form-control validate" required name="email">
                        <label data-error="wrong" data-success="right" for="form2">Your email</label>
                    </div>

                </div>
                <div class="modal-footer d-flex justify-content-center">
                    <button class="btn btn-indigo">Send <i class="fas fa-paper-plane-o ml-1"></i></button>
                </div>
            </form>
        </div>
    </div>
</div>

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

