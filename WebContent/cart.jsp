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
	<h2>Products </h2><br>
	<table>
		<tr>
  			<th> Produs </th>
  			<th> Pret </th>
  			<th> Descriere </th>
  			<th> Cantitate </th>
  		</tr>
  		<c:forEach items="${cos}" var="product" >
		    <tr>
		      <td><c:out value="${product.key.denumire}" />
		      <td><c:out value="${product.key.pret}" /></td>
		      <td><a href = "${pageContext.request.contextPath}/ProductDetailsServlet?produs=${product.key.idProd}">Vezi detalii</a></td>
		      <td><c:out value="${product.value}"></c:out></td>
		    </tr>
  		</c:forEach>
	</table>
</body>
</html>