package controlador;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;


import modelo.categorias.*;
import modelo.parametricas.Meses.Mes;
import modelo.parametricas.Usos;
import modelo.parametricas.Usos.Uso;

public class Empresa {
	private String nombre;
	private Random random; //Se usará para generar aleatoriamente números
	private ArrayList <Especie> especies;
	private ArrayList <Ejemplar> ejemplares;
	private ArrayList <String> usos;
	
	public Empresa(String nombre) {
		this.setNombre(nombre);
		random = new Random();
		especies = new ArrayList <Especie> ();
		ejemplares = new ArrayList <Ejemplar>();
		usos = new ArrayList <String>();
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

 /**
  * crea por código y pone en una lista de Especies:
				-3 instancias de árboles, 
				-3 de frutales, 
				-3 de aromáticas 
				-3 de florales
  */
	public void crearEspecies() {
		
		
		Arbol arbol1 = new Arbol("Jacaranda", 50, 1500, 10, 8); especies.add(arbol1);
		Arbol arbol2 = new Arbol("Pino", 40, 1700, 12, 9); especies.add(arbol2);
		Arbol arbol3 = new Arbol("Abedul", 60, 1900, 11, 7); especies.add(arbol3);
		
		Frutal frutal1 = new Frutal ("Naranjo", 13, 1000, 5, 7, 5, false); especies.add(frutal1);
		Frutal frutal2 = new Frutal ("ArbolDeCaramelos", 20, 2000, 10, 10, 10, true); especies.add(frutal2);
		Frutal frutal3 = new Frutal ("Kiwi", 13, 1000, 5, 7, 5, false); especies.add(frutal3);
		
		usos.add(Uso.CONDIMENTO.toString()); usos.add(Uso.FRAGANCIA.toString()); 
		Aromatica aromatica1 = new Aromatica ("Lavanda", 5, 1500, 2, usos); especies.add(aromatica1);
		usos.clear();
		usos.add(Uso.INFUSION.toString()); usos.add(Uso.FRAGANCIA.toString()); 
		Aromatica aromatica2 = new Aromatica ("Rosal", 7, 200, 5, usos); especies.add(aromatica2);
		usos.clear();
		usos.add(Uso.MEDICINAL.toString()); 
		Aromatica aromatica3 = new Aromatica ("Eucalipto", 15, 1750, 15, usos); especies.add(aromatica3);
		
		Floral floral1 = new Floral ("Margaritas", 2, 700, 3, Mes.ABR); especies.add(floral1);
		Floral floral2 = new Floral ("FloresAmarillas", 3, 800, 4, Mes.DIC); especies.add(floral2);
		Floral floral3 = new Floral ("FloresAzules", 4, 600, 2, Mes.JUL); especies.add(floral3);
		
	}
//TODO
	/**
	 * 	Para generar un Ejemplar:
				-utilizar el código de barras almacenado en la variable codeBar
				-obtener una especie aleatoriamente, con getEspecieRandom
				-obtener un año de produccion aleatoriamente con getAnioProduccionRandom
	 */
	public void crearEjemplares() {
		int base = ejemplares.size(); 
		
		for (int i = 1; (i <= 10); i++) {
			int codeBar = 1000 + base + i;
			Especie espe = this.getEspecieRandom();
			int anio = this.getAnioProduccionRandom(espe);
			
			Ejemplar ej = new Ejemplar (codeBar, anio, espe);
			ejemplares.add(ej);
			
		}		
	}


	private int getAnioProduccionRandom(Especie especie) {
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		return random.nextInt((currentYear - (currentYear - especie.getVidaEsperada())) + 1) + (currentYear - especie.getVidaEsperada());
	}
	 
	
	private Especie getEspecieRandom() {
		if (especies.size() > 0) {
			int pos = random.nextInt(especies.size());
			return especies.get(pos);
		}
		else {
			return null;
		}
	}

	public String listarEjemplares() {
		String s= "=========Vivero LA SEQUÍA. Listado de ejemplares para la venta=====================\n\n";
		for (int i = 0; i<ejemplares.size(); i++){
			s+= ejemplares.get(i).toString();
			s+= "\n";
		}
		return s;
	}	

}
