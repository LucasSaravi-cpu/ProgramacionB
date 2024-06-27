import java.util.ArrayList;
import java.util.List;

public class Empresa {

	private List<Cliente> listaCliente;
	private List<Empleado> listaEmpleado;

	public Empresa() {

		this.listaCliente = new ArrayList<Cliente>();
		this.listaEmpleado = new ArrayList<Empleado>();

	}

	public void agregar(Cliente Cliente) {  //Agrega un cliente a la lista 
		listaCliente.add(Cliente);
	}

	public void agregar(Empleado Empleado) { // Agrega un empleado a la lista 
		listaEmpleado.add(Empleado);
	}

	public void listarClientes(Cliente Cliente) {  //Lista clientes 
		
		for(Cliente cliente: listaCliente) 
		{
			
			System.out.println(cliente);
		}
		
		
	}

	public void listarEmpleados(Empleado Empleado) {  // Lista empleados
		
		for(Empleado empleado: listaEmpleado) 
		{
		    
			System.out.println(empleado); 
		}
	}

	public List<Cliente> getListaCliente() {
		return listaCliente;
	}

	public void setListaCliente(List<Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}

	public List<Empleado> getListaEmpleado() {
		return listaEmpleado;
	}

	public void setListaEmpleado(List<Empleado> listaEmpleado) {
		this.listaEmpleado = listaEmpleado;
	}
	
	
	

}