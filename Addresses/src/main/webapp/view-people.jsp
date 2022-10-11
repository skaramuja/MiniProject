<%@ page language="java" contentType="text/html; 
charset=UTF-8" pageEncoding="UTF-8"%>
 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>View Contacts</title>
</head>

<body>
	<h1> All Contacts </h1>
	<form method="post" action="personNavigationServlet">

		<table>
			<c:forEach items="${requestScope.allPeople}" var="person">
				<tr>
					<!-- ID is not displayed to the user but is passed to the  servlet as a parameter-->
					<td><input type="radio" name="id" value="${person.id}"></td>
					<td>${person.firstName}</td>
					<td>${person.lastName}</td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<!-- user can view details, edit, delete, or add -->
		<input type="submit" value="ADD" name="action"> <input
			type="submit" value="EDIT" name="action"> <input
			type="submit" value="DELETE" name="action"> <input
			type="submit" value="DETAILS" name="action">
	</form>

</body>
</html>