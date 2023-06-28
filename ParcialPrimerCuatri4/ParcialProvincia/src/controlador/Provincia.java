package controlador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import modelo.impuestos.ImpuestoAnual;
import modelo.impuestos.Propiedad;
import modelo.provincia.parametricas.Propietario;
import modelo.provincia.parametricas.ParametrosLiquidacion;

public class Provincia {
	
	private String nombre;
	private ParametrosLiquidacion parametrosLiquidacion;
	private List<Propietario> listaPropietarios;
	private List<ImpuestoAnual> listaImpuestos;
	private List<Propiedad> listaPropiedades;

	public Provincia(String nombre, ParametrosLiquidacion parametrosLiquidacion) {
		this.setNombre(nombre);
		this.setParametrosValorizacion(parametrosLiquidacion);
		listaPropietarios = new ArrayList<Propietario>();
		listaPropiedades = new ArrayList<Propiedad>();
		listaImpuestos = new ArrayList<ImpuestoAnual>();
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ParametrosLiquidacion getParametrosValorizacion() {
		return parametrosLiquidacion;
	}

	public void setParametrosValorizacion(ParametrosLiquidacion parametrosValorizacion) {
		this.parametrosLiquidacion = parametrosValorizacion;
	}
	
	public void agregar(ImpuestoAnual item) {
        listaImpuestos.add(item);		
	}
	
	public void agregar(Propietario item) {
        listaPropietarios.add(item);		
	}

	public Iterator<Propietario> getPropietarios() {
		return listaPropietarios.iterator();
	}
	
	public Iterator<Propiedad> getPropiedades() {
		return listaPropiedades.iterator();
	}


	public void ordenarImpuestos() {
		Collections.sort(listaImpuestos, (Comparator.<ImpuestoAnual>comparingInt(item -> item.getAnio())));
	}
	
	public String imprimirImpuestos(int anioBuscado, Propietario propietarioBuscado) {
		StringBuilder stb = new StringBuilder();
		stb.append("===<< ");
		stb.append(this.getNombre());
		stb.append(" >>============================================================================================\n");
		
		this.ordenarImpuestos();
        int anioAnterior = -1; 		
		for (ImpuestoAnual impuesto: listaImpuestos) {
			boolean coincideAnio = (anioBuscado == 0) || (anioBuscado == impuesto.getAnio());
			boolean coincidePropietario =  (propietarioBuscado == null) || impuesto.getPropiedad().getPropietario().equals(propietarioBuscado);
			if ((coincideAnio) && (coincidePropietario)) {
				if (impuesto.getAnio() != anioAnterior) {
					anioAnterior = impuesto.getAnio();
					stb.append("\n");
					stb.append("Impuestos del Año ");
					stb.append(impuesto.getAnio());
					stb.append("\n");
					stb.append("=======================================================================================================================\n");
				}
				stb.append(impuesto.getPropiedad().toString());
				stb.append("\n");
				stb.append("\t");
				stb.append(impuesto.toString());
				stb.append("\n");
				stb.append("-------------------------------------------------------------------------------------------------------------------------------------\n");
			}
		}
		return stb.toString();
	}

	public void agregar(Propiedad propiedad) {
		listaPropiedades.add(propiedad);
	}

	public String liquidarImpuestos(int anioImpuesto) {
		int cuotasLiquidadas = 0;
		float totalImpuestos = 0;
		for (Iterator<Propiedad> iterator = this.getPropiedades(); iterator.hasNext();) {
			Propiedad p = iterator.next();
			ImpuestoAnual i = p.calcularImpuesto(anioImpuesto, this.getParametrosValorizacion());
			if (i != null) {
				this.agregar(i);
				cuotasLiquidadas++;
				totalImpuestos = totalImpuestos + i.getImporte();
			}
		}
		return String.format("%s %d %s %.2f", "Cuotas liquidadas: ", cuotasLiquidadas, "\tTotal: ", totalImpuestos);
	}
	
}
