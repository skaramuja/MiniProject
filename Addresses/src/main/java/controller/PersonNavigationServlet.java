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

		} else if (action.equals("DETAILS")) {

		// Redirect to add-person page to add a new person
		} else if (action.equals("ADD")) {
			path = "/add-person.jsp";
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}
}
