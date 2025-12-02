<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>DISCOUNT</title>
</head>
<body>
<form action="/display-discount" method="post">
    <text aria-placeholder="Product Description"></text>
    <input name="Price" placeholder="List Price">
    <input name="Discount" placeholder="Discount Percent">
    <button>Calculate Discount</button>
    <h2>Amount: ${Discount_Amount}</h2>
    <h2>Price: ${Discount_Price}</h2>
</form>
</body>
</html>