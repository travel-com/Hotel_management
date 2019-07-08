package travel.com.dao;

import travel.com.bo.User;

public interface LoginDao {
   public abstract User getUserByIdPassword(String username,String password );
}
