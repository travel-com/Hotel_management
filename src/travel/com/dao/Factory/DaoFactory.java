package travel.com.dao.Factory;

import travel.com.dao.GuestDao;
import travel.com.dao.impl.GuestDaoOracle;

public class DaoFactory {
 private static GuestDao dao=null;
 public static GuestDao getGuestDaoOracle(){
	 if(dao==null){
		 dao=new GuestDaoOracle();
		 
	 }
	 return dao;
 }
 
}
