package Tel;
import java.util.*;
import xml.ReadXMLUitilcar;
import company.*;
import name.*;
public class TelcomUser {
     private String PhoneNumber;
     private String callTo;
     private StringBuffer communicationRecords;
     public TelcomUser(String phoneNumber) {
    	 this.PhoneNumber =phoneNumber;
    	 this.communicationRecords=new StringBuffer();
     }
//ģ��ͨ����¼������
public void generateCommunicateRcords() {
    	 int recordNum=new Random().nextInt(10);
    	 for(int i=0;i<=recordNum;i++) {
    		 //������ɵ�i��ͨ����¼
    		 //��ʼʱ�䣬��ǰʱ��֮ǰ��ĳ�����ʱ��
    		 long timeStart=System.currentTimeMillis()-new Random().nextInt(36000000);
    		 //����ʱ�俪ʼ���ʮ�����������һ��ʱ�䣬����һ����
    		 long timeEnd=timeStart + 60000+new Random().nextInt(600000);
    		 //���к���
    		 this.callTo=getCallToPhoneNumber(); 
    		 //����ͨ����¼
    		 this.communicationRecords.append(this.PhoneNumber+
    				 ","+timeStart+
    				 ","+timeEnd+
    				 ","+this.callTo+
    				 ";");
    	 }
     }
     //������ɱ��к��루����λ�����������
     private String getCallToPhoneNumber() {
    	 return "1834844"+String.valueOf( new Random().nextInt(10))+
    			 String.valueOf( new Random().nextInt(10))+
    			 String.valueOf(new Random().nextInt(10))+
    			 String.valueOf(new Random().nextInt(10));
    			 
     }
//ģ��ƷѰ취�����ַ�������ʽ���ر���4λС���ļƷѽ��
private String accountFee(long timeStart, long timeEnd) { 	
	Dianxin  ch = null;
	Company company;
	ch=(Dianxin)ReadXMLUitilcar.getBean();
	company=ch.productCompany();
    		 //ÿ�����շ�*Ԫ
    		 double feePerMinute=company.fei();
    		 //ͨ������ȥβ
    		 int minutes=Math.round((timeEnd-timeStart)/60000);
    		 double feeTotal=feePerMinute * minutes;
    		 return String.format("%.4f", feeTotal);
    	 }
//��ӡͨ����¼
public void printDetails() { 
	    
    	 //��ȡȫ��ͨ����¼
    	 String allRecords=this.communicationRecords.toString();
    	 //�ָ�ͨ����¼
    	 String[] recordArray=allRecords.split(";");
    	 //ѭ���ָ��¼�ڵ�ÿһ����
    	 for(int i=0;i<recordArray.length;i++) {    
    		 System.out.println("--------ͨ����¼������---------------");
    		 String [] recordField = recordArray[i].split(",");
    		 System.out.println("����"+recordField[0]);
    		 System.out.println("����"+recordField[3]);
    		 System.out.println("ͨ����ʼʱ��"+new Date(Long.parseLong(recordField[1])));
    		 System.out.println("ͨ������ʱ��"+new Date(Long.parseLong(recordField[2])));
    		 System.out.println("�Ʒѣ�"
    				 +accountFee(Long.parseLong(recordField[1]),Long.parseLong(recordField[2]))
    						 +"   Ԫ��");
    	 }
     }
}
