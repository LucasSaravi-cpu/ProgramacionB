package modelo.categorias;

public abstract class Especie {

		private String nombre;
		private int vida, alturaMax;
		private float precioBase;
		
		public Especie(String nombre, int vida, int alturaMax, float precioBase) {
			this.nombre = nombre;
			this.vida = vida;
			this.alturaMax = alturaMax;
			this.precioBase = precioBase;
		}

		public int getVidaEsperada() {
			return this.vida;
		}

		public abstract float getPrecioVenta();
		

		public int getAlturaMax() {
			return this.alturaMax;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public float getPrecioBase() {
			return precioBase;
		}

		public void setPrecioBase(float precioBase) {
			this.precioBase = precioBase;
		}

		@Override
		public String toString() {
			return "Nombre: " + nombre + ", vida esperada: " + vida + ", alt. max(m): " + alturaMax + ", precio venta base:"
					+ precioBase + ", precio de venta: " + getPrecioVenta() + "\n";
		}
		
		
}
