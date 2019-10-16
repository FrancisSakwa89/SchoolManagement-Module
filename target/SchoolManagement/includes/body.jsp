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
</nav>


<!--Navbar-->
<nav class="navbar navbar-expand-lg mb-4 " style="" >

    <img src="https://systechafrica.com/wp-content/uploads/2017/12/logo-1.png"><a class="navbar-brand" href="#"></a>


    <!-- Collapsible content -->
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <!-- Search form -->
        <form class="form-inline ml-auto">
            <div class="md-form my-0">
                <a class="navbar-brand dropdown-toggle mr-4"  data-toggle="dropdown" aria-haspopup="true"
                   aria-expanded="false">BOOKS PORTAL</a>

                <div class="dropdown-menu">
                    <a class="dropdown-item" href="addBook">Add Book</a>
                    <a class="dropdown-item" href="api/books/getAvailableBooks">Available Books</a>
                    <a class="dropdown-item" href="api/books/getBookBorrowed">Books Not Available</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="api/books/list">All Books</a>


                </div>
            </div>
            <ul class="navbar-nav mr-auto">
                <!-- Dropdown -->
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink1" data-toggle="dropdown" aria-haspopup="true"
                       aria-expanded="false">STUDENTLIB</a>
                    <div class="dropdown-menu dropdown-primary" aria-labelledby="navbarDropdownMenuLink1">
                        <a class="dropdown-item" href="stuDetails">Lib Details</a>
                        <a class="dropdown-item" href="books">Borrow Book</a>
                        <a class="dropdown-item" href="returnBook">Return Book</a>
                        <%--<a class="dropdown-item" href="#">Something else here</a>--%>
                    </div>
                </li>


                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink1" data-toggle="dropdown" aria-haspopup="true"
                       aria-expanded="false">PUBLISHERS</a>
                    <div class="dropdown-menu dropdown-primary" aria-labelledby="navbarDropdownMenuLink1">
                        <a class="dropdown-item" href="addPub">Add Publisher</a>
                        <a class="dropdown-item" href="#">View Publishers</a>
                        <a class="dropdown-item" href="#">Delete Publishers</a>
                    </div>
                </li>


            </ul>
        </form>
    </div>
    <!-- Collapsible content -->
</nav>


</body>
</html>
