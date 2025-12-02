<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>DPN</title>
    <c:import url="../layout/library.jsp"/>
</head>
<body>

    <c:import url="../layout/css.jsp"/>
<h1>CUSTOMER LIST</h1>
<table class="table table-bordered align-middle">
    <tr>
        <th>Name</th>
        <th>Phone</th>
        <th>Address</th>
        <th>Image</th>
    </tr>
    <c:forEach var="Customer" items="${customerList}" varStatus="status">
        <tr>
            <td>${Customer.name}</td>
            <td>${Customer.phone}</td>
            <td>${Customer.address}</td>
            <td><img src="${Customer.image}" alt="Avatar"></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>