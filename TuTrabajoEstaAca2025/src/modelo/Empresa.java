package modelo;


public class Empresa {
    private String nombre;
    private String rubro;

    public Empresa(String nombre, String rubro) {
        this.nombre = nombre;
        this.rubro = rubro;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRubro() {
        return rubro;
    }

	@Override
	public String toString() {
		return nombre + "-" + rubro;
	}
    
    
    
    
}