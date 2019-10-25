<%--
  Created by IntelliJ IDEA.
  User: moringaschool
  Date: 10/6/19
  Time: 9:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/includes/navbar.jsp"%>
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
<br><br><br><br>
<div class="container">
    <div class="row">
        <div class="col-8">
            <form method="post" action="addPub" style="margin-left: 25%">
                <div class="form-group">
                    <label for="pubName">Publisher Name</label>
                    <input type="text" class="form-control" id="pubName" required name="pubName" aria-describedby="pubName" placeholder="pubName">
                </div>

                <div class="form-group">
                    <label for="pubCity">Publisher City</label>
                    <input type="text" class="form-control" id="pubCity" required name="pubCity" aria-describedby="pubCity" placeholder="pubCity">
                </div>


                <div class="form-group">
                    <label for="pubCountry">Publisher Country</label>
                    <input type="text" class="form-control" name="pubCountry" id="pubCountry" placeholder="pubCountry">
                </div>

                <button type="submit" class="btn btn-info">Add Publisher</button>
                <button type="reset" class="btn btn-danger">Cancel</button>

            </form>

        </div>
    </div>
</div>
<style>
    .container {
        padding: 2rem 0rem;
    }

    h4 {
        margin: 2rem 0rem 1rem 0rem;
    }
</style>

</body>
</html>
