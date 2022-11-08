<%@ page language="java" contentType="text/html; 
charset=UTF-8" pageEncoding="UTF-8"%>
 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Person</title>
<script>

  function checkForm(form) {
    // validation fails if the input is blank
    if(form.firstName.value == "") {
      alert("Error: Please enter a first name");
      form.firstName.focus();
      return false;
    } 
    
 	// regular expression to match only alphanumeric characters and spaces
    var re = /^[\w ]+$/;

    // validation fails if the input doesn't match our regular expression
    if(!re.test(form.firstName.value)) {
      alert("Error: First name contains invalid characters");
      form.firstName.focus();
      return false;
    }
    
    if(form.lastName.value == "") {
        alert("Error: Please enter a last name");
        form.lastName.focus();
        return false;
      }
    
     if(!re.test(form.lastName.value)) {
        alert("Error: Last name contains invalid characters");
        form.lastName.focus();
        return false;
      }
    
    if(form.birthday.value == "") {
        alert("Error: Please enter a birthday");
        form.birthday.focus();
        return false;
      }
    
	//validation was successful
	return true;
}
</script>
</head>
<body>

	<h1>Add Person</h1>
	<form action="addPersonServlet" method="post" onsubmit="return checkForm(this);">
		<p>
			First Name: <input type="text" name="firstName">
		</p>
		
		<p>
			Last Name: <input type="text" name="lastName">
		</p>
		
		<p>
			Birthday: <input type="date" id="birthday" name="birthday">
		</p>

		<input type="submit" value="SUBMIT">
	</form>
	<br />

	<!-- user selects to view all contacts -->
	<a href="viewAllContactsServlet">View Contacts</a>

</body>
</html>