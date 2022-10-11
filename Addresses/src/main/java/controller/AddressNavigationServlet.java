package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			
		} else if (action.equals("EDIT")) {
			
		} else if (action.equals("ADD")) {
			
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
