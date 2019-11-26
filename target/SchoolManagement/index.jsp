<html>
<%@include file="includes/navbar.jsp"%>
<body>
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

<header>

<br><br>
    <%--
      Created by IntelliJ IDEA.
      User: moringaschool
      Date: 11/20/19
      Time: 10:51 AM
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
        <meta charset="utf-8">

        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <script src="https://code.jquery.com/jquery-2.1.3.min.js"></script>
    </head>
    <body>

    <div class="container">
        <br>
    <div class="jumbotron" style="text-align: center;margin-right: 20%;margin-left: 20%">
        <h2>Home Page</h2>
        <!-- Card -->
        <div class="card promoting-card">

            <!-- Card content -->
            <div class="card-body d-flex flex-row">

                <!-- Avatar -->
                <img src="https://images.unsplash.com/photo-1479142506502-19b3a3b7ff33?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=750&q=80" class="rounded-circle mr-3" height="50px" width="50px" alt="avatar">

                <!-- Content -->
                <div>

                    <!-- Title -->
                    <h4 class="card-title font-weight-bold mb-2">SYSTECH LIBRARY MANAGEMENT MODULE</h4>
                    <!-- Subtitle -->
                    <p class="card-text"><i class="far fa-clock pr-2"></i></p>

                </div>

            </div>

            <!-- Card image -->
            <div class="view overlay">
                <img class="card-img-top rounded-0" src="https://images.unsplash.com/photo-1479142506502-19b3a3b7ff33?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=750&q=80" alt="Card image cap">
                <a href="#!">
                    <div class="mask rgba-white-slight"></div>
                </a>
            </div>

            <!-- Card content -->
            <div class="card-body">

                <div class="collapse-content">

                    <!-- Text -->
                    <p class="card-text collapse" id="collapseContent">This is a library management module</p>
                    <!-- Button -->
                    <a class="btn btn-flat red-text p-1 my-1 mr-0 mml-1 collapsed"data-toggle="collapse" href="#collapseContent" aria-expanded="false" aria-controls="collapseContent">Read More</a>
                    <a href="index.jsp" class="btn btn-info p-1 my-1 mr-0 mml-1 float-right">Explore</a>

                </div>

            </div>

        </div>
        <!-- Card -->

    </div>
        <br>
    </div>
    </body>
    </html>
<style>
    body, html {
        height: 100%; }

    .container {
        background-image: url("https://mdbootstrap.com/wp-content/uploads/2019/02/back.jpg");
        background-position: center;
        background-repeat: no-repeat;
        -webkit-background-size: cover;
        background-size: cover; }
</style>
</body>
</html>
