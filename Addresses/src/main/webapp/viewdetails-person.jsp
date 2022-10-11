<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Details</title>
</head>
<body>

<form action="addressNavigationServlet" method="post">

		<input type = "hidden" name = "personId" value = "${person.id}">
		
		<h1>${person.getFirstName()} ${person.getLastName()}</h1>
		<br /> 

		First Name: ${person.firstName}
		<br /> 
	
		Last Name: ${person.lastName}
		<br /> 
		
		Birthday: ${person.birthDate}
		<br /> 
		<br />
		Addresses:
		<br />  
		
		<table>
			<c:forEach items="${requestScope.allAddresses}" var="address">
				<tr>
					<td><input type="radio" name="addressId" value="${address.id}"></td>
					<td>${address.getStreet()}</td>
					<td>${address.getCity()}</td>
					<td>${address.getState()}</td>
					<td>${address.getZipCode()}</td>
				</tr>
			</c:forEach>
		</table>
		<br /> 
		
		 <p>Add, Edit or Delete Address:</p>
		<input type="submit" value="ADD" name="action">
		<input type="submit" value="EDIT" name="action"> 
		<input type="submit" value="DELETE" name="action"> 
		
	</form>
	<br>
	<a href="viewAllContactsServlet">Back To All Contacts</a>

</body>
</html>