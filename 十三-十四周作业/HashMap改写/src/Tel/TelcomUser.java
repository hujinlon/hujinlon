package Tel;
import java.text.*;
import java.util.*;
import xml.ReadXMLUitilcar;
import company.*;
import name.*;
public class TelcomUser {
     private String PhoneNumber;
     private String callTo;
     private ArrayList  list;
     private HashMap singleRecord;
     public TelcomUser(String phoneNumber) {
    	 this.PhoneNumber =phoneNumber;
    	 this.list=new ArrayList();
     }
//模拟通话记录的生成
public void generateCommunicateRcords() {
    	 int recordNum=new Random().nextInt(10);
    	 for(int i=0;i<=recordNum;i++) {
    		 //随机生成第i条通话记录
    		 //开始时间，当前时间之前的某个随机时间
    		 long timeStart=System.currentTimeMillis()-new Random().nextInt(36000000);
    		 //结束时间开始后的十分钟内随机的一个时间，至少一分钟
    		 long timeEnd=timeStart + 60000+new Random().nextInt(600000);
    		 //被叫号码
    		 this.callTo=getCallToPhoneNumber(); 
    		 //插入通话记录
    		 this.singleRecord =new HashMap();
    		 this.singleRecord.put("主叫", this.PhoneNumber);
    		 this.singleRecord.put("开始时间",new Date(timeStart));
    		 this.singleRecord.put("结束时间",new Date(timeEnd));
    		 this.singleRecord.put("被叫号码",this.callTo);
    		 this.singleRecord.put("计费",this.accountFee(timeStart, timeEnd));
    		 this.list.add(this.singleRecord);
    	 }	 
     }
     //随机生成被叫号码（后四位随机）并返回
     private String getCallToPhoneNumber(){
    	 return "1834844"+String.valueOf( new Random().nextInt(10))+
    			 String.valueOf( new Random().nextInt(10))+
    			 String.valueOf(new Random().nextInt(10))+
    			 String.valueOf(new Random().nextInt(10));
    			 
     }
//模拟计费办法，以字符串的形式返回保留4位小数的计费结果
private String accountFee(long timeStart, long timeEnd) { 	
	Dianxin  ch = null;
	Company company;
	ch=(Dianxin)ReadXMLUitilcar.getBean();
	company=ch.productCompany();
    		 //每分钟收费*元
    		 double feePerMinute=company.fei();
    		 //通话分钟去尾
    		 int minutes=Math.round((timeEnd-timeStart)/60000);
    		 double feeTotal=feePerMinute * minutes;
    		 return String.format("%a.4f", feeTotal);
    	 }
//打印通话记录
public void printDetails() { 
	    Iterator it=this.list.iterator();
    	 //循环分割记录内的每一项并输出
    	 while(it.hasNext()){    
    		 System.out.println("--------通话记录分数线---------------");
    		 this.singleRecord = ((HashMap)it.next());
    		 Set keySet = this.singleRecord.keySet();
    		 Iterator itKey = keySet.iterator();
    		 while(itKey.hasNext()) {
    			 Object key = itKey.next();
    			 Object value = this.singleRecord.get(key);
    			 System.out.println(key + ":" + value);
    		 }
    	 }
    }
a

//遍历方式二：使用entrySet遍历
 /*public void printDetails() { 
	    Iterator it=this.list.iterator();
    	 while(it.hasNext()){    
    		 System.out.println("--------通话记录分数线---------------");
    		 this.singleRecord = ((HashMap)it.next());
    		 Set entrySet = this.singleRecord.entrySet();
    		 Iterator itEntry = entrySet.iterator();
    		 while(itEntry.hasNext()) {
    		    Map.Entry entry = (Map.Entry)itEntry.next();
    			 Object key = entry.getKey();
    			 Object value = entry.getValue();
    			 System.out.println(key + ":" + value);
    		 }
    	 }
    }*/
 
}
