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
  			<th> Nume: </th>
  			<th> Parola: </th>
  			<th> E-mail: </th>
  			<th> Adresa: </th>
  			<th> Phone: </th>
  			<th> Tip user: </th>
  			<th> Promoveaza user: </th>
  			<th> Blocheaza/Activeaza user: </th>
  		</tr>
  		<c:forEach items="${userList}" var="user" >
  		 <tr>
		      <td><c:out value="${user.name}" /></td>
		      <td><c:out value="${user.password}" /></td>
		      <td><c:out value="${user.email}" /></td>
		      <td><c:out value="${user.address}" /></td>
		      <td><c:out value="${user.phone}" /></td>
		      <td><c:out value="${user.userRole}" /></td>
		      <td><a href= "${pageContext.request.contextPath}/PromoteServlet?id=${user.id}">Promoveaza</a><td>
		      <td><a href= "${pageContext.request.contextPath}/PromoteServlet?blocked=${user.id},${user.password}">Blocheaza/Activeaza</a><td>
		</c:forEach>
  	</table>
</body>
</html>