
public class Atleta {
	
	    private String nombre;
	    private String categoria;

	    public Atleta(String nombre, String categoria) {
	        this.nombre = nombre;
	        this.categoria = categoria;
	    }

	    public void correr() {
	        System.out.println("El atleta " + nombre + " está corriendo.");
	    }

	    public void cargarDatos() {
	        System.out.println("Cargando datos del atleta " + nombre);
	    }

	    public void verDatos() {
	        System.out.println("Su nombre es  " + nombre + " y su categoria es " + categoria );
	    }

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getCategoria() {
			return categoria;
		}

		public void setCategoria(String categoria) {
			this.categoria = categoria;
		}
	    
	    
	    
	    
	}





