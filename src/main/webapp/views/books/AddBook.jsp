<%--
  Created by IntelliJ IDEA.
  User: moringaschool
  Date: 10/6/19
  Time: 9:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/includes/navbar.jsp" %>

<html>
<head>
    <title>Title</title>

</head>
<body>
<br><br>
<% //In case, if Admin session is not set, redirect to Login page
    response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Cache-Control", "no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
    if ((request.getSession(false).getAttribute("userId") == null)) {
%>
<jsp:forward page="/views/userLogin/login.jsp"></jsp:forward>
<%} %>

<div class="container">
    <div class="row">
        <div class="col-8">
            <form method="post" action="addBook" style="margin-left: 25%">
                <div class="form-group">
                    <label for="bookTitle">Book Title</label>
                    <input type="text" class="form-control" required name="bookTitle" id="bookTitle"
                           aria-describedby="bookTitle" placeholder="bookTitle">
                </div>

                <div class="form-group">
                    <label for="publisherName">Publisher Name</label>
                    <input type="text" class="form-control" required name="publisherName" id="publisherName"
                           placeholder="Publisher Name">
                </div>

                <div class="form-group">
                    <label for="publisherCity">Publisher City</label>
                    <input type="text" class="form-control" required name="publisherCity" id="publisherCity"
                           placeholder="Publisher City">
                </div>

                <div class="form-group">
                    <label for="publisherCountry">Publisher Country</label>
                    <input type="text" class="form-control" required name="publisherCountry" id="publisherCountry"
                           placeholder="Publisher Country">
                </div>


                <div class="form-group">
                    <label for="authorFName">Author First Name</label>
                    <input type="text" class="form-control" required name="authorFName" id="authorFName"
                           placeholder="Author Fist Name">
                </div>

                <div class="form-group">
                    <label for="authorMName">Author Middle Name</label>
                    <input type="text" class="form-control" required name="authorMName" id="authorMName"
                           placeholder="Author Middle Name">
                </div>

                <div class="form-group">
                    <label for="authorLName">Author Last Name</label>
                    <input type="text" class="form-control" required name="authorLName" id="authorLName"
                           placeholder="Author Last Name">
                </div>

                <div class="form-group">
                    <label for="isbn">ISBN Number</label>
                    <input type="text" class="form-control" required name="isbn" id="isbn" placeholder="ISBN Number">
                </div>


                <button type="submit" class="btn btn-info">Add</button>
                <a href="books">
                    <button type="reset" class="btn btn-danger" onclick="sendAjax()">Cancel</button>
                </a>

                <%--<div class="form-group col-md-6">--%>
                    <%--<div class="modal fade" id="modalSubscriptionForm" tabindex="-1" role="dialog"--%>
                         <%--aria-labelledby="myModalLabel"--%>
                         <%--aria-hidden="true">--%>
                        <%--<div class="modal-dialog" role="document">--%>
                            <%--<div class="modal-content">--%>
                                <%--<div class="modal-header text-center">--%>
                                    <%--<h4 class="modal-title w-100 font-weight-bold">New Publisher Details</h4>--%>
                                    <%--<button type="button" class="close" data-dismiss="modal" aria-label="Close">--%>
                                        <%--<span aria-hidden="true">&times;</span>--%>
                                    <%--</button>--%>
                                <%--</div>--%>
                                <%--<div class="modal-body mx-3">--%>
                                    <%--<div class="md-form mb-5">--%>
                                        <%--<i class="fas fa-user prefix grey-text"></i>--%>
                                        <%--<input type="text" id="form3" required name="publisherName"--%>
                                               <%--class="form-control validate">--%>
                                        <%--<label data-error="wrong" data-success="right" for="form3">Publisher--%>
                                            <%--Name</label>--%>
                                    <%--</div>--%>

                                    <%--<div class="md-form mb-4">--%>
                                        <%--<i class="fas fa-envelope prefix grey-text"></i>--%>
                                        <%--<input type="email" id="form2" required name="publisherCity"--%>
                                               <%--class="form-control validate">--%>
                                        <%--<label data-error="wrong" data-success="right" for="form2">Publisher--%>
                                            <%--City</label>--%>
                                    <%--</div>--%>
                                    <%--<div class="md-form mb-4">--%>
                                        <%--<i class="fas fa-envelope prefix grey-text"></i>--%>
                                        <%--<input type="email" id="form2" required name="publisherCountry"--%>
                                               <%--class="form-control validate">--%>
                                        <%--<label data-error="wrong" data-success="right" for="form2">Publisher--%>
                                            <%--Country</label>--%>
                                    <%--</div>--%>

                                <%--</div>--%>
                                <%--<div class="modal-footer d-flex justify-content-center">--%>
                                    <%--<button class="btn btn-indigo">Add <i class="fas fa-paper-plane-o ml-1"></i>--%>
                                    <%--</button>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</div>--%>
                <%--<div class="form-group col-md-6">--%>
                    <%--<div class="text-center">--%>
                        <%--<a href="" class="btn btn-default btn-rounded mb-4" data-toggle="modal"--%>
                           <%--data-target="#modalSubscriptionForm">New Publisher</a>--%>
                    <%--</div>--%>

                    <%--<div class="modal fade" id="modalLoginForm" tabindex="-1" role="dialog"--%>
                         <%--aria-labelledby="myModalLabel"--%>
                         <%--aria-hidden="true">--%>
                        <%--<div class="modal-dialog" role="document">--%>
                            <%--<div class="modal-content">--%>
                                <%--<div class="modal-header text-center">--%>
                                    <%--<h4 class="modal-title w-100 font-weight-bold">Existing Publisher Id</h4>--%>
                                    <%--<button type="button" class="close" data-dismiss="modal" aria-label="Close">--%>
                                        <%--<span aria-hidden="true">&times;</span>--%>
                                    <%--</button>--%>
                                <%--</div>--%>
                                <%--<div class="modal-body mx-3">--%>
                                    <%--<div class="md-form mb-5">--%>
                                        <%--<i class="fas fa-envelope prefix grey-text"></i>--%>
                                        <%--<input type="number" id="defaultForm-email" required name="publisherId"--%>
                                               <%--class="form-control validate">--%>
                                        <%--<label data-error="wrong" data-success="right" for="defaultForm-email">Publisher--%>
                                            <%--Id</label>--%>
                                    <%--</div>--%>

                                <%--</div>--%>
                                <%--<div class="modal-footer d-flex justify-content-center">--%>
                                    <%--<button class="btn btn-default">Save</button>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    <%--</div>--%>

                    <%--<div class="text-center">--%>
                        <%--<a href="" class="btn btn-default btn-rounded mb-4" data-toggle="modal"--%>
                           <%--data-target="#modalLoginForm">Existing Publisher</a>--%>
                    <%--</div>--%>
                <%--</div>--%>

            <%--</form>--%>
        <%--</div>--%>
    <%--</div>--%>

    <%--<form class="form-inline" style="margin-left: 15%" action="addBook" method="POST">--%>
    <%--<div class="form-group mr-2">--%>
    <%--<label class="sr-only" for="bookTitle">Book Title</label>--%>
    <%--<input type="text" class="form-control" id="bookTitle" placeholder="bookTitle">--%>
    <%--</div>--%>
    <%--<br>--%>
    <%--<div class="form-group mr-2">--%>
    <%--<label class="sr-only" for="publisherName">Publisher Name</label>--%>
    <%--<input type="text" class="form-control" id="publisherName" placeholder="Publisher Name">--%>
    <%--</div>--%>
    <%--<br>--%>

    <%--<div class="form-group mr-2">--%>
    <%--<label class="sr-only" for="publisherCity">Publisher City</label>--%>
    <%--<input type="text" class="form-control" id="publisherCity" placeholder="Publisher City">--%>
    <%--</div>--%>
    <%--<br>--%>

    <%--<div class="form-group mr-2">--%>
    <%--<label class="sr-only" for="publisherCountry">Publisher Country</label>--%>
    <%--<input type="text" class="form-control" id="publisherCountry" placeholder="Publisher Country">--%>
    <%--</div>--%>
    <%--<br>--%>

    <%--<div class="form-group mr-2">--%>
    <%--<label class="sr-only" for="authorFName">Author First Name</label>--%>
    <%--<input type="text" class="form-control" id="authorFName" placeholder="Author First Name">--%>
    <%--</div>--%>
    <%--<br>--%>

    <%--<div class="form-group mr-2">--%>
    <%--<label class="sr-only" for="authorMName">Author Middle Name</label>--%>
    <%--<input type="text" class="form-control" id="authorMName" placeholder="Author Middle Name">--%>
    <%--</div>--%>
    <%--<br>--%>

    <%--<div class="form-group mr-2">--%>                        session.setAttribute("userType", user.getUserType());

    <%--<label class="sr-only" for="authorLName">Author Last Name</label>--%>
    <%--<input type="text" class="form-control" id="authorLName" placeholder="Author Last Name">--%>
    <%--</div>--%>
    <%--<div class="form-group mr-2">--%>
    <%--<label class="sr-only" for="isbn">ISBN Number</label>--%>
    <%--<input type="text" class="form-control" id="isbn" placeholder="ISBN Number">--%>
    <%--</div>--%>
    <%--<br>--%>

    <%--<button type="submit" class="btn btn-primary">Add</button>--%>
    <%--<button type="reset" class="btn btn-danger">Cancel</button>--%>
    <%--</form>--%>


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
