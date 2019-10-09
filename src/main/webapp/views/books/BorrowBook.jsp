<%--
  Created by IntelliJ IDEA.
  User: moringaschool
  Date: 10/4/19
  Time: 4:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/includes/body.jsp"%>
<%@include file="/views/books/SearchBookById.jsp"%>

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
<div class="container" style="text-align: center">
    <a href="addBook"><button type="submit" class="btn btn-info">Add Book</button></a>
    <a href="allBooks"><button type="submit" class="btn btn-info">Borrow Book</button></a>
    <a href="allBooks"><button type="submit" class="btn btn-info">Books Available</button></a>
    <a href="allBooks"><button type="submit" class="btn btn-info">Books Not Available</button></a>
</div>

<div class="container">
    <div class="row">
        <div class="col-8">
            <form method="post" action="books" style="margin-left: 25%">
                <div class="form-group">
                    <label for="bookId">Book Id</label>
                    <input type="number" class="form-control" name="bookId" id="bookId" aria-describedby="bookId" placeholder="bookId">
                    <small id="bookId" class="form-text text-muted">Your information is safe with us.</small>
                </div>

                <div class="form-group">
                    <label for="bookId">Student Id</label>
                    <input type="number" class="form-control" name="studentId" id="studentId" aria-describedby="studentId" placeholder="studentId">
                </div>


                <div class="form-group">
                    <label for="date">Issue Date</label>
                    <input type="date" class="form-control" name="issueDate" id="date" placeholder="Issue Date">
                </div>

                <div class="form-group">
                    <label for="date">Issue Period</label>
                    <input type="number" class="form-control" name="issuePeriod" id="issuePeriod" placeholder="Issue Period">
                </div>

                <div class="form-group">
                    <label for="date">Return Date</label>
                    <input type="date" class="form-control" name="returnDate" id="date" placeholder="Return Date">
                </div>

                <button type="submit" class="btn btn-info">Submit</button>
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

<script>

</script>
</body>
</html>
