package modelo.categorias;

public class Arbol extends Especie {
	
	private int diametro;

	public Arbol(String nombre, int vida, int alturaMax, float precioBase, int diametro) {
		super(nombre, vida, alturaMax, precioBase);
		this.diametro = diametro;
	}

	public boolean esVoluminoso() {
		if ((this.getAlturaMax() >=5) && (getDiametro() >=4)) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public float getPrecioVenta() {
		if (esVoluminoso()) { //si es un arbol voluminoso, se le aplica un incremento del 20%
			return (float) (super.getPrecioBase()*1.2);
		}else {
			return super.getPrecioBase();
		}
	}
	
	public int getDiametro() {
		return this.diametro;
	}

	public void setDiametro(int diametro) {
		this.diametro = diametro;
	}

	@Override
	public String toString() {
		return "Arbol diametro copa:" + diametro + ", " + super.toString() + "\n";
	}
	//agregar si es voluminoso
	
	
	

}
