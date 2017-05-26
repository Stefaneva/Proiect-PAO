<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Profile</title>
</head>
<body>
	<form action="EditProfileServlet" method="post">
		<br>Password: <input type ="password" name="password">
		<br>E-mail: <input type="text" name="email">
		<br>Phone: <input type="text" name="phone">
		<br><input type="submit" value="Edit">
	</form>
</body>
</html>