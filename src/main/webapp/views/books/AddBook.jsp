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

</head>
<body>
<br><br>
<% //In case, if Admin session is not set, redirect to Login page
    response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Cache-Control", "no-store, must-revalidate" );
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
    if((request.getSession(false).getAttribute("userId")== null) )
    {
%>
<jsp:forward page="/views/userLogin/login.jsp"></jsp:forward>
<%} %>
<div class="container">
    <div class="row">
        <div class="col-8">
            <form method="post" action="addBook" style="margin-left: 25%">
                <div class="form-group">
                    <label for="bookTitle">Book Title</label>
                    <input type="text" class="form-control" required name="bookTitle" id="bookTitle" aria-describedby="bookTitle" placeholder="bookTitle">
                </div>



                <div class="form-group">
                    <label for="publisherName">Publisher Name</label>
                    <input type="text" class="form-control" required name="publisherName" id="publisherName" placeholder="Publisher Name">
                </div>

                <div class="form-group">
                    <label for="publisherCity">Publisher City</label>
                    <input type="text" class="form-control" required name="publisherCity" id="publisherCity" placeholder="Publisher City">
                </div>

                <div class="form-group">
                    <label for="publisherCountry">Publisher Country</label>
                    <input type="text" class="form-control" required name="publisherCountry" id="publisherCountry" placeholder="Publisher Country">
                </div>


                <div class="form-group">
                    <label for="authorFName">Author First Name</label>
                    <input type="text" class="form-control" required name="authorFName" id="authorFName" placeholder="Author Fist Name">
                </div>

                <div class="form-group">
                    <label for="authorMName">Author Middle Name</label>
                    <input type="text" class="form-control" required name="authorMName" id="authorMName" placeholder="Author Middle Name">
                </div>

                <div class="form-group">
                    <label for="authorLName">Author Last Name</label>
                    <input type="text" class="form-control" required name="authorLName" id="authorLName" placeholder="Author Last Name">
                </div>

                <div class="form-group">
                    <label for="isbn">ISBN Number</label>
                    <input type="text" class="form-control" required name="isbn" id="isbn" placeholder="ISBN Number">
                </div>


                <button type="submit" class="btn btn-info">Add</button>
                <a href="books"><button type="reset" class="btn btn-danger">Cancel</button></a>

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

    /*@media screen and (min-width: 320px) {*/
        /*body {*/
            /*font-size: 0.5em;*/
        /*}*/

    /*}*/
</style>

</body>
</html>
