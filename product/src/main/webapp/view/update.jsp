<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Update Product</title>
    <c:import url="../layout/library.jsp"/>
</head>

<body class="bg-light">

<div class="container mt-5">
    <div class="card shadow p-4" style="max-width: 600px; margin: auto;">
        <h3 class="text-center mb-4">Update Product</h3>

        <form action="<c:url value="/products?action=update"/>" method="post">
            <input type="hidden" name="id" value="${product.id}">

            <div class="mb-3">
                <label class="form-label">Product Name</label>
                <label>
                    <input type="text" name="name" class="form-control"
                           value="${product.name}" required>
                </label>
            </div>

            <div class="mb-3">
                <label class="form-label">Price</label>
                <label>
                    <input type="number" name="price" class="form-control"
                           value="${product.price}" required>
                </label>
            </div>

            <div class="text-center">
                <button class="btn btn-warning px-4">Update</button>
                <a href="<c:url value="/products"/>" class="btn btn-secondary px-4">Cancel</a>
            </div>

        </form>
    </div>
</div>

</body>
</html>
