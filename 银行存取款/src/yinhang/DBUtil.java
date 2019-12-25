package yinhang;

import java.io.*;
import java.util.HashMap;

public class DBUtil {
	public static final String filepath="D:\\JAVAÊµ¼ù\\inter.txt";
	private static DBUtil instance = null;
	private HashMap<String,User> users = new HashMap<String,User>();
	private  User user;
	private DBUtil() throws Exception{
		users=read(filepath);
	}
	public static HashMap<String,User>  read(String filepath) throws IOException{
   		FileInputStream fis=new FileInputStream(filepath);
   		InputStreamReader ir=new InputStreamReader(fis);
   		BufferedReader br=new BufferedReader(ir);
   		HashMap<String,User> list=new HashMap<String,User>();
   		String str=null;
   		while((str=br.readLine())!=null){
   			String[] strs=str.split(",");
   			User stu=new User();
   			stu.setCardId(strs[0]);
   			stu.setCardPwd(strs[1]);
   			stu.setCall(strs[2]);
   			stu.setUserName(strs[3]);
   			stu.setAccount(Integer.parseInt(strs[4]));
   			list.put(strs[0],stu);
   		}
   		br.close();
   		return list;
   		
   	}
    	   
       public static void writer(String filepath,HashMap<String,User> users) throws IOException{
   		FileOutputStream fos=new FileOutputStream(filepath,true);
   		OutputStreamWriter osw=new OutputStreamWriter(fos);
   		PrintWriter pw=new PrintWriter(osw,true);
   		for(int i=0;i<users.size();i++){
   			User stu=(User)users.get(i);
   			pw.println(stu.getCardId()+","+stu.getCardPwd()+","+stu.getCall()+","
   			+stu.getUserName()+","+stu.getAccount());	
   		}
   		pw.close();
   		
   	}
  public static DBUtil getInstance() throws Exception {
	  if(instance == null) {
	  synchronized(DBUtil.class) {
		  if(instance == null) {
			  instance= new DBUtil();
			  return instance;
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