<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<br><div id = "it"><a href = "${pageContext.request.contextPath}/CategoryServlet?category=it"> IT </a></div><br>
	<div id = "telefoane/tablete"><a href = "${pageContext.request.contextPath}/CategoryServlet?category=telefoane/tablete"> Telefoane/Tablete </a></div><br>
	<div id = "tv/audio"><a href = "${pageContext.request.contextPath}/CategoryServlet?category=tv/audio"> TV/Audio </a></div><br>
</body>
</html>