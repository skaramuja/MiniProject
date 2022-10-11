<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Address</title>
</head>
<body>
	<h1>${person.getFirstName()}
		${person.getLastName()}</h1>

	<form action="addAddressServlet" method="post">

		<input type="hidden" name="personId" value="${person.id}"> 
		
		<p> Street: <input type="text" name="street"> </p>

		<p> City: <input type="text"
			name="city"> 

		<select name="state" id="state">
			<option value="Alabama">AL</option>
			<option value="Alaska">AK</option>
			<option value="Arizona">AZ</option>
			<option value="Arkansas">AR</option>
			<option value="American Samoa">AS</option>
			<option value="California">CA</option>
			<option value="Colorado">CO</option>
			<option value="Connecticut">CT</option>
			<option value="Delaware">DE</option>
			<option value="District of Columbia">DC</option>
			<option value="Florida">FL</option>
			<option value="Georgia">GA</option>
			<option value="Guam">GU</option>
			<option value="Hawaii">HI</option>
			<option value="Idaho">ID</option>
			<option value="Illinois">IL</option>
			<option value="Indiana">IN</option>
			<option value="Iowa">IA</option>
			<option value="Kansas">KS</option>
			<option value="Kentucky">KY</option>
			<option value="Maine">ME</option>
			<option value="Maryland">MD</option>
			<option value="Massachusetts">MA</option>
			<option value="Michigan">MI</option>
			<option value="Minnesota">MN</option>
			<option value="Mississippi">MS</option>
			<option value="Missouri">MO</option>
			<option value="Montana">MT</option>
			<option value="Nebraska">NE</option>
			<option value="Nevada">NV</option>
			<option value="New Hampshire">NH</option>
			<option value="New Jersey">NJ</option>
			<option value="New Mexico">NM</option>
			<option value="New York">NY</option>
			<option value="North Carolina">NC</option>
			<option value="North Dakota">ND</option>
			<option value="Northern Mariana Islands">CM</option>
			<option value="Ohio">OH</option>
			<option value="Oklahoma">OK</option>
			<option value="Oregon">OR</option>
			<option value="Pennsylvania">PA</option>
			<option value="Puerto Rico">PR</option>
			<option value="Rhode Island">RI</option>
			<option value="South Carolina">SC</option>
			<option value="South Dakota">SD</option>
			<option value="Tennessee">TN</option>
			<option value="Texas">TX</option>
			<option value="Trust Territories">TT</option>
			<option value="Utah">UT</option>
			<option value="Vermont">VT</option>
			<option value="Virginia">VA</option>
			<option value="Virgin Islands">VI</option>
			<option value="Washington">WA</option>
			<option value="West Virginia">WV</option>
			<option value="Wisconsin">WI</option>
			<option value="Wyoming">WY</option>
			
		</select></p>
		

		<p> Zip Code: <input type="text" name="zipCode"> </p>
		<br> 
		<input type="submit" value="ADD" name="action">
	</form>

</body>
</html>