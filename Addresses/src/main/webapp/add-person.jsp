<%@ page language="java" contentType="text/html; 
charset=UTF-8" pageEncoding="UTF-8"%>
 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Person</title>
</head>
<body>

	<h1>Add Person</h1>
	<form action="addPersonServlet" method="post">
		<p>
			First Name: <input type="text" name="firstName" required>
		</p>
		
		<p>
			Last Name: <input type="text" name="lastName" required>
		</p>
		
		<p>
			Birthday: <input type="date" id="birthday" name="birthday" required>
		</p>

		<input type="submit" value="SUBMIT">
	</form>
	<br />

	<!-- user selects to view all contacts -->
	<a href="viewAllContactsServlet">View Contacts</a>

</body>
</html>