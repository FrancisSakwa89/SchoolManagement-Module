<%--
  Created by IntelliJ IDEA.
  User: moringaschool
  Date: 10/12/19
  Time: 7:03 PM
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
    <script
            src="https://code.jquery.com/jquery-3.4.1.min.js"
            integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
            crossorigin="anonymous"></script>
</head>
<br><br>
<br><br>
<br>
<body>
<br><br><br><br>
<%--<% //In case, if Admin session is not set, redirect to Login page--%>
    <%--if((request.getSession(false).getAttribute("userId")== null) )--%>
    <%--{--%>
<%--%>--%>
<%--<jsp:forward page="/views/userLogin/login.jsp"></jsp:forward>--%>
<%--<%} %>--%>
<div class="container">
    <div class="table-responsive">
        <h1>ALL BOOKS</h1>
        <br />
        <table class="table table-bordered table-striped" id="table1">
            <tr>
                <th>Book Title</th>
                <th>ISBN NUMBER</th>
                <th>Author</th>
                <th>Publisher</th>
                <th>Status</th>


            </tr>
        </table>
    </div>
</div>
<script type="text/javascript">
        $.ajax({
            type: "GET",
            url: "http://localhost:8081/SchoolManagement/api/books/list",
            contentType: "application/json",
            dataType: "json",
            success: function (data) {
                if (data) {
                    console.log(data);
                    var len = data.length;
                    var txt = "";
                    if (len > 0) {
                        for (var i = 0; i < len; i++) {
                            if (data[i].bookId != null && data[i].isAvailable != null) {
                                txt += "<tr><td>" + data[i].bookTitle + "</td><td>" + data[i].ISBN + "</td></tr>";
                            }
                        }
                        if (txt != "") {
                            $("#table1").append(txt).removeClass("hidden");
                        }
                    }
                }
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert('error: ' + textStatus + ': ' + errorThrown);
            }
        });



</script>
</body>
</html>
