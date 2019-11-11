package xiaoshou;
import java.util.Random;

public class Input implements Runnable {

	private Storage st;
	private String r;
	private int a;
	Input(Storage st){
		this.st=st;
		}
	public void run(){
	while(true){
		Random a=new Random();
		r=String.valueOf(a);
		st.put(r);
	}
}
}