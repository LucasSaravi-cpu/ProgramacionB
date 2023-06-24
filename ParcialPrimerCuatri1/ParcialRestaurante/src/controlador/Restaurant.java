package controlador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import modelo.carta.ItemCartaGastronomica;
import modelo.carta.parametricas.TipoItem;
import modelo.carta.parametricas.Ingrediente;
import modelo.carta.parametricas.ParametrosValorizacion;

public class Restaurant {
	
	private String nombre;
	private ParametrosValorizacion parametrosValorizacion;
	private List<Ingrediente> listaIngredientes;
	private List<TipoItem> listaTiposItem;
	private List<ItemCartaGastronomica> cartaGastronomica;

	public Restaurant(String nombre, ParametrosValorizacion parametrosValorizacion) {
		this.setNombre(nombre);
		this.setParametrosValorizacion(parametrosValorizacion);
		listaIngredientes = new ArrayList<Ingrediente>();
		listaTiposItem = new ArrayList<TipoItem>();
		cartaGastronomica = new ArrayList<ItemCartaGastronomica>();
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ParametrosValorizacion getParametrosValorizacion() {
		return parametrosValorizacion;
	}

	public void setParametrosValorizacion(ParametrosValorizacion parametrosValorizacion) {
		this.parametrosValorizacion = parametrosValorizacion;
	}

	public void agregar(Ingrediente c) {
		listaIngredientes.add(c);
	}
	
	public void agregar(TipoItem a) {
		listaTiposItem.add(a);
	}
	
	public void agregar(ItemCartaGastronomica item) {
        cartaGastronomica.add(item);		
	}

	public Iterator<Ingrediente> getIngredientes() {
		return listaIngredientes.iterator();
	}

	public Iterator<TipoItem> getTiposItem() {
		return listaTiposItem.iterator();
	}

	public void ordenarCartaGastronomica() {
		Collections.sort(cartaGastronomica, (Comparator.<ItemCartaGastronomica>comparingInt(item -> item.getCategoria().getOrdenEnCarta())));
	}
	
	public String imprimirCartaGastronomica() {
		StringBuilder stb = new StringBuilder();
		stb.append("===<< ");
		stb.append(this.getNombre());
		stb.append(" >>========================================================================================================\n");
		
		this.ordenarCartaGastronomica();
        int categAnterior = -1; 		
		for (ItemCartaGastronomica item: cartaGastronomica) {
			if (item.getCategoria().getOrdenEnCarta() != categAnterior) {
				categAnterior = item.getCategoria().getOrdenEnCarta();
				stb.append("\n");
				stb.append(item.getCategoria().getDescripcion());
				stb.append("\n");
				stb.append("----------------------------------------------------------------------------------------------------------------------------------------\n");
			}
			stb.append(item.toString()).append("\t\t").append(item.getPrecioVenta(this.parametrosValorizacion)).append("\n");
		}
		return stb.toString();
	}
	
}
