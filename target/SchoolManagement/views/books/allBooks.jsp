<%--
  Created by IntelliJ IDEA.
  User: moringaschool
  Date: 10/12/19
  Time: 7:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<body>
    <script type="text/javascript" language="javascript">
        $(document).ready(function () {
            var res = [];
            $.ajax({
                type: "GET",
                datatype:"jsonp",
                contentType: "application/json;charset=utf-8",
                processData: true,
                url: "http://localhost:8080/SchoolManagement/api/books/getAvailableBooks",
                success: function (data) {
                    res.push(data);
                    array(res);
                }
            });
            function array(arr) {
                console.log(arr);
            }
        });

        let xhr = new XMLHttpRequest;
        xhr.open('GET', 'your-url', true);
        xhr.onload = function()
        {
            if (this.status === 200)
            {
                let data = JSON.parse(this.responseText).Table,
                    tbodyHtml = '';

                data.map(function(d) {
                    tbodyHtml =+ `
      	<tr>
        	<td>${d.ParentCategoryId}</td>
        	<td>${d.ParentCategoryName}</td>
        	<td>${d.IsActive}</td>
        </tr>
      `;
                });

                document.querySelector('#dataTable tbody').innerHTML = tbodyHtml;
            }
        }
        xhr.send();


</script>

    <table id="dataTable">
        <tbody>

        </tbody>
    </table>



</body>
</html>
