<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="SignUpServlet" method="post">
		<br>User Name:<input type="text" name="userName">
		<br>Password: <input type ="password" name="password">
		<br>E-Mail: <input type="text" name="email">
		<br>Address: <input type="text" name="address">
		<br>Phone: <input type="text" name="phone">
		<br>Role: <input type="text" name="role">
		<br><input type="submit" value="Sign Up">
	</form>
</body>
</html>