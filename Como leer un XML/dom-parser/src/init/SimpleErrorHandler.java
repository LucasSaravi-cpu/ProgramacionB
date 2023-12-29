package init;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class SimpleErrorHandler implements ErrorHandler {

	@Override
	public void warning(SAXParseException e) throws SAXException {
		System.out.println("Atenci�n: Archivo no v�lido -> " + e.getMessage());
		throw new SAXException(e.getMessage());
	}
	

	@Override
	public void error(SAXParseException e) throws SAXException {
			System.out.println("Error: Archivo no v�lido -> " + e.getMessage());
			throw new SAXException(e.getMessage());
	}

	@Override
	public void fatalError(SAXParseException e) throws SAXException {
		System.out.println("Error Fatal: Archivo no v�lido -> " + e.getMessage());
		throw new SAXException(e.getMessage());
	}

}
