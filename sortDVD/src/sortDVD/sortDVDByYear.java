package sortDVD;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.Text;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class sortDVDByYear {
	 static HashMap<String, Integer> yearCount = new HashMap<String, Integer>();
	 int count;
	//create XMLInputFactory
	 public void read(String  filepath) {
	 try {
	  FileInputStream fileInputStream = new  FileInputStream(filepath);
	       XMLInputFactory factory = XMLInputFactory.newInstance();
	       XMLStreamReader xmlStreamReader = 
	           factory.createXMLStreamReader(fileInputStream);  //XML file is passed as a parameter to FileReader
	  while (xmlStreamReader.hasNext()) {
	   readDVDList(xmlStreamReader);
	  }
	  xmlStreamReader.close();
	  } catch  (XMLStreamException e) {
	       e.printStackTrace(); 
	  } catch  (FileNotFoundException e) {
	       e.printStackTrace(); 
	  }
	 }

	 private void  readDVDList(XMLStreamReader reader) throws XMLStreamException {
	 int eventCode =  reader.next();  //iterate through the contents of our XML file
	 //next() returns an event code indicates which part of the document has been read
	 switch (eventCode) {
	  case XMLStreamReader.START_ELEMENT:
	       String key = reader.getLocalName();
	       if (key.equals("DVD")) {
	            readDVD(reader);
	       }
	   break;
	  }
	 }
	 

	 
	 private void readDVD(XMLStreamReader reader) throws XMLStreamException {
		 String name = "";
		 String value = "";
		 
		 int nAttributes =  reader.getAttributeCount();
		 String avalue =  reader.getAttributeValue(0);
		 
		 while (reader.hasNext()) {
		  int eventCode = reader.next();
		       switch (eventCode) {
		       case XMLStreamReader.START_ELEMENT:
		            name =  reader.getLocalName(); //retrieve the element's name
		            break;
		       case XMLStreamReader.END_ELEMENT:
		            name =  reader.getLocalName();
		            if (name.equals("DVD")) {
		            	return;  
		            }
		            break;
		       case XMLStreamReader.CHARACTERS:
		    	   	value =  reader.getText();
		            if(name.equals("release_year")&&value!=null) {
//		            	System.out.println(name + value);
		            	if(yearCount.containsKey(value)) {		
		            			count = yearCount.get(value);
		            			yearCount.put(value, count+1);
		            	}
		            	else {
		            		count = 0;
		            		yearCount.put(value, count+1);
		            		
		            	}
		            }   
		            break;
		       }
		 }
		 return ;
		 }
	 
	 public static void  main(String[] args) {
		 sortDVDByYear dvdReader =  new sortDVDByYear();
		 dvdReader.read("dvd.xml");
		 
		 Object firstKey = yearCount.keySet().toArray()[0];
		 yearCount.remove(firstKey);
		 try {
	         DocumentBuilderFactory dbFactory =
	         DocumentBuilderFactory.newInstance();
	         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	         Document doc = dBuilder.newDocument();
	         
	         Element rootElement = doc.createElement("DVD");
	         doc.appendChild(rootElement);

	         Element summary = doc.createElement("summary");
	         rootElement.appendChild(summary);
	         
	         for (String year : yearCount.keySet()) {
	        	 Element count = doc.createElement("count");
	        	 count.appendChild(doc.createTextNode(yearCount.get(year).toString()));
	        	 summary.appendChild(count);
	        	 Attr attr = doc.createAttribute("decade");
		         attr.setValue(year);
		         count.setAttributeNode(attr);
	        	 }

	         TransformerFactory transformerFactory = TransformerFactory.newInstance();
	         Transformer transformer = transformerFactory.newTransformer();
	         DOMSource source = new DOMSource(doc);
	         
	         StreamResult consoleResult = new StreamResult(System.out);
	         transformer.transform(source, consoleResult);
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	 }

}
