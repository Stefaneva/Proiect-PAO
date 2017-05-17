<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	ArrayList<String>  userDetails=(ArrayList<String>) request.getSession().getAttribute("UserDetails");
	String role=(String) request.getSession().getAttribute("userRole");
	%>
	<h2>Name: <%= userDetails.get(0).toString() %></h2>
	<h2>Email: <%= userDetails.get(1).toString() %></h2>
	<h2>Address: <%= userDetails.get(2).toString() %></h2>
	<h2>Phone: <%= userDetails.get(3).toString() %></h2>
	<h2>Role: <%= role %></h2>
	<h3><a href="index.jsp">Back</a></h3>
</body>
</html>