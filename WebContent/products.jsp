<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="styles/products.css" type="text/css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div id = "products-container">
	<h2>Products </h2><br>
	<table>
		<tr>
  			<th> Produs </th>
  			<th> Pret </th>
  			<th> Descriere </th>
  			<th> Cumpara </th>
  		</tr>
  		<c:forEach items="${productList}" var="product">
		    <tr>
		      <td><c:out value="${product.denumire}" /></td>
		      <td><c:out value="${product.pret}" /></td>
		      <td><a href = "detaliiProdus.jsp">Vezi detalii</a></td>
		      <td><input type="submit" value="Buy Product"></td>
		    </tr>
  		</c:forEach>
	</table>
	</div>
</body>
</html>