package controller;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewAllContactsServlet
 */
@WebServlet("/viewAllContactsServlet")
public class ViewAllContactsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllContactsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	// Handles request to view the list of contacts because no post request was sent
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Create an instance of people helper
		PersonHelper personHelper = new PersonHelper();
		
		// Passes a list of people to index
		request.setAttribute("allPeople", personHelper.showAllPeople());
		String path = "/view-people.jsp";
		
		// Redirect to index page if no people exist in the database
		if (personHelper.showAllPeople().isEmpty()) {
			path = "/view-people.jsp";
		}
		
		// Redirected to index with an attribute called allpeople that contains all people in the database
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
