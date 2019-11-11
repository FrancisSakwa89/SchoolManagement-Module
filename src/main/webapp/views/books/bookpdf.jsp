<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.List" %>
<%@ page import="com.systechInterns.library.Book" %>
<%@include file="/includes/navbar.jsp"%>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Sample Excel Sheet</title>
</head>
<body>
<br><br><br><br><br><br>
<h2>Export to Excel Example</h2>
<table class="table table-bordered" style="margin-left: 15%;width:70%">
    <tr>
        <th scope="col">Book Title</th>
        <th scope="col">Publisher</th>
        <th scope="col">Isbn No</th>
    </tr>
    <%
        List<Book> books  = (List<Book>)request.getAttribute("books");
        if (books != null) {
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "inline; filename="+ "bookreport.xls");
        }
        if (books != null) {
            for(Book e: books){
        %>
        <tr>
            <td><%=e.getTitle()%></td>
            <td><%=e.getPublisher().getPublisherName()+ e.getPublisher().getPublisherCity()+e.getPublisher().getPublisherCountry()%></td>
            <td><%=e.getIsbn()%></td>
        </tr>
        <%
            }
        }
    %>
</table>
</body>
</html>