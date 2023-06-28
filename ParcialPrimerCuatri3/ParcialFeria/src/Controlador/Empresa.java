package Controlador;
import java.util.ArrayList;
import java.util.List;

import Modelo.Accesorio;
import Modelo.Cliente;
import Modelo.Stand;

public class Empresa {
	private String nombre;
	private List<Accesorio> ListaAccesorios;
	private List<Cliente> ListaClientes;
	private List<Stand> ListaStands;

	public Empresa(String nombre) {
		this.setNombre(nombre);
		ListaClientes= new ArrayList<>();
		ListaAccesorios= new ArrayList<>();
		ListaStands= new ArrayList<>();
	}

	public void agregar(Cliente cliente) {
		ListaClientes.add(cliente);
	}

	public void agregar(Accesorio accesorio) {
		ListaAccesorios.add(accesorio);
	}
	
	public void agregar(Stand stand) {
		ListaStands.add(stand);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Accesorio> getListaAccesorios() {
		return ListaAccesorios;
	}

	public void setListaAccesorios(List<Accesorio> listaAccesorios) {
		ListaAccesorios = listaAccesorios;
	}

	public List<Cliente> getListaClientes() {
		return ListaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		ListaClientes = listaClientes;
	}

	public List<Stand> getListaStands() {
		return ListaStands;
	}

	public void setListaStands(List<Stand> listaStands) {
		ListaStands = listaStands;
	}
	
	public String listarStands() {
		StringBuilder str = new StringBuilder();
		for (Stand a: ListaStands) {
			str.append(a.toString());
			str.append("| \n");
		}
		return str.toString();
		}

}
