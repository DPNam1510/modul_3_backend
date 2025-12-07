<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Product List</title>
    <c:import url="../layout/library.jsp"/>

</head>
<body>
<div class="container mt-4">

    <div class="d-flex justify-content-between align-items-center mb-3">
        <h2>Product List</h2>
        <a href="<c:url value="/products?action=add"/>" class="btn btn-primary">
            <i class="fa-solid fa-plus"></i> Add Product
        </a>
    </div>

    <table class="table table-bordered table-hover text-center align-middle">
        <thead class="table-dark">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Action</th>
        </tr>
        </thead>

        <c:forEach var="p" items="${productList}">
            <tr>
                <td>${p.id}</td>
                <td>${p.name}</td>
                <td>${p.price}</td>
                <td>
                    <a class="btn btn-warning btn-sm"
                       href="<c:url value="/products?action=update&id=${p.id}"/>">
                        <i class="fa-solid fa-pen"></i> Update
                    </a>

                    <form action="<c:url value="/products?action=delete"/>" method="post" style="display:inline-block;"
                          onsubmit="return confirm('Do you want delete?');">
                        <input type="hidden" name="id" value="${p.id}">
                        <button class="btn btn-danger btn-sm">Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>

</div>

</body>
</html>