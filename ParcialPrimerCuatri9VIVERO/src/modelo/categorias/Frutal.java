package modelo.categorias;

public class Frutal extends Arbol {

	private int kgsAnioEsperados;
	private boolean exotica;
	
	public Frutal(String nombre, int vida, int alturaMax, float precioBase, int diametro, int kgsAnioEsperados, boolean exotica) {
		super(nombre, vida, alturaMax, precioBase, diametro);
		this.kgsAnioEsperados = kgsAnioEsperados;
		this.exotica = exotica;
	}
	
	public boolean getExotico() {
		return this.exotica;
	}
	
	@Override
	public float getPrecioVenta(){
		if (this.getExotico()) {
			return (float) (super.getPrecioBase()*1.25);
		}else {
			return super.getPrecioBase();
		}
		
	}

	public int getKgsAnioEsperados() {
		return kgsAnioEsperados;
	}

	public void setKgsAnioEsperados(int kgsAnioEsperados) {
		this.kgsAnioEsperados = kgsAnioEsperados;
	}

	@Override
	public String toString() {
		return "Frutal kgs por año esperados: " + kgsAnioEsperados + ", es exotica: " + exotica +  super.toString() + "\n";
	}
	
	

}
