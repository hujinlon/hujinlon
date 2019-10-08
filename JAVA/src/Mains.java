import tv.*;
import factory.*;
import utility.*;
public class Mains{
	public static void main(String args[]) {
		Tv tv;
		TVFactory factory;
		factory=(TVFactory)XMLUtil.getBean();
		tv=factory.produceTv();
		tv.play();
		}
}


