<%--
  Created by IntelliJ IDEA.
  User: moringaschool
  Date: 10/31/19
  Time: 11:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.4.2/sweetalert2.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.4.2/sweetalert2.min.css" />
</head>
<body>
<button id="button">Show (Bootstrap)</button>
<hr />
<button id="button1">Show (w/o bootstrap)</button>
</body>

</html>

<script>
    $(function() {
        $('#button').click(() => {
            swal({
                     title: 'Submit email to run ajax request',
                     input: 'email',
                     showCancelButton: true,
                     confirmButtonText: 'Submit',
                     showLoaderOnConfirm: true,
                     buttonsStyling: false,
                     confirmButtonClass: 'btn btn-primary btn-lg',
                     cancelButtonClass: 'btn btn-lg',
                     preConfirm: function(email) {
            return new Promise(function(resolve, reject) {
                setTimeout(function() {
                    if (email === 'taken@example.com') {
                        reject('This email is already taken.')
                    } else {
                        resolve()
                    }
                }, 2000)
            })
        },
        allowOutsideClick: false
    }).then(function(email) {
            swal({
                type: 'success',
                title: 'Ajax request finished!',
                html: 'Submitted email: ' + email
            })
        }).catch(swal.noop)
    });

        $('#button1').click(() => {
            swal({
                     title: 'Submit email to run ajax request',
                     input: 'email',
                     showCancelButton: true,
                     confirmButtonText: 'Submit',
                     showLoaderOnConfirm: true,
                     preConfirm: function(email) {
            return new Promise(function(resolve, reject) {
                setTimeout(function() {
                    if (email === 'taken@example.com') {
                        reject('This email is already taken.')
                    } else {
                        resolve()
                    }
                }, 2000)
            })
        },
        allowOutsideClick: false
    }).then(function(email) {
            swal({
                type: 'success',
                title: 'Ajax request finished!',
                html: 'Submitted email: ' + email
            })
        }).catch(swal.noop)
    });
    });
</script>
</body>
</html>
