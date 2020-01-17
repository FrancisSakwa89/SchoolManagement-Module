<%--
  Created by IntelliJ IDEA.
  User: moringaschool
  Date: 11/22/19
  Time: 2:49 PM
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
</head>
<body>
<!-- Grid container -->
<div class="container my-5">

    <!--Grid row-->
    <div class="row d-flex justify-content-center">

        <!-- Mobile box -->
        <div class="mobile-box view">
            <img src="https://mdbootstrap.com/img/Photos/Horizontal/Nature/6-col/img (122).jpg" class="bg-image"
                 alt="smaple image">
            <div class="mask gradient-mask">

                <!-- Navbar -->
                <div class="mobile-navbar d-flex justify-content-between p-2">

                    <div>
                        <i class="fas fa-signal"></i>
                        <i class="far fa-bell-slash"></i>
                        <i class="fas fa-wifi"></i>
                    </div>

                    <span>4:28 PM</span>

                    <div>
                        <i class="fab fa-bluetooth-b"></i>
                        <small>100%</small>
                        <i class="fas fa-battery-full"></i>
                    </div>

                </div>
                <!-- Navbar -->

                <a href="#" class="float-right font-weight-bold mr-4 mt-2">Skip
                </a>

                <!-- Content -->
                <div class="mt-5 p-4 text-center animated fadeIn">

                    <div class="md-form form-md">
                        <input type="email" id="email-input" class="form-control form-control-lg text-white">
                        <label for="email-input">E-mail</label>
                    </div>

                    <div class="md-form form-md">
                        <input type="password" id="password-input" class="form-control form-control-lg text-white">
                        <label for="password-input">Password</label>
                    </div>

                    <a href="">Forgot password?</a>

                    <!-- Sign in button -->
                    <button class="btn btn-outline-white btn-rounded btn-block my-4 waves-light z-depth-0" type="submit">Sign
                        in</button>

                    <!-- Sign in button -->
                    <button class="btn btn-outline-white btn-rounded btn-block my-4 waves-light z-depth-0" type="submit"><i
                            class="fab fa-facebook-f mr-2"></i>Facebook</button>

                    <!-- Register -->
                    <p>Not a member?
                        <a target="_blank" href="https://mdbootstrap.com/snippets/jquery/ascensus/413416/side" class="font-weight-bold">Register</a>
                    </p>


                </div>
                <!-- Content -->

            </div>
        </div>
        <!-- Mobile box -->




    </div>
    <!--Grid row-->

</div>
<!-- Grid container -->
<style>
    body, html {
        height: 100%; }

    body {

        background-image: url("https://mdbootstrap.com/wp-content/uploads/2019/02/back.jpg");
        background-position: center;
        background-repeat: no-repeat;
        -webkit-background-size: cover;
        background-size: cover; }

    .mobile-box {
        width: 360px;
        height: 640px;
        color: #fff;
        text-align: center;
        -webkit-box-shadow: 0 27px 24px 0 rgba(0, 0, 0, 0.2), 0 40px 77px 0 rgba(0, 0, 0, 0.92) !important;
        box-shadow: 0 27px 24px 0 rgba(0, 0, 0, 0.2), 0 40px 77px 0 rgba(0, 0, 0, 0.92) !important; }

    .view .bg-image {
        height: 100%; }

    .view .gradient-mask {
        background: -webkit-linear-gradient(rgba(0, 47, 75, 0.8) 0%, rgba(220, 66, 37, 0.8) 100%);
        background: -o-linear-gradient(rgba(0, 47, 75, 0.8) 0%, rgba(220, 66, 37, 0.8) 100%);
        background: -webkit-gradient(linear, left top, left bottom, from(rgba(0, 47, 75, 0.8)), to(rgba(220, 66, 37, 0.8)));
        background: linear-gradient(rgba(0, 47, 75, 0.8) 0%, rgba(220, 66, 37, 0.8) 100%);
        /* Chrome10+,Safari5.1+ */
        /* Opera 11.10+ */
        /* IE10+ */
        /* W3C */
        filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#002f4b', endColorstr='#00000000', GradientType=0); }

    .view a {
        color: #fff; }
    .view a:hover {
        color: #dfdfdf; }

    .view input[type=text], .view input[type=password], .view input[type=email] {
        border-bottom: 1px solid #fff; }

    .view .md-form input[type=text]:focus:not([readonly]), .view .md-form input[type=password]:focus:not([readonly]), .view .md-form input[type=email]:focus:not([readonly]) {
        border-bottom: 1px solid #bbdefb !important;
        -webkit-box-shadow: 0 1px 0 0 #bbdefb !important;
        box-shadow: 0 1px 0 0 #bbdefb !important; }

    .view .md-form label {
        color: #fff; }
    .view .md-form label.active {
        color: #bbdefb !important; }

    /* Remove chrome autofil background color */
    @-webkit-keyframes autofill {
        to {
            color: #fff;
            background: transparent;
        }
    }

    input:-webkit-autofill {
        -webkit-animation-name: autofill;
        -webkit-animation-fill-mode: both;
    }
    .md-form>input[type]:-webkit-autofill:not(.browser-default):not([type="search"])+label,
    .md-form  >input[type=date]:not(.browser-default)+label,
    .md-form  >input[type=time]:not(.browser-default)+label {
        transform: translateY(-25px);
        transform-origin: 0 0;
        font-size: .8rem;
    }

</style>
</body>
</html>
