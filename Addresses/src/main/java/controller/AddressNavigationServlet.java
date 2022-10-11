package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Address;
import model.Person;

/**
 * Servlet implementation class AddressNavigationServlet
 */
@WebServlet("/addressNavigationServlet")
public class AddressNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddressNavigationServlet() {
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
		
		String action = request.getParameter("action");
		String idString = request.getParameter("id");
		
		String path = "/personNavigationServlet";
		
		if (action.equals("DELETE")) { 
			try {
				// Getting the ID parameter of the person 
				Integer personId = Integer.parseInt(request.getParameter("personId"));
				
				// Getting the ID parameter of the address
				Integer addressId = Integer.parseInt(request.getParameter("addressId"));
				
				// Querying the database to find person using id
				Person person = personHelper.searchForPersonById(personId);
				
				// Querying the database to find address using id
				Address address = addressHelper.searchForAddressById(addressId);
				
				// Get the current list of addresses for the person and update it
				List<Address> currentAddresses = person.getListOfAddresses();
				
				// Create new list of addresses
				ArrayList<Address> newAddresses = new ArrayList<Address>();
				
				// Removes address from listOfAddresses
				for (int i = 0; i < currentAddresses.size(); i++) {
					Address newAddress = currentAddresses.get(i);
					if (newAddress.getId() != addressId) {
						newAddresses.add(newAddress);
					}
				}
				person.setListOfAddresses(newAddresses);
				
				// Update the person in the database
				personHelper.updatePerson(person);
				
				// Delete user selected row in table
				addressHelper.deleteAddress(address);
				
				// Set the proper attributes on the request to display the country
				request.setAttribute("person", person);
				request.setAttribute("allAddresses", newAddresses);
				
				// Redirect the user to view the country details.
				path = "/viewdetails-person.jsp";
				
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select a address");
			}
			
		} else if (action.equals("EDIT")) {
			
		} else if (action.equals("ADD")) {
			// Getting the ID parameter of the person 
			Integer personId = Integer.parseInt(request.getParameter("personId"));
			
			// Querying the database to find address using id
			Person person = personHelper.searchForPersonById(personId);
			request.setAttribute("person", person);
			path = "/add-address.jsp";
			
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
