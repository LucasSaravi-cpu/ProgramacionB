package modelo.categorias;

import java.util.ArrayList;

public class Aromatica extends Especie {

	ArrayList<String> usos;
	
	public Aromatica(String nombre, int vida, int alturaMax, float precioBase, ArrayList<String> usos) {
		super(nombre, vida, alturaMax, precioBase);
		this.usos = usos;
	}

	
	@Override
	public float getPrecioVenta() { //por cada uso del ejemplar, se aplica un 10% de incremento
		float precio = super.getPrecioBase();
		
		if (this.usos.size()<0) {
			for (int i=0; i<this.usos.size(); i++) {
				precio = (float) (precio*1.1);
			}
		}
		return precio;
	}


	public ArrayList<String> getUsos() {
		return usos;
	}


	public void setUsos(ArrayList<String> usos) {
		this.usos = usos;
	}


	@Override
	public String toString() {
		return "Aromatica usos: " + usos  + super.toString()
				+ "\n";
	}
	
	
	
	
}
