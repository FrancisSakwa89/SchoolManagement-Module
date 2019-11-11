<%--
  Created by IntelliJ IDEA.
  User: moringaschool
  Date: 10/16/19
  Time: 12:30 PM
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
<nav class="navbar navbar-expand-lg navbar-light bg-white py-3 shadow-sm">
    <div class="container">
        <img src="https://systechafrica.com/wp-content/uploads/2017/12/logo-1.png"><a class="navbar-brand" href="#"></a>
        <button type="button" data-toggle="collapse" data-target="#navbarContent" aria-controls="navbars" aria-expanded="false" aria-label="Toggle navigation" class="navbar-toggler">
            <span class="navbar-toggler-icon"></span>
        </button>


        <div id="navbarContent" class="collapse navbar-collapse" >
            <ul class="nav navbar-nav nav-flex-icons ml-auto">
                <!-- Level one dropdown -->
                <li class="nav-item dropdown">
                    <a id="dropdownMenu1" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="nav-link dropdown-toggle"><p>Hi <%=request.getAttribute("userName".toUpperCase()) %></p></a>
                    <ul aria-labelledby="dropdownMenu1" class="dropdown-menu border-0 shadow">
                        <li><a href="acc" class="dropdown-item">View Profile</a></li>
                        <!-- Level two dropdown-->
                        <li class="dropdown-submenu">
                            <a id="dropdownMenu2" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="dropdown-item dropdown-toggle"><i class="fa fa-user"></i> Profile Settings</a>
                            <ul aria-labelledby="dropdownMenu2" class="dropdown-menu border-0 shadow">
                                <li>
                                    <a tabindex="-1" href="#" class="dropdown-item"><i class="fa fa-envelope"></i>Settings</a>
                                </li>

                                <li><a href="#" class="dropdown-item">Change Password</a></li>
                                <li><a href="#" class="dropdown-item">Logout</a></li>
                            </ul>
                        </li>
                    </ul>
                </li>

                <li class="nav-item"><a href="#" class="nav-link">About</a></li>
                <li class="nav-item"><a href="#" class="nav-link">Services</a></li>
                <li class="nav-item"><a href="#" class="nav-link">Contact</a></li>
            </ul>
        </div>
    </div>
</nav>



<style>
    /*
*
* ==========================================
* CUSTOM UTIL CLASSES
* ==========================================
*
*/

    .dropdown-submenu {
        position: relative;
    }

    .dropdown-submenu>a:after {
        content: "\f0da";
        float: right;
        border: none;
        font-family: 'FontAwesome';
    }

    .dropdown-submenu>.dropdown-menu {
        top: 0;
        right: 100%;
        margin-top: 0px;
        margin-left: 90%;
    }

    /*
    *
    * ==========================================
    * FOR DEMO PURPOSES
    * ==========================================
    *
    */

    body {
        background: #4568DC;
        background: -webkit-linear-gradient(to right, #4568DC, #B06AB3);
        background: linear-gradient(to right, #4568DC, #B06AB3);
        min-height: 100vh;
    }

    code {
        color: #B06AB3;
        background: #fff;
        padding: 0.1rem 0.2rem;
        border-radius: 0.2rem;
    }

    @media (min-width: 991px) {
        .dropdown-menu {
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
    }

</style>
<!-- End -->
<script>
    $(function() {
        // ------------------------------------------------------- //
        // Multi Level dropdowns
        // ------------------------------------------------------ //
        $("ul.dropdown-menu [data-toggle='dropdown']").on("click", function(event) {
            event.preventDefault();
            event.stopPropagation();

            $(this).siblings().toggleClass("show");


            if (!$(this).next().hasClass('show')) {
                $(this).parents('.dropdown-menu').first().find('.show').removeClass("show");
            }
            $(this).parents('li.nav-item.dropdown.show').on('hidden.bs.dropdown', function(e) {
                $('.dropdown-submenu .show').removeClass("show");
            });

        });
    });

</script>
</body>
</html>
