package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Person;

/**
 * Servlet implementation class AddPersonServlet
 */
@WebServlet("/addPersonServlet")
public class AddPersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPersonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Create an instance of PersonHelper
		PersonHelper personHelper = new PersonHelper();

		// Collect parameters from user
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");

		// Insert person into the database
		Person person = new Person(firstName, lastName);
		personHelper.insertPerson(person);

		// User is redirected
		getServletContext().getRequestDispatcher("/viewAllContactsServlet").forward(request, response);
	}

}
