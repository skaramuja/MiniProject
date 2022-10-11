<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Person</title>
</head>
<body>

<!-- User modifies a country and editCountryServlet gets called at submission-->
	<h1>Edit Person</h1>
	<form action="editPersonServlet" method="post">
	
		<input type="hidden" name="id" value="${person.id}"> 
		<p>First Name: <input type="text" name="firstName" value="${person.firstName}"></p>
		<p>Last Name: <input type="text" name="lastName" value="${person.lastName}"></p>
		<br>
		<p><input type="submit" value="SAVE"></p>
	</form>

</body>
</html>