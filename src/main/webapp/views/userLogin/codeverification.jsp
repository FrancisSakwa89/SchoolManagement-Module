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

<form action="code" method="post">
    <div id="login">
        <div class="container">
            <div id="login-row" class="row justify-content-center align-items-center">
                <div id="login-column" class="col-md-6">
                    <div id="login-box" class="col-md-12">
                        <form id="login-form" class="form" action="" method="post">
                            <h3 class="text-center">Send Code OR
                                <a href="resend" class="text-info">Resend Code</a>
                            </h3>
                            <p><span style="color:red"><%=(request.getAttribute("errorMsg") == null) ? "" : request.getAttribute("errorMsg")%></span></p>

                            <h4>Check email and send code here..</h4>
                            <div class="form-group">
                                <label for="code">Enter Code</label><br>
                                <input type="text" required name="code" id="code" class="form-control">
                            </div>
                            <div class="form-group">
                                <input type="submit" name="submit" class="btn btn-info btn-md" value="Send">
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
