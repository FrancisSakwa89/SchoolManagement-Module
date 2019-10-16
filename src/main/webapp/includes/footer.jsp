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
</head>
<body>
<div class="navbar navbar-expand-lg mb-4">
    <nav class="navbar navbar-expand-lg ">

        <!-- Navbar brand -->
        <a class="navbar-brand" href="#">Navbar</a>

        <!-- Collapse button -->
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#basicExampleNav" aria-controls="basicExampleNav"
                aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <!-- Collapsible content -->
        <div class="collapse navbar-collapse md-form my-0" id="basicExampleNav">

            <!-- Links -->
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Home
                        <span class="sr-only">(current)</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Features</a>
                </li>
                <!-- Dropdown -->
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink1" data-toggle="dropdown" aria-haspopup="true"
                       aria-expanded="false">Dropdown 1</a>
                    <div class="dropdown-menu dropdown-primary" aria-labelledby="navbarDropdownMenuLink1">
                        <a class="dropdown-item" href="#">Action</a>
                        <a class="dropdown-item" href="#">Another action</a>
                        <a class="dropdown-item" href="#">Something else here</a>
                    </div>
                </li>

                <!-- Dropdown -->
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink2" data-toggle="dropdown" aria-haspopup="true"
                       aria-expanded="false">Dropdown 2</a>
                    <div class="dropdown-menu dropdown-primary" aria-labelledby="navbarDropdownMenuLink2">
                        <a class="dropdown-item" href="#">Action</a>
                        <a class="dropdown-item" href="#">Another action</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="#">Something else here</a>
                        <a class="dropdown-item" href="#">Something else here</a>
                    </div>
                </li>

            </ul>
            <!-- Links -->

            <form class="form-inline">
                <div class="md-form my-0">
                    <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
                </div>
            </form>
        </div>
        <!-- Collapsible content -->

    </nav>
    <!--/.Navbar-->

</div>
</body>
</html>
