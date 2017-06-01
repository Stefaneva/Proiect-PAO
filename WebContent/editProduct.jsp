<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Product</title>
</head>
<body>
	<form action="EditProductServlet" method="post">
		<br>Pret: <input type="text" name="pret">
		<br>Stoc: <input type="text" name="stoc">
		<br>Descriere: <input type="text" name="descriere">
		<br>Nr. stoc: <input type="text" name="nrStoc">
		<br><input type="submit" value="Edit">
	</form>
</body>
</html>