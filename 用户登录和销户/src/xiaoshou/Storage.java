package xiaoshou;
import java.util.Random;

public class Storage {
   private  String [] cells=new String[2000];
   private int inPos,outPos;
   private int count;
   public synchronized void put(String r){
	   try{
		   while(count==cells.length){
		   this.wait();
	   }
	   cells[inPos]=r;
	   System.out.println("cells["+inPos+"]用户登录中---"+cells[inPos]);
	   inPos++;
	   if(inPos==cells.length)
		   inPos=0;
	   count++;
	   this.notify();
}catch(Exception e){
	e.printStackTrace();
}
}
public synchronized void get(){
	try{
		while(count==0){
			this.wait();
		}
		String data=cells[outPos];
		System.out.println("用户cells["+outPos+"]销户"+data);
		cells[outPos]=;
		outPos++;
		if(outPos==cells.length)
			outPos=0;
		count--;
		this.notify();
	}catch(Exception e){
		e.printStackTrace();
	}
}
}