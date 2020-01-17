<%--
  Created by IntelliJ IDEA.
  User: moringaschool
  Date: 10/3/19
  Time: 12:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Body</title>
    <!-- Font Awesome -->
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

<!-- navbar -->

<nav class="navbar navbar-expand-md navbar-light">

    <%--<a class="navbar-brand"><img src="https://systechafrica.com/wp-content/uploads/2017/12/logo-1.png"  class="img-responsive"></a>--%>

    <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#nav">

        <span class="navbar-toggler-icon"></span>

    </button>

    <div class="collapse navbar-collapse justify-content-between" id="nav">

        <ul class="navbar-nav">

            <li class="nav-item" >

                <a class="nav-link" href="index.jsp">HOME</a>

            </li>

            <li class="nav-item">

                <a class="nav-link " href="acc">PROFILE</a>

            </li>

            <li class="nav-item">

                <a class="nav-link " href="logout">LOGOUT</a>

            </li>

            <li class="nav-item">

                <a class="nav-link " href="bd">DOWNLOAD</a>

            </li>

        </ul>


        <!-- Search bar -->

        <form class="form-inline ml-3" method="post" action="searchBook">

            <div class="input-group">

                <input type="text"  required name="bookIsbn" class="form-control " placeholder="Search Book Isbn" >

                <button type="submit"><i class="fa fa-search"></i></button>

            </div>

        </form>

    </div>

</nav>

</body>
</html>
