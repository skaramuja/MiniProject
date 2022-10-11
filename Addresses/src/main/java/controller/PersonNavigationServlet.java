package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Person;

/**
 * Servlet implementation class PersonNavigationServlet
 */
@WebServlet("/personNavigationServlet")
public class PersonNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonNavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Create an instance of helpers
		PersonHelper personHelper = new PersonHelper();
		AddressHelper addressHelper = new AddressHelper();

		String action = request.getParameter("action");
		String idString = request.getParameter("id");
		
		String path = "/viewAllContactsServlet";

		if (action.equals("DELETE")) {
			try {
				// Getting the ID parameter of the person to delete
				Integer tempId = Integer.parseInt(idString);

				// Querying the database to find person using id
				Person person = personHelper.searchForPersonById(tempId);

				// Delete user selected row in table
				personHelper.deletePerson(person);

			// Handle exception if no person is selected to delete
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select a person");
			}
			
		} else if (action.equals("EDIT")) {
			try {
				// Getting the ID parameter of the person to edit
				Integer id = Integer.parseInt(idString);
				
				// Querying the database to find person using id
				Person person = personHelper.searchForPersonById(id);
				
				// User redirected to edit-person.jsp with an attribute person that
				request.setAttribute("person", person);
				path = "/edit-person.jsp";
				
				// Handle exception if no person was selected to edit
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select a person");
			}

		} else if (action.equals("DETAILS")) {
			try {
				// Getting the ID parameter of the person to edit
				Integer id = Integer.parseInt(idString);
				
				// Querying the database to find person using id
				Person person = personHelper.searchForPersonById(id);
				
				// User redirected with an attribute person and all addresses
				request.setAttribute("person", person);
				request.setAttribute("allAddresses", person.getListOfAddresses());
				path = "/viewdetails-person.jsp";
			}
			// Handle exception if no person was selected
			catch (NumberFormatException e) {
				System.out.println("Forgot to select a person");
			}

		// Redirect to add-person page to add a new person
		} else if (action.equals("ADD")) {
			path = "/add-person.jsp";
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}
}
