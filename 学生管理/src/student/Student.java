package student;
import java.util.*;
public class Student {
	public StringBuffer data;
	public static int a=5;
  public static void main(String[] args) {
	  Scanner sc=new Scanner(System.in);
	  Student sd=new Student();
	   while(a!=0){
	   System.out.println("0.退出\n"+"1.添加"+'\n'+"2.删除"+'\n'+"3.修改");
	    a=sc.nextInt();
	   if(a==1)sd=add(sd);
	   else if(a==2)sd=remove(sd);
	   else if(a==3)sd=alter(sd);
	   }
   }
public static Student add(Student sd) {
	StringBuffer st=new StringBuffer();
	Scanner sc=new Scanner(System.in);
	System.out.println("请输入学生学号：");
	String ch=sc.nextLine();
	st.append(ch);
	sd.data=st;
	System.out.println("学生学号："+sd.data);
	return sd;
}
public static Student remove(Student sd) {
	StringBuffer st=new StringBuffer(sd.data);
	Scanner sc=new Scanner(System.in);
	int a,b;
	System.out.println("请输入删除起始位置：");
	a=sc.nextInt();
	System.out.println("请输入删除结束位置：");
	b=sc.nextInt();
	st.delete(a,b);
	sd.data=st;
	System.out.println(("删除指定位置："+sd.data));
	return sd;
}
public static Student alter(Student sd) {
	StringBuffer st=new StringBuffer(sd.data);
	Scanner sc=new Scanner(System.in);
	int a,b;
	String ch;
	System.out.println("请输入替换内容：");
	ch=sc.nextLine();
	System.out.println("请输入需替换区间的起始位置：");
	a=sc.nextInt();
	System.out.println("请输入需替换区间的结束位置：");
	b=sc.nextInt();
	st.replace(a,b,ch);
	sd.data=st;
	System.out.println("修改指定位置字符结果："+sd.data);
	return sd;
}
}
