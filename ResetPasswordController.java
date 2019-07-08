package travel.com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import travel.com.bo.User;
import travel.com.utill.db.SisDbConnectionUtil;

/**
 * Servlet implementation class ResetPasswordController
 */
public class ResetPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResetPasswordController() {
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
		
		String password1=request.getParameter("passowrd1");
		//String password2=request.getParameter("passowrd2");
		
		boolean isPasswordUpdated= false;
		
		
		HttpSession session = request.getSession();
		System.out.println(session);
		
		 User user=(User)session.getAttribute("user");
		  long id=user.getId();
		System.out.println(id);
		
		//long id=17L;
		
		
		
		Connection con=null;
	   	 PreparedStatement pstmt=null;
	   	 int r=0;

		//if(password1.equals(password2)){
			try {
					con = SisDbConnectionUtil.getConnection();
					System.out.println(con);
					String sql="update user1 set password=? where id=?";
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1, password1);
					pstmt.setLong(2, id);
					 r = pstmt.executeUpdate();
					 System.out.println("after update r value is "+r);
					if(r==1){
						isPasswordUpdated=true;
						System.out.println("updated into db succesfully");
					}else{
						System.out.println("not updated");
					}
				} catch (Exception e) {
					// TODO: handle exception
				}finally{
					try{
						SisDbConnectionUtil.closeConnection(con);	
					}catch(Exception e){
						 e.printStackTrace();
					}	
				}
		   	 
		   	 if(isPasswordUpdated){
		   		 request.getRequestDispatcher("index.jsp").forward(request, response);
		   	 }
		//}
	}

}
