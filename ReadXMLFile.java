// принцип использования sax парсера


import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
 
public class ReadXMLFile {
 
   public static void main(String argv[]) {
	   String URL = "c:\\butterfly.xml";	   
    try {
 
	SAXParserFactory factory = SAXParserFactory.newInstance();
	SAXParser saxParser = factory.newSAXParser();
 
	DefaultHandler handler = new DefaultHandler() { //
 
	boolean bfname = false;
	boolean blname = false;
	boolean bnname = false;
	boolean bsalary = false;
 
	public void startElement(String uri, String localName,String qName, 
                Attributes attributes) throws SAXException {
 
		System.out.println("Start Element :" + qName);
 
		if (qName.equalsIgnoreCase("TYPE")) {
			bfname = true;
		}
 
		if (qName.equalsIgnoreCase("LOCATION")) {
			blname = true;
		}
 
		if (qName.equalsIgnoreCase("SIZE")) {
			bnname = true;
		}
 
		if (qName.equalsIgnoreCase("LIFEPERIOD")) {
			bsalary = true;
		}
 
	}
 
	public void endElement(String uri, String localName,
		String qName) throws SAXException {
 
		System.out.println("End Element :" + qName);
 
	}
 
	public void characters(char ch[], int start, int length) throws SAXException { // start - значение смещения в массиве с
 
		if (bfname) {
			System.out.println("type : " + new String(ch, start, length));
			bfname = false;
		}
 
		if (blname) {
			System.out.println("location : " + new String(ch, start, length));
			blname = false;
		}
 
		if (bnname) {
			System.out.println("size : " + new String(ch, start, length));
			bnname = false;
		}
 
		if (bsalary) {
			System.out.println("life period : " + new String(ch, start, length));
			bsalary = false;
		}
 
	}
 
     };
     System.out.println(handler.getClass() + "it is the class of handler ");
       saxParser.parse(URL, handler); 
 
     } catch (Exception e) {
       e.printStackTrace();
     }
 
   }
 
}