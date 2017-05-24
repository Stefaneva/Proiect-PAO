<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Products: </h2><br>
	<table>
  		<c:forEach items="${productList}" var="product">
		    <tr>
		      <td>Produs <c:out value="${product.denumire}" /></td>
		      <td>Pret <c:out value="${product.pret}" /></td>
		      <td>Descriere <c:out value="${product.descriere}" /></td>
		    </tr>
  		</c:forEach>
	</table>
	
</body>
</html>