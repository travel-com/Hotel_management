package travel.com.controller;

import java.io.IOException;

import javax.mail.PasswordAuthentication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import travel.com.bo.User;
import travel.com.utill.db.SisDbConnectionUtil;

/**
 * Servlet implementation class ForgotPasswordController
 */
public class ForgotPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotPasswordController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email= request.getParameter("email");
		String userName=request.getParameter("username");
		
		Connection con  = null;
		PreparedStatement pstmt  = null;
		ResultSet rs  = null;
		User user=null;
		try{
			con  = SisDbConnectionUtil.getConnection();
			String sql="select * from user1 where username=?";
			pstmt  = con.prepareStatement(sql);
			pstmt.setString(1, userName);
			//pstmt.setString(2, password);
			rs  = pstmt.executeQuery();
			if(rs.next()){
				long id  = rs.getLong("id");
				String name  = rs.getString("name");
				//String userId  = rs.getString("username");
				String mobile  = rs.getString("mobile");
				//String email  = rs.getString("email");
				user = new User();
				user.setId(id);
				user.setName(name);
				user.setUsername(userName);
				user.setMobile(mobile);
				user.setEmail(email);
				//user.setPassword(password);
					
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
		}catch(Exception e){
				 e.printStackTrace();
			
		}finally{
			try{
				SisDbConnectionUtil.closeConnection(con);	
			}catch(Exception e){
				 e.printStackTrace();
			}	
		}

				
				String otp = ""+ (int)(Math.random()*10000);
				
				//adding otp to http session
				HttpSession session=null;
			   	 if(otp!=null){
			   		 session=request.getSession();
			   		 System.out.println(session);
			       	 session.setAttribute("otp", otp);
			       	 System.out.println(" session created");
			   	 }
			   	 
			   	 
			   	 
			   	/* User user = (User)request.getAttribute("user_details");
			   	 System.out.println("got this user from session "+user);
			   	 if(user!=null){
			   	 String name=user.getName();
			   	 String userName=user.getUsername();
			   	 System.out.println("name of user "+name);
			   	 System.out.println("user name of user "+userName);
			   	 }*/
			   	 
			   			 
			   			 
			   			 
			   			 
				boolean isOtpSent=false;
		
			final String username = "sharvaniramineni@gmail.com";
			final String password ="9948722331";
			
			System.out.println("read password");
			 
			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");
		
			System.out.println("Authentication start................");
		
			Session email_session = Session.getInstance(props,
					  new javax.mail.Authenticator() {
									protected PasswordAuthentication getPasswordAuthentication() {
										return new PasswordAuthentication(username, password);
									}
					  });
			
			System.out.println("Authentication successfuly................");
		
		
		try {
		
		Message message = new MimeMessage(email_session);
		message.setFrom(new InternetAddress(username));
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("deepthiprathyusha41@gmail.com"));
		message.setSubject("happy Programming by sis "+ new Date());
		message.setText("success is sure \n" + "OTP : " + otp);
		
			System.out.println("message sending................");
		Transport.send(message);
		isOtpSent =true;
		System.out.println("message sent ................");
		
		} catch (MessagingException e) {
		
		System.err.print("ERROR "+e.getMessage());
		e.printStackTrace();
		}	
		
		if(isOtpSent){
		
			
		//System.out.println("enter otp");
		//String enterOtp =scan.nextLine();
		//System.out.println(otp.equals(enterOtp) ?" otp matched " :" otp not matched");
		}
		
		request.getRequestDispatcher("verify_otp.jsp").forward(request, response);

	}

}
