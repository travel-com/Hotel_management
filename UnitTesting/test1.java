import java.util.List;

import travel.com.bo.Guest;
import travel.com.dao.GuestDao;
import travel.com.dao.impl.GuestDaoOracle;

public class test1 {

	public static void main(String[] args) {
		System.out.println("hello");
		GuestDao dao=new GuestDaoOracle();
		List<Guest>list=dao.getAllBookedByRoomType("acdouble");
System.out.println(list); 
 
	}
}