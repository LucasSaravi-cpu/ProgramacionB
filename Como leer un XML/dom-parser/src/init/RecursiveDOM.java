package init;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class RecursiveDOM {

    public RecursiveDOM(final String file) throws SAXException, IOException, ParserConfigurationException {
		System.out.println("\n\n\n");
		System.out.println("-----------------------");
		System.out.println("Procesamiento recursivo");
		System.out.println("-----------------------");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(true);
		factory.setNamespaceAware(true);
		factory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://java.sun.com/xml/jaxp/properties/schemaLanguage");
		DocumentBuilder builder = factory.newDocumentBuilder();
		builder.setErrorHandler(new SimpleErrorHandler());
		Document doc = builder.parse(file);
		
        Element nodoRaiz = doc.getDocumentElement();
        parse(nodoRaiz);
    }

    private void parse(final Element e) {
        final NodeList children = e.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            final Node n = children.item(i);
            
            if (n.getNodeType() == Node.ELEMENT_NODE) {
            	if (n.getNodeName().equals("book")) {
            		System.out.println();
            		System.out.print(n.getNodeName());
            	}
            	else {
            		String line = "\t" + n.getNodeName() + ": " + (!n.hasChildNodes() ? "" : n.getTextContent());
            		System.out.print(line);
            	}
            	if (n.hasAttributes()) {
            		System.out.print("\tAttributes --> ");
            		String delimAttrib = "";
            		for (int j = 0; j < n.getAttributes().getLength(); j++) {
            			String line = delimAttrib + n.getAttributes().item(j).getNodeName() + "=" + n.getAttributes().item(j).getTextContent();
            			System.out.print(line);
            			delimAttrib = "; ";
            		}
            	}
            	System.out.println();
            	parse((Element)n);
            } 
        }
    }
}