package student;
import java.util.*;
public class Student {
	public StringBuffer data;
	public static int a=5;
  public static void main(String[] args) {
	  Scanner sc=new Scanner(System.in);
	  Student sd=new Student();
	   while(a!=0){
	   System.out.println("0.�˳�\n"+"1.���"+'\n'+"2.ɾ��"+'\n'+"3.�޸�");
	    a=sc.nextInt();
	   if(a==1)sd=add(sd);
	   else if(a==2)sd=remove(sd);
	   else if(a==3)sd=alter(sd);
	   }
   }
public static Student add(Student sd) {
	StringBuffer st=new StringBuffer();
	Scanner sc=new Scanner(System.in);
	System.out.println("������ѧ��ѧ�ţ�");
	String ch=sc.nextLine();
	st.append(ch);
	sd.data=st;
	System.out.println("ѧ��ѧ�ţ�"+sd.data);
	return sd;
}
public static Student remove(Student sd) {
	StringBuffer st=new StringBuffer(sd.data);
	st.delete(1,5);
	sd.data=st;
	System.out.println(("ɾ��ָ��λ�ã�"+sd.data));
	return sd;
}
public static Student alter(Student sd) {
	StringBuffer st=new StringBuffer(sd.data);
	st.setCharAt(1,'2');
	sd.data=st;
	System.out.println("�޸�ָ��λ���ַ������"+sd.data);
	return sd;
}
}
