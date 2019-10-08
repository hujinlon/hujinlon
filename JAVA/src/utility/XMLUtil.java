package  utility;
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

