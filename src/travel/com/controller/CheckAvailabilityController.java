package travel.com.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import travel.com.bo.Guest;
import travel.com.dao.GuestDao;
import travel.com.dao.Factory.DaoFactory;

/**
 * Servlet implementation class CheckAvailabilityController
 */
public class CheckAvailabilityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
        public CheckAvailabilityController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
String RoomType= request.getParameter("RoomType");
String arrivalDate= request.getParameter("arrival");
String departureDate= request.getParameter("departure");
		
		GuestDao dao=DaoFactory.getGuestDaoOracle();
		
		List<Guest> listOfGuest=dao.getAllBookedByRoomType(RoomType);
		
		
		
		request.setAttribute("listOfGuest",listOfGuest);
		System.out.println(listOfGuest);
		request.getRequestDispatcher("checkAvailabilityView.jsp").forward(request, response);
	}

}
