package yinhang;

import java.util.HashMap;

public class DBUtil {
	private static DBUtil instance = null;
	private HashMap<String,User> users = new HashMap<String,User>();
	
	private DBUtil(){
		
		User u1 = new User();
		u1.setCardId("1111111111");
		u1.setCardPwd("111111");
		u1.setUserName("张一");
		u1.setCall("11111111111");
		u1.setAccount(1000);
		users.put(u1.getCardId(), u1);
		
		User u2 = new User();
		u2.setCardId("2222222222");
		u2.setCardPwd("222222");
		u2.setUserName("张二");
		u2.setCall("22222222222");
		u2.setAccount(1000);
		users.put(u2.getCardId(), u2);
		
		User u3 = new User();
		u3.setCardId("3333333333");
		u3.setCardPwd("333333");
		u3.setUserName("张二");
		u3.setCall("33333333333");
		u3.setAccount(3000);
		users.put(u3.getCardId(), u3);
	}
  public static DBUtil getInstance() {
	  if(instance == null) {
	  synchronized(DBUtil.class) {
		  if(instance == null) {
			  instance= new DBUtil();
		  }  
	  }
  }
  return instance;
}
  
  public User getUser(String cardId) {
	  User user = (User)users.get(cardId);
	  return user;
  }
  public HashMap<String,User> getUsers(){
	  return users;
  }
}