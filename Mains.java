<?xml version="1.0"?>
<config>
 <className>HaierTVFactory</classNmme>
</config>
import java.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import java.io.*;
public class XMLUtil{
	public static Object getBean() {
		try {
			DocumentBuilderFactory dFactory =DocumentBuilderFactory.newInstance();
			DocumentBuilder builder=dFactory.newDocumentBuilder();
			Document doc=builder.parse(new File("configTv.xml"));
			NodList n1=doc.getElementsByTagName("className");
			Node classNode=n1.item(0).getFirstChild();
			String cName=classNode.getNodeValue();
			Class c=Class.forName(cName);
			Object obj=c.newInstance();
			reutrn obj;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
public class Mains{
	public static void main(String args[]) {
		Tv tv;
		TVFactory factory;
		factory=(TVFactory)XMLUtil.getBean();
		tv=factory.produceTv();
		tv.play();
		}
}
public abstract class Tv{
	public abstract void play();
}
public class HaierTv extends Tv{
	public void play() {
		System.out.println("This is HaierTv.");
	}
}
public class HisenseTv extends Tv{
	public void play() {
		System.out.println("This is HisenseTv.");
	}
}
public interface TVFactory{
	public TV produceTV();
}
public class HaierTVFactory implement TVFactory{
	public TV produceTV() {
		return new HaierTV();
	}
}
public class HisenseTVFactory implement TVFactory{
	public TV produceTV() {
		return new HisenseTV();
	}
}