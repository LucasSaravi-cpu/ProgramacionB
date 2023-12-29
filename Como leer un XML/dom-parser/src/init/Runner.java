package init;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;

public class Runner {

	public static void main(String[] args) {
		try {
			procesarXMLBooks();
			new RecursiveDOM("src/books.xml");
		} catch (IOException | ParserConfigurationException | SAXException e) {
			System.out.println("Se ha producido un error: " + e.getMessage());
		}		
	}

	private static void procesarXMLBooks() throws IOException, ParserConfigurationException, SAXException {
			System.out.println("\n\n\n");
			System.out.println("-------------------------");	
			System.out.println("Procesamiento tradicional");
			System.out.println("-------------------------");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setValidating(true);
			factory.setNamespaceAware(true);
			factory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://java.sun.com/xml/jaxp/properties/schemaLanguage");
			DocumentBuilder builder = factory.newDocumentBuilder();
							
			builder.setErrorHandler(new SimpleErrorHandler());
			Document doc = builder.parse("src/books.xml");
			NodeList list = doc.getElementsByTagName("book");
			for (int i = 0; i < list.getLength(); i++) { 
				Element element = (Element) list.item(i);   
				Node e = element.getFirstChild();				
				if (element.getNodeName().equalsIgnoreCase("book")) {
					System.out.println();
					System.out.println("Book ID= " + element.getAttribute("id")); 
					NodeList list1 = element.getElementsByTagName("*");
					for (int k = 0; k < list1.getLength(); k++) {
						Element element2 = (Element) list1.item(k);
						System.out.println("\t" + element2.getNodeName() + "    " + element2.getTextContent()); 	
						for (int j = 0; j < element2.getAttributes().getLength(); j++) {
							System.out.println("\t\t\t" + element2.getAttributes().item(j).getNodeName() + "   " + element2.getAttributes().item(j).getTextContent()); 	
						}
					}
				}
				else {				
					System.out.println(element.getNodeName() + "    " + element.getTextContent()); 
					if (element.getNodeName().equalsIgnoreCase("isbn")) { 
						System.out.println("ISBN Kind=" + element.getAttribute("kind")); 
					}
				}			
			}
		
	}

}
