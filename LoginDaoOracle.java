package travel.com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import travel.com.dao.LoginDao;
import travel.com.utill.db.SisDbConnectionUtil;
import travel.com.bo.User;

public class LoginDaoOracle implements LoginDao {

	public User getUserByIdPassword(String username, String password) {
		// TODO Auto-generated method stub
		
		User user  = null;
        System.out.println(username);
        System.out.println(password);
        System.out.println("hello");
		Connection con  = null;
		PreparedStatement pstmt  = null;
		ResultSet rs  = null;
		try{
			con  = SisDbConnectionUtil.getConnection();
			String sql="select * from user1 where username=? and password=?";
			pstmt  = con.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			rs  = pstmt.executeQuery();
			if(rs.next()){
				long id  = rs.getLong("id");
				String name  = rs.getString("name");
				//String userId  = rs.getString("username");
				String mobile  = rs.getString("mobile");
				String email  = rs.getString("email");
				user = new User();
				user.setId(id);
				user.setName(name);
				user.setUsername(username);
				user.setMobile(mobile);
				user.setEmail(email);
				user.setPassword(password);
					
			}
		}catch(Exception e){
				 e.printStackTrace();
			
		}finally{
			try{
				SisDbConnectionUtil.closeConnection(con);	
			}catch(Exception e){
				 e.printStackTrace();
			}	
		}

		return user;
	}

}
