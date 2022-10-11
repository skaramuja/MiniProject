package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Address;
import model.Person;

/**
 * Servlet implementation class EditAddressServlet
 */
@WebServlet("/editAddressServlet")
public class EditAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditAddressServlet() {
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
		
		String addressIdString = request.getParameter("addressId");
		String prsonIdString = request.getParameter("personId");
		
		Integer addressId = Integer.parseInt(addressIdString);
		Address address = addressHelper.searchForAddressById(addressId);
		
		// Get parameters from the user
		String street = request.getParameter("street");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zipCode = request.getParameter("zipCode");
		
		// Update the address
		address.setStreet(street);
		address.setCity(city);
		address.setState(state);
		address.setZipCode(zipCode);
		
		// Update the database with new information
		addressHelper.updateAddress(address);
		
		Integer personId = Integer.parseInt(prsonIdString);
		Person person = personHelper.searchForPersonById(personId);
		
		// Pass the person and updated list of addresses in the request
		request.setAttribute("person", person);
		request.setAttribute("allAddresses", person.getListOfAddresses());
		
		// Redirect the user to servlet
		getServletContext().getRequestDispatcher("/viewdetails-person.jsp").forward(request, response);

	}

}
