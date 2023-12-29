package init;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class SimpleErrorHandler implements ErrorHandler {

	@Override
	public void warning(SAXParseException e) throws SAXException {
		System.out.println("Atención: Archivo no válido -> " + e.getMessage());
		throw new SAXException(e.getMessage());
	}
	

	@Override
	public void error(SAXParseException e) throws SAXException {
			System.out.println("Error: Archivo no válido -> " + e.getMessage());
			throw new SAXException(e.getMessage());
	}

	@Override
	public void fatalError(SAXParseException e) throws SAXException {
		System.out.println("Error Fatal: Archivo no válido -> " + e.getMessage());
		throw new SAXException(e.getMessage());
	}

}
