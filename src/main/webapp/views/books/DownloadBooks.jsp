<%--
  Created by IntelliJ IDEA.
  User: moringaschool
  Date: 11/8/19
  Time: 7:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/includes/navbar.jsp"%>

<html>
<head>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.8.10/css/mdb.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

    <title>Title</title>
</head>
<body>
<br><br><br><br>
<br><br><br><br>
<div style="text-align: center" id="mu">
    <h2>Click the Links below to Download Books details </h2>
    <br>
    <div class="btn-group">
        <button type="button" class="btn btn-info "><i class="fa fa-download"></i>Download As</button>
        <button type="button" class="btn btn-info dropdown-toggle px-3" data-toggle="dropdown"
                aria-haspopup="true" aria-expanded="false">
            <span class="sr-only"></span>
        </button>
        <div class="dropdown-menu">
            <a class="dropdown-item" href="csv">CSV</a>
            <a class="dropdown-item" href="exc">EXCEL</a>
            <a class="dropdown-item" href="xml">XML</a>
        </div>
    </div>

<%--<a href="csv"><button class="btn btn-success"><i class="fa fa-download"></i> Download as Csv</button></a>--%>
    <%--<a href="exc"><button class="btn btn-success"><i class="fa fa-download"></i> Download as Excel</button></a>--%>
    <%--<a href="stuDetails"><button class="btn btn-success"><i class="fa fa-download"></i> Download as Pdf</button></a>--%>
    <a href="pdf"><button class="btn btn-success" id="me"><i class="fa fa-print"></i> Print</button></a>
    <%--<a href="logout">Logout</a>--%>

</div>


</body>
</html>
