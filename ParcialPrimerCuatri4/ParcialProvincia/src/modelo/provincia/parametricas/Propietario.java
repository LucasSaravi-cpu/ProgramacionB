package modelo.provincia.parametricas;

import java.io.Serializable;

public class Propietario {
	
	private String cuit;
	private String nombre;
	
	public Propietario(String cuit, String nombre) {
		super();
		this.cuit = cuit;
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return nombre + " (" + cuit + ")";
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Propietario)) {
            return false;
        }  
        return ((Propietario)o).getCuit().equalsIgnoreCase(this.getCuit());
    }

}	
	