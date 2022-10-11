package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Address;
import model.Person;

/**
 * Servlet implementation class AddAddressServlet
 */
@WebServlet("/addAddressServlet")
public class AddAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAddressServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Create an instance of helpers
		PersonHelper personHelper = new PersonHelper();
		AddressHelper addressHelper = new AddressHelper();
		
		Integer personId = Integer.parseInt(request.getParameter("personId"));
		Person person = personHelper.searchForPersonById(personId);
				
		// Collect parameters from user
		String street = request.getParameter("street");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zipCode = request.getParameter("zipCode");
		
		// Insert person into the database
		Address address = new Address(street, city, state, zipCode);
		addressHelper.insertAddress(address);
		
		// Get the current list of addresses for the person and update it
		List<Address> currentAddress = person.getListOfAddresses();
		currentAddress.add(address);
		person.setListOfAddresses(currentAddress);
					
		// Update the person in the database (also updates relationship table)
		personHelper.updatePerson(person);
		
		// Set the proper attributes on the request to display the person
		request.setAttribute("person", person);
		request.setAttribute("allAddresses", currentAddress);
		
		// User is redirected
		getServletContext().getRequestDispatcher("/viewdetails-person.jsp").forward(request, response);
		
	}

}
