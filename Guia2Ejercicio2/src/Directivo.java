import java.util.ArrayList;

public class Directivo extends Empleado {
    private String area;
    private ArrayList<Empleado> empleadosACargo;

    public Directivo(String nombre, String fechaNacimiento, double sueldo, String area, ArrayList<Empleado> empleadosACargo) {
        super(nombre, fechaNacimiento, sueldo);
        this.area = area;
        this.empleadosACargo = empleadosACargo;
    }

    public String getArea() {
        return area;
    }

    public ArrayList<Empleado> getEmpleadosACargo() {
        return empleadosACargo;
    }

    @Override
    public String toString() {
        String listaEmpleados = "";
        for (Empleado empleado : empleadosACargo) {
            listaEmpleados += " "+  empleado.getNombre();
        }
        return super.toString() + ", Área a cargo: " + area + ", Empleados a cargo:" + listaEmpleados ;
    }
}