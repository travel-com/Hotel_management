package travel.com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class VerifyOtpController
 */
public class VerifyOtpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerifyOtpController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String otp = request.getParameter("otp");
		
		HttpSession session=request.getSession();
		System.out.println(session);
		String otpFromSession = (String)session.getAttribute("otp");
		
		if(otp.equals(otpFromSession)){
			System.out.println("otp matched");
			
			request.getRequestDispatcher("reset_password.jsp").forward(request, response);
		}else{
			System.out.println("otp mismatch.....");
		}
	}

}
