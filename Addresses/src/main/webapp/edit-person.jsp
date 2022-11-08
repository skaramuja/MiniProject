<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Person</title>

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

<!-- User modifies a country and editCountryServlet gets called at submission-->
	<h1>Edit Person</h1>
	<form action="editPersonServlet" method="post" onsubmit="return checkForm(this);">
	
		<input type="hidden" name="id" value="${person.id}"> 
		<p>First Name: <input type="text" name="firstName" value="${person.firstName}"></p>
		<p>Last Name: <input type="text" name="lastName" value="${person.lastName}"></p>
		<p>Birthday: <input type="date" name="birthday" value="${person.birthDate}"></p>
		<br>
		<p><input type="submit" value="SAVE"></p>
	</form>

</body>
</html>