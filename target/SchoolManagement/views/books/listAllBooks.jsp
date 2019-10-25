<%--
  Created by IntelliJ IDEA.
  User: moringaschool
  Date: 10/5/19
  Time: 12:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/includes/navbar.jsp"%>
<html>
<head>
    <title>Sales</title>
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

<br><br><br><br><br>

<%--<div class="container">--%>
    <%--<div class="table-responsive">--%>
        <%--<h1>ALL BOOKS</h1>--%>
        <%--<br />--%>
        <%--<table class="table table-striped">--%>
            <%--<thead>--%>
            <%--<tr>--%>
                <%--<th>Book Title</th>--%>
                <%--<th>ISBN NUMBER</th>--%>
                <%--<th>Author</th>--%>
                <%--<th>Publisher</th>--%>
                <%--<th>Status</th>--%>
            <%--</tr>--%>
            <%--</thead>--%>

            <%--<tbody>--%>
            <%--<c:forEach items="${books}" var="pp">--%>
                <%--<tr>--%>
                    <%--<td><${pp.id}</td>--%>
                    <%--<td><${pp.title}</td>--%>
                    <%--<td><${pp.ISBN}</td>--%>
                    <%--<td><${pp.color}</td>--%>
                    <%--<td><${pp.datetime}</td>--%>
                <%--</tr>--%>
            <%--</c:forEach>--%>
            <%--</tbody>--%>

        <%--</table>--%>
    <%--</div>--%>
<%--</div>--%>


<%--<style>--%>
    <%--body{--%>
        <%--font-size: 1.2em;--%>
    <%--}--%>
<%--</style>--%>
<%--</body>--%>

<style>
    button{
        border-radius: 10px;
        height: 45px;
        width: 150px;
        text-align: center;
        background-color: #5499C7;
        font-size: 15px;
        color: #ffffff;
    }
    input{
        height: 35px;
        font-size: 15px;
    }
    table {
        border-collapse: collapse;
        width: 100%;
    }
    th, td {
        text-align: center;
        padding: 15px;
        font-size: 20px;
    }
    th {
        background-color: #5499C7;
        color: white;
        font-style: bold;
        font-size: 35px;
    }
</style>
<script >
    //JSON Object................
    var json_obj  = {
        type: "GET",
        url: "http://localhost:8081/SchoolManagement/api/books/list",
        contentType: "application/json",
        dataType: "json",
        success: function (data) {
            if (data) {
                console.log(data);
                var len = data.length;
            }
        }};
            //JSON Object End................
            //Create table and fetch data from JSON Object.
            $(document).ready(function () {
                $("button").click(function (data) {
                    var number_of_rows = json_obj.length;
                    var k = 0;
                    var table_body = '<table border="1" id="example"><thead><tr><th>Book Title</th><th>ISBN</th><th>AUTHOR</th><th>PUBLISHER</th></tr></thead><tbody>';
                    for (j in json_obj.books) {
                        for (i = 0; i < json_obj.books.length; i++) {
                            table_body += '<tr>';
                            table_body += '<td>';
                            table_body += json_obj.books[k].title["title"];
                            table_body += '</td>';

                            table_body += '<td>';
                            table_body += json_obj.books[k].isbn[i];
                            table_body += '</td>';

                            table_body += '</tr>';
                        }
                        k++;
                    }
                    table_body += '</tbody></table>';
                    $('#tableDiv').html(table_body);
                    //display data..........
                });
// for search function.................................. only............................
                $("#search").on("keyup", function () {
                    var value = $(this).val().toLowerCase();
                    $("table tr").filter(function (index) {
                        if (index > 0) {
                            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                        }
                    });
                });
//=================End=========================End===============================
            });
</script>
<body>
<div style="margin-top: 50px; margin-left: 250px; margin-right: 250px;">
    <button>View Books</button>
    <%--<input type="text" id="search" placeholder="Search data here....."></input>--%>
    <div id="tableDiv" style="margin-top: 40px">

    </div>
</div>
<p id="p1"></p>
</body>

</html>

