package travel.com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import travel.com.bo.Guest;
import travel.com.dao.GuestDao;
import travel.com.dao.Factory.DaoFactory;

/**
 * Servlet implementation class SearchByNameController
 */
public class SearchByNameController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       public SearchByNameController() {
        super();
   
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchName= request.getParameter("searchName");
		
		GuestDao dao=DaoFactory.getGuestDaoOracle();
		
		List<Guest> listOfGuest=dao.getAllBookedUserByName(searchName);
		request.setAttribute("listOfGuest",listOfGuest);
		System.out.println(listOfGuest);
		request.getRequestDispatcher("searchByNameView.jsp").forward(request, response);
	}

}
