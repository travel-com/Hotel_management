package travel.com.controller;


import java.io.IOException;






import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import javax.servlet.http.HttpSession;

import travel.com.bo.User;
import travel.com.dao.GuestDao;
import travel.com.dao.LoginDao;
import travel.com.dao.Factory.DaoFactory;
/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password= request.getParameter("pass");
		
		LoginDao  dao = DaoFactory.getLoginDaoOracle();
		User user=dao.getUserByIdPassword(username,password);
		
		
		if(user!=null){
			HttpSession  session =  request.getSession();
			session.setAttribute("user_details",user);
			response.sendRedirect("home.jsp");
			System.out.println(user +" user logged in ");
			System.out.println("");
		}else{
			 
			
		}
		
		/*request.setAttribute("user1", user);
		request.getRequestDispatcher("user_home.jsp").forward(request, response);
		*/
	}

}
