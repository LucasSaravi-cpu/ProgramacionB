package persistencia;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

public class Controlador implements Serializable {
	
	private static final long serialVersionUID = 5606071123771967041L;
	
	private ArrayList<Cliente> lista;

    public Controlador() {
    	lista = new ArrayList<Cliente>();
    }
    
    public void add(Cliente c) {
    	lista.add(c);
    }
	
    public String listar() {
    	StringBuilder sb = new StringBuilder();
    	for(Cliente c : lista) {
    		sb.append(c.toString());
    		sb.append("\n");
    	}
    	return sb.toString();
    }

	public void sumar(BigDecimal valor) {
    	for(Cliente c : lista) {
    		c.setSaldo(c.getSaldo().add(valor));
    	}
		
	}
}
