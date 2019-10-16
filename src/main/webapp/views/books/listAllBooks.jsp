<%--
  Created by IntelliJ IDEA.
  User: moringaschool
  Date: 10/5/19
  Time: 12:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/includes/body.jsp"%>
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
<body>
<br><br>
<%--<table class="table table-bordered" style="margin-left: 15%;width:70%">--%>
    <%--<thead>--%>
    <%--<tr>--%>
        <%--<th scope="col">Book Id</th>--%>
        <%--<th scope="col">Availability</th>--%>
        <%--<th scope="col">ISBN no.</th>--%>
        <%--<th scope="col">Publisher Id</th>--%>
        <%--&lt;%&ndash;<th scope="col"></th>&ndash;%&gt;--%>
        <%--<th scope="col">Title</th>--%>

<div class="container-fluid section">
    <h3 class="text-center main-title">
        <i class="glyphicon glyphicon-user"></i>&nbsp;&nbsp;AVAILABLE BOOKS (GRID)
    </h3>

    <form class="form-inline" role="form" id="contribution-form" action="books">
        <div class="col-md-4">
            <label for="dateFrom" class="control-label">
                Date From:
            </label> <input type="text" readonly="readonly" name="dateFrom"
                            class="form-control datepicker" id="dateFrom"
                            placeholder="Date From">
        </div>
        <div class="col-md-4">
            <label for="dateTo" class="control-label">
                Date To:
            </label> <input type="text" readonly="readonly" name="dateTo"
                            class="form-control datepicker" id="dateTo"
                            placeholder="Date To">
        </div>
        <div class="col-md-4">
            <label for="unitNumber" class="control-label">Unit Number:</label>
            <input
                    type="text" name="unitNumber" class="form-control"
                    id="unitNumber"
                    placeholder="Unit Number">
        </div>
        <div class="col-md-4">
            <label class="control-label"></label><br/>
            <button class="btn btn-primary">
                SHOW HISTORY
            </button>
        </div>
    </form>
</div>

<div class="modal fade" id="modal-view-contribution" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabelViewContributions" aria-hidden="true">
    <form role="form" id="form-view-contributions">
        <div class="modal-dialog large-modal">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title" id="myModalLabelViewContributions">
                        <i class="glyphicon glyphicon-picture"></i>&nbsp;&nbsp;AVAILABLE BOOKS
                    </h4>
                </div>
                <div class="modal-body">
                    <table class="table table-responsive table-striped table-bordered" id="select-results">
                    </table>
                </div>
            </div>
        </div>
    </form>
</div>

<script type="text/javascript">

    function format_no(yourNumber) {
        if (typeof    yourNumber != 'undefined') {
            //Seperates the components of the number
            var n = yourNumber.toString().split(".");
            //Comma-fies the first part
            n[0] = n[0].replace(/\B(?=(\d{3})+(?!\d))/g, ",");
            //Combines the two sections
            return n.join(".");
        }
        return yourNumber;
    }

    $(document).ready(function () {

        $('.datepicker').datetimepicker(
            $('#dateFrom').datetimepicker({
                format: 'mm-dd-yyyy',
                startView: 'month',
                minView: 'month',
                autoclose: true
            })
                .on('changeDate', function (e) {
                    $(this).datetimepicker('hide');
                    // Revalidate the date field
                    $('#contribution-form').bootstrapValidator('revalidateField', 'dateTo');
                }),
            $('#dateTo')
                .datetimepicker({
                    format: 'mm-dd-yyyy',
                    startView: 'month',
                    minView: 'month',
                    autoclose: true
                })
                .on('changeDate', function (e) {
                    $(this).datetimepicker('hide');
                    // Revalidate the date field
                    $('#contribution-form').bootstrapValidator('revalidateField', 'dateTo');
                }));


        $('#contribution-form').bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                dateFrom: {
                    validators: {
                        notEmpty: {
                            message: 'Please select the start date'
                        }
                    }
                },
                dateTo: {
                    validators: {
                        notEmpty: {
                            message: 'Please select the ending date'
                        }
                    }
                }
            }
        })
            .on('success.form.bv', function (e) {

                start_wait();

                $.ajax({
                    url: $('#base_url').val() + 'member',
                    type: 'post',
                    data:
                        {
                            ACTION: 'CH_GRID',
                            dateFrom: $('#dateFrom').val(),
                            dateTo: $('#dateTo').val()
                        },
                    dataType: 'json',
                    success: function (json) {
                        console.log(json);
                        html = "<tr><th>DATE</th><th>MONTH</th><th>YEAR</th><th>EE</th><th>ER</th><th>AVC</th><th>AVCER</th><th>SALARY</th><th>TYPE</th><th>TOTAL</th><th>REGISTERED/<br>UNREGISTERED</th></tr>";
                        var eeSum = 0;
                        var erSum = 0;
                        var avcSum = 0;
                        var avcErSum = 0;
                        var salSum = 0;
                        var totalSum = 0;
                        if (json.success) {

                            json = $.parseJSON(json.data);
                            console.log(json);
                            $.each(json, function (key, value) {
                                if (key == 'rows') {
                                    for (var i = 0; i < json.rows.length; i++) {
                                        var row = json.rows[i];
                                        html = html + "<tr><td>" + row['datePaid'] + "</td><td>" + row['month'] + "</td><td>" + row['year'] + "</td><td>" + format_no(row['ee']) + "</td><td>" + format_no(row['er']) +
                                            "</td><td>" + format_no(row['avc']) + "</td><td>" + format_no(row['avcer']) + "</td><td>" + format_no(row['salary']) + "</td><td>" + row['type'] +
                                            "</td><td>" + format_no(row['total']) + "</td><td>" + row['status'] + "</td></tr>";

                                        eeSum += row['ee'];
                                        erSum += row['er'];
                                        salSum += row['salary'];
                                        totalSum += row['total'];
                                        avcSum += row['avc'];
                                        avcErSum += row['avcer'];

                                    }
                                    empty = "<tr><th></th><th></th><th></th><th>TOTAL EE</th><th>TOTAL ER</th><th>TOTAL AVC</th><th>TOTAL AVCER</th><th>TOTAL SALARY</th><th></th><th>GRAND TOTAL</th><th></th></tr>";
                                    totals = "<tr><td></td><td></td><td></td><td>" + format_no(precisionRound(eeSum, 1)) + "</td><td>" + format_no(precisionRound(erSum, 1)) + "</td><td>" + format_no(avcSum) + "</td><td>" + format_no(avcErSum) + "</td><td>" + format_no(salSum) +
                                        "</td><td></td><td>" + format_no(precisionRound(totalSum, 1)) + "</td><td></td></tr>";
                                    console.log("EE SUM IS: " + format_no(precisionRound(eeSum, 1)));
                                    html = html + empty + totals;
                                    stop_wait();
                                }
                            });
                        }
                        $('#select-results').html(html);
                        stop_wait();
                        $('#modal-view-contribution').modal('show');
                    }
                });
            });
    });

    function precisionRound(number, precision) {
        var factor = Math.pow(10, precision);
        return Math.round(number * factor) / factor;
    }


</script>


</body>
</html>
