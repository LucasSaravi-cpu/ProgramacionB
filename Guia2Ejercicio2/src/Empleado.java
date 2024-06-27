
public class Empleado extends Persona {
	
	private float sueldo;
	
	
	public Empleado(String nombre, String fechaNacimiento, double sueldo) {
		super(nombre, fechaNacimiento);
		this.sueldo = (float) sueldo;
	}

	public float getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = (float) sueldo;
	}

	

	@Override
	public String toString() {
		
		return super.toString() +" su sueldo es de " + sueldo;   // Ademas agrega el Tostring de la clase padre que hereda .
	}

	
	
	

}
