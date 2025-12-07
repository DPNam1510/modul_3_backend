<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dpnbh
  Date: 03/12/2025
  Time: 3:51 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add</title>
    <c:import url="../layout/library.jsp"/>
</head>
<body class="bg-light">
<div class="container mt-5">
    <div class="card shadow p-4" style="max-width: 600px; margin: auto;">
        <h3 class="text-center mb-4">Add New Product</h3>

        <form action="<c:url value="/products?action=add"/>" method="post">

            <div class="mb-3">
                <label class="form-label">Product Name</label>
                <label>
                    <input type="text" name="name" class="form-control" required>
                </label>
            </div>

            <div class="mb-3">
                <label class="form-label">Price</label>
                <label>
                    <input type="number" name="price" class="form-control" required>
                </label>
            </div>

            <div class="text-center">
                <button class="btn btn-primary px-4">Save</button>
                <a href="<c:url value="/products"/>" class="btn btn-secondary px-4">Cancel</a>
            </div>

        </form>
    </div>
</div>
</body>
</html>
