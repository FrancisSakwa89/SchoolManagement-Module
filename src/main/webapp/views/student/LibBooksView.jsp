<%--
  Created by IntelliJ IDEA.
  User: moringaschool
  Date: 11/20/19
  Time: 3:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/includes/navbar.jsp"%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.8.10/css/mdb.min.css" rel="stylesheet">
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/umd/popper.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.8.10/js/mdb.min.js"></script>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://code.jquery.com/jquery-2.1.3.min.js"></script>

    </head>
<body>
<br>
<br>

<main>
    <div class="container my-5">
        <div class="card-body text-center">
            <h4 class="card-title">Library Details</h4>
            <p class="card-text">This a Librarian view</p>
        </div>
        <div class="card">
            <button id="add__new__list" type="button" class="btn btn-success position-absolute" data-toggle="modal" data-target=".bd-example-modal-lg" onclick="showNotification('top','right')"><i class="fas fa-plus"></i> Add a new Book</button>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th scope="col">Book Title</th>
                    <th scope="col">ISBN Number</th>
                    <th scope="col">Author</th>
                    <th scope="col">Is Available</th>
                    <th scope="col">Edit / Delete List</th>
                    <th scope="col">More Details</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                <c:forEach items="${books}" var="book">
                    <tr>

                    <td>${book.title}</td>
                    <td>${book.isbn}</td>
                    <td>
                        <c:forEach items="${book.authors}" var="author">
                            ${author.name.firstName} ${author.name.middleName} ${author.name.lastName}
                        </c:forEach>
                    </td>
                    <td>${book.isAvailableStr}</td>
                    <td>
                        <a class="btn btn-sm btn-primary" href="#"><i class="far fa-edit"></i> edit</a>
                        <a class="btn btn-sm btn-danger" href="#" id="btn-show-dialog"><i class="fas fa-trash-alt"></i> delete</a>
                    </td>
                    <td><a class="btn btn-sm btn-info" href="#"><i class="fas fa-info-circle"></i> Details</a> </td>
                </tr>

                </c:forEach>
                </tbody>
            </table>
        </div>
        <!-- Large modal -->


        <div class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="card-body text-center">
                        <h4 class="card-title">Add New Book Form</h4>
                        <p class="card-text">Fill the form below.</p>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class=" card col-8 offset-2 my-2 p-3">
                        <form action="addBook" method="post">
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
                            <div class="form-group text-center">
                                <button type="submit" class="btn btn-primary btn-small">Add</button>
                                <button type="reset" class="btn btn-danger btn-small">Cancel</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div style="text-align: center" id="mu">
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
    </div>

</main>


<div class="overlay" id="dialog-container">
    <div class="popup">
        <p>This will be saved. Continue ?</p>
        <div class="text-right">
            <button class="dialog-btn btn-cancel" id="cancel">Cancel</button>
            <button class="dialog-btn btn-primary" id="confirm">Ok</button>
        </div>
    </div>
</div>


<style>

    footer{

        margin-top: 20px;
        padding-top: 20px;
    }

    #add__new__list{
        top: -38px;
        right: 0px;
    }
    .popup {
        width: 80%;
        padding: 15px;
        left: 0;
        margin-left: 5%;
        border: 1px solid rgb(1,82,73);
        border-radius: 10px;
        color: rgb(1,82,73);
        background: white;
        position: absolute;
        top: 15%;
        box-shadow: 5px 5px 5px #000;
        z-index: 10001;
        font-weight: 700;
        text-align: center;
    }

    .overlay {
        position: fixed;
        width: 100%;
        top: 0;
        left: 0;
        right: 0;
        bottom: 0;
        background: rgba(0,0,0,.85);
        z-index: 10000;
        display :none;
    }

    @media (min-width: 768px) {
        .popup {
            width: 66.66666666%;
            margin-left: 16.666666%;
        }
    }
    @media (min-width: 992px) {
        .popup {
            width: 80%;
            margin-left: 25%;
        }
    }
    @media (min-width: 1200px) {
        .popup {
            width: 33.33333%;
            margin-left: 33.33333%;
        }
    }

    .dialog-btn {
        background-color:#44B78B;
        color: white;
        font-weight: 700;
        border: 1px solid #44B78B;
        border-radius: 10px;
        height: 30px;
        width: 30%;
    }
    .dialog-btn:hover {
        background-color:#015249;
        cursor: pointer;
    }



</style>
<script>
    function showNotification(from, align){
        color = Math.floor((Math.random() * 4) + 1);

        $.notify({
            icon: "pe-7s-gift",
            message: "Welcome to <b>Light Bootstrap Dashboard</b> - a beautiful freebie for every web developer."

        },{
            type: type[color],
            timer: 4000,
            placement: {
                from: from,
                align: align
            }
        });
    }

    document.getElementById("btn-show-dialog").onclick = function(){show_dialog()};
    var overlayme = document.getElementById("dialog-container");

    function show_dialog() {
        /* A function to show the dialog window */
        overlayme.style.display = "block";
    }

    // If confirm btn is clicked , the function confim() is executed
    document.getElementById("confirm").onclick = function(){confirm()};
    function confirm() {
        /* code executed if confirm is clicked */
        overlayme.style.display = "none";
    }

    // If cancel btn is clicked , the function cancel() is executed
    document.getElementById("cancel").onclick = function(){cancel()};
    function cancel() {
        /* code executed if cancel is clicked */
        overlayme.style.display = "none";
    }
</script>
</body>
</html>

