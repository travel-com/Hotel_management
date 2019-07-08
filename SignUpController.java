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
 * Servlet implementation class SignUpController
 */
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Session creation
   	 String name=req.getParameter("name");
   	 String mobile=req.getParameter("mobile");
   	 String email=req.getParameter("email");
   	 String userName=req.getParameter("username");
   	 String password=req.getParameter("password");
   	 
   	 User user=new User();
   	 user.setEmail(email);
   	 user.setName(name);
   	 user.setMobile(mobile);
   	 user.setUsername(userName);
   	 user.setPassword(password);
   	 
   	 
   /*	HttpSession session=null;
   	 if(user!=null){
   		 session=req.getSession();
       	 session.setAttribute("user", user);
       	 System.out.println("new user created");
   	 }*/
   	 
   	 
   	
   	 
   	 Connection con=null;
   	 PreparedStatement pstmt=null;
   	int r=0;
   	    try {
			con = SisDbConnectionUtil.getConnection();
			System.out.println(con);
			String sql="insert into user1 values(userseq.nextval,?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, userName);
			pstmt.setString(3, password);
			pstmt.setString(4, email);
			pstmt.setString(5, mobile);
			 r = pstmt.executeUpdate();
			if(r==1){
				System.out.println("inserted into db succesfully");
			}else{
				System.out.println("not inserted into db");
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
   	 
   	 
     
		req.getRequestDispatcher("index.jsp").forward(req, res);
	
   	 
   	
	}

}
