<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Address</title>
<script>

  function checkForm(form) {
    // validation fails if the input is blank
    if(form.street.value == "") {
      alert("Error: Please eneter a street");
      form.street.focus();
      return false;
    }
    
    if(form.city.value == "") {
        alert("Error: Please eneter a city");
        form.city.focus();
        return false;
      }
    
    if(form.zipCode.value == "") {
        alert("Error: Please eneter a zip code!");
        form.zipCode.focus();
        return false;
      }
    

	if (form.zipCode.value.length != 5) {
			alert("Error: Please enter a 5 digit zip code.");
			form.zipCode.focus();
			return false;
		} else if (isNaN(form.zipCode.value)) {
			alert("Error: Please enter valid zip code (digit 0-9).");
			form.zipCode.focus();
			return false;
		}

		//validation was successful
		return true;
	}
</script>

</head>
<body>

<h1>Edit Address</h1>

<form action="editAddressServlet" method="post" onsubmit="return checkForm(this);">

		<input type="hidden" name="personId" value="${person.id}"> 
		<input type="hidden" name="addressId" value="${address.id}"> 
		
		<p>Street: <input type="text" name="street" value="${address.street}"></p>
		
		<p>City: <input type="text" name="city" value="${address.city}">
		
		<select name="state" id="state">
			<option value="${address.state}" selected>${address.state}</option>
			<option value="Alabama">Alabama</option>
			<option value="Alaska">Alaska</option>
			<option value="Arizona">Arizona</option>
			<option value="Arkansas">Arkansas</option>
			<option value="American Samoa">American Samoa</option>
			<option value="California">California</option>
			<option value="Colorado">Colorado</option>
			<option value="Connecticut">Connecticut</option>
			<option value="Delaware">Delaware</option>
			<option value="District of Columbia">District of Columbia</option>
			<option value="Florida">Florida</option>
			<option value="Georgia">Georgia</option>
			<option value="Guam">Guam</option>
			<option value="Hawaii">Hawaii</option>
			<option value="Idaho">Idaho</option>
			<option value="Illinois">Illinois</option>
			<option value="Indiana">Indiana</option>
			<option value="Iowa">Iowa</option>
			<option value="Kansas">Kansas</option>
			<option value="Kentucky">Kentucky</option>
			<option value="Maine">Maine</option>
			<option value="Maryland">Maryland</option>
			<option value="Massachusetts">Massachusetts</option>
			<option value="Michigan">Michigan</option>
			<option value="Minnesota">Minnesota</option>
			<option value="Mississippi">Mississippi</option>
			<option value="Missouri">Missouri</option>
			<option value="Montana">Montana</option>
			<option value="Nebraska">Nebraska</option>
			<option value="Nevada">Nevada</option>
			<option value="New Hampshire">New Hampshire</option>
			<option value="New Jersey">New Jersey</option>
			<option value="New Mexico">New Mexico</option>
			<option value="New York">New York</option>
			<option value="North Carolina">North Carolina</option>
			<option value="North Dakota">North Dakota</option>
			<option value="Northern Mariana Islands">Northern Mariana Islands</option>
			<option value="Ohio">Ohio</option>
			<option value="Oklahoma">Oklahoma</option>
			<option value="Oregon">Oregon</option>
			<option value="Pennsylvania">Pennsylvania</option>
			<option value="Puerto Rico">Puerto Rico</option>
			<option value="Rhode Island">Rhode Island</option>
			<option value="South Carolina">South Carolina</option>
			<option value="South Dakota">South Dakota</option>
			<option value="Tennessee">Tennessee</option>
			<option value="Texas">Texas</option>
			<option value="Trust Territories">Trust Territories</option>
			<option value="Utah">Utah</option>
			<option value="Vermont">Vermont</option>
			<option value="Virginia">Virginia</option>
			<option value="Virgin Islands">Virgin Islands</option>
			<option value="Washington">Washington</option>
			<option value="West Virginia">West Virginia</option>
			<option value="Wisconsin">Wisconsin</option>
			<option value="Wyoming">Wyoming</option>
			
		</select></p>
		
		
		<p>Zip Code: <input type="text" name="zipCode" value="${address.zipCode}"></p>
		<br>
		<p><input type="submit" value="SAVE"></p>
	</form>

</body>
</html>