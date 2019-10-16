<%--
  Created by IntelliJ IDEA.
  User: moringaschool
  Date: 10/10/19
  Time: 4:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/includes/body.jsp"%>
<html>
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
<%--<p style='color:red;'>${message}</p>--%>
<div class="container">
    <div class="row">
        <div class="col-8">
<form style="margin-left: 25%" method="post" action="returnBook">

        <div class="form-group">
            <label for="bookIsbn">Book ISBN Number</label>
            <input type="text" class="form-control" id="bookIsbn" required name="bookIsbn" placeholder="Book ISBN Number">
        </div>

    <div class="form-group">
            <label for="registrationNumber">Student Registration Number</label>
            <input type="text" class="form-control" id="registrationNumber" required name="registrationNumber" placeholder="Student Registration  Number">
        </div>

        <div class="col-auto">
            <button type="submit" class="btn btn-primary mb-2">Return Book</button>
            <button type="reset" class="btn btn-danger mb-2">Cancel</button>
        </div>


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
