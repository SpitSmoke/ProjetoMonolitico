package dev.lobophf.sample;

import dev.lobophf.dao.UserDAO;
import dev.lobophf.domain.TelephoneType;
import dev.lobophf.domain.User;

public class SampleApplication {

  private static User user;
  private static UserDAO dao;

	public static void main(String[] args) throws Exception {
    
    user = new User("Nath", "002", TelephoneType.LANDLINE); 
    dao = new UserDAO(); 
    dao.register(user);

	}
}
