<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Welcome!</title>
</head>
<body>
	<form id="loginForm" action="" method="post">
		<fieldset>
			<legend>Welcome!</legend>
			<table cellspacing="0">
				<tr>
					<th><label for="note">Username:</label></th>
					<td><input id="username" name="username" /></td>
				</tr>
				<tr>
					<th><label for="password">Date</label></th>
					<td><input type="password" id="password" name="password" /></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" value="Login" /></td>
				</tr>
			</table>
		</fieldset>
	</form>
</body>
</html>