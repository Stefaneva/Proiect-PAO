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
	<jsp:include page="searchProducts.jsp" />
	<jsp:include page = "categories.jsp" />
	<div id = "products-container">
	<h2>Products </h2><br>
	<table>
  		<tr>
  			<th> Produs </th>
  			<th> Pret </th>
  			<th> Descriere </th>
  			<c:choose>
		      	<c:when test="${userRole!='admin'}">
		      		<th>Cumpara</th>
		      	</c:when>
		      	<c:otherwise>
		      		<th>Editare</th>
		      	</c:otherwise>
		    </c:choose>
  		</tr>
  		<c:forEach items="${productList}" var="product" >
		    <tr>
		      <td><c:out value="${product.denumire}" /></td>
		      <td><c:out value="${product.pret}" /></td>
		      <td><a href = "${pageContext.request.contextPath}/ProductDetailsServlet?produs=${product.idProd}">Vezi detalii</a></td>

		      <td>
		      <c:if test="${not empty UserID}">
		      	<c:choose>
		      		 	<c:when test="${userRole!='admin'}">
		      				<a href= "${pageContext.request.contextPath}/CartServlet?cumpara=${product.idProd}">Cumpara</a>
		      			</c:when>
		      			<c:otherwise>
		      				<a href= "${pageContext.request.contextPath}/EditProductServlet?produsId=${product.idProd}">Editare</a>
		      			</c:otherwise>
		      	</c:choose>
		      </c:if>
		      	<c:if test="${empty UserID}">
		      		<a href= "index.jsp?message=Please+log+in+to+account+to+buy+products!">Cumpara</a>
		      	</c:if>
		      </td>

		    </tr>
  		</c:forEach>
	</table>
	<h2><a href = "index.jsp">Home</a></h2>
</body>
</html>