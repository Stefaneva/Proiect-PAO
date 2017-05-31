<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="AddProductServlet" method="post">
		<br>Product Name:<input type="text" name="productName">
		<br>Stoc: <input type ="text" name="stoc">
		<br>Price: <input type="text" name="price">
		<br>Category: <input type="text" name="category">
		<br>Description: <input type="text" name="description">
		<br>Nr. Stoc: <input type="text" name="nrStoc">	
		<br><input type="submit" value="Add Product">
	</form>
</body>
</html>