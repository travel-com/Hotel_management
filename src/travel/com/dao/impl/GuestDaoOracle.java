package travel.com.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import travel.com.bo.Guest;
import travel.com.dao.GuestDao;
import travel.com.utill.db.SisDbConnectionUtil;

public class GuestDaoOracle implements GuestDao{
	 
	public List<Guest> getAllBookedUser(){
		 List<Guest> guestList  = new ArrayList<Guest>();
			//db code fill list`

			Connection con  = null;
			Statement stmt  = null;
			ResultSet rs  = null;
			try{
				con  = SisDbConnectionUtil.getConnection();
				stmt  = con.createStatement();
				String sql="select * from Guest";
				rs  = stmt.executeQuery(sql);
				while(rs.next()){
					long id  = rs.getLong("id");
					String name  = rs.getString("name");
					String roomNo  = rs.getString("roomno");
					String mobile  = rs.getString("mobile");
					String idProof  = rs.getString("idProof");
					String email  = rs.getString("email");
					Guest guest = new Guest();
					guest.setId(id);
					guest.setName(name);
					guest.setRoomNo(roomNo);
					guest.setMobile(mobile);
					guest.setEmail(email);
					guest.setIdProof(idProof);
					guestList.add(guest);	
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

			return guestList;
	 }
	 //return all guest list via name
	public  List<Guest> getAllBookedUserByName(String Searchname){
		List<Guest> guestList  = new ArrayList<Guest>();
		//db code fill list`
System.out.println(Searchname);
		Connection con  = null;
		Statement stmt  = null;
		ResultSet rs  = null;
		try{
			con  = SisDbConnectionUtil.getConnection();
			stmt  = con.createStatement();
			String sql="select * from Guest where lower(name) like lower('"+Searchname+"')";
			rs  = stmt.executeQuery(sql);
			while(rs.next()){
				long id  = rs.getLong("id");
				String name  = rs.getString("name");
				String roomNo  = rs.getString("roomno");
				String mobile  = rs.getString("mobile");
				String idProof  = rs.getString("idProof");
				String email  = rs.getString("email");
				Guest guest = new Guest();
				guest.setId(id);
				guest.setName(name);
				guest.setRoomNo(roomNo);
				guest.setMobile(mobile);
				guest.setEmail(email);
				guest.setIdProof(idProof);
				guestList.add(guest);	
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

		return guestList;
	}
	 
	 
	 public  List<Guest> getAllBookedByRoomType(String typeofRoom){
			 List<Guest> guestList  = new ArrayList<Guest>();
				//db code fill list
System.out.println(typeofRoom);
				Connection con  = null;
				Statement stmt  = null;
				ResultSet rs  = null;
				try{
					con  = SisDbConnectionUtil.getConnection();
					stmt  = con.createStatement();
					String sql="select * from Guest where roomno=(select roomno from room where lower( ROOMTYPE)=lower( '"+typeofRoom+"'))";
					rs  = stmt.executeQuery(sql);
				System.out.println(rs);
					while(rs.next()){
						long id  = rs.getLong("id");
						System.out.println("id="+id);
						String name  = rs.getString("name");
						String roomNo  = rs.getString("roomno");
						String mobile  = rs.getString("mobile");
						String idProof  = rs.getString("idProof");
						String email  = rs.getString("email");
						java.util.Date arrivalDate=rs.getDate("ArrivalDate");
						java.util.Date departureDate=rs.getDate("departureDate");
						Guest guest = new Guest();
						guest.setId(id);
						guest.setName(name);
						guest.setRoomNo(roomNo);
						guest.setMobile(mobile);
						guest.setEmail(email);
						guest.setIdProof(idProof);
						guestList.add(guest);	
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

				return guestList;
		 
	 }
		
}
	 
