package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Person;

/**
 * Servlet implementation class EditPersonServlet
 */
@WebServlet("/editPersonServlet")
public class EditPersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPersonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Create an instance of PersonHelper
		PersonHelper personHelper = new PersonHelper();
		
		Integer personId = Integer.parseInt(request.getParameter("personId"));
		Person person = personHelper.searchForPersonById(personId);
		
		// Collect parameters from user
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String idString = request.getParameter("id");
		
		// Querying the database to find person using id
		Integer id = Integer.parseInt(idString);
		Person newPerson = personHelper.searchForPersonById(id);
		
		// Update person with user input
		newPerson.setFirstName(firstName);
		newPerson.setLastName(lastName);
		
		// Update the database with new information
		personHelper.updatePerson(newPerson);
		
		// Redirect the user to servlet 
		getServletContext().getRequestDispatcher("/viewAllContactsServlet").forward(request, response);
	}

}
