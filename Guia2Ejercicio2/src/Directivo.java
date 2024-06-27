import java.util.ArrayList;

public class Directivo extends Empleado {
    private String area;
    private ArrayList<Empleado> empleadosACargo;

    public Directivo(String nombre, String fechaNacimiento, double sueldo, String area ) {
        super(nombre, fechaNacimiento, sueldo);
        this.area = area;
        this.empleadosACargo = new ArrayList<Empleado>();

    }

    public String getArea() {
        return area;
    }

    public ArrayList<Empleado> getEmpleadosACargo() {
        return empleadosACargo;
    }
    
    

    public void setArea(String area) {
		this.area = area;
	}

	public void setEmpleadosACargo(ArrayList<Empleado> empleadosACargo) {
		this.empleadosACargo = empleadosACargo;
	}

	@Override
    public String toString() {
        String listaEmpleados = "";
        for (Empleado empleado : empleadosACargo) {
            listaEmpleados += " "+  empleado.getNombre();
        }
        return super.toString() + ", Area a cargo: " + area + ", Empleados a cargo:" + listaEmpleados ;
    }
}