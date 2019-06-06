package travel.com.dao;

import java.util.List;

import travel.com.bo.Guest;

public interface GuestDao {
 public abstract List<Guest> getAllBookedUser();
 public abstract List<Guest> getAllBookedUserByName(String name);
 public abstract List<Guest> getAllBookedByRoomType(String typeofRoom);
 
	
 
}
