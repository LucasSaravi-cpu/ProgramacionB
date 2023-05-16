
public class Animal {
	

	    private String especie;
	    private String grupo;

	    public Animal(String especie, String grupo) {
	        this.especie = especie;
	        this.grupo = grupo;
	    }

	    public void cargar() {
	        System.out.println("Cargando datos del animal " + especie);
	    }

	    public void ver() {
	        System.out.println("Su especie es un" + especie + " y su grupo es " + grupo);
	    }

		public String getEspecie() {
			return especie;
		}

		public void setEspecie(String especie) {
			this.especie = especie;
		}

		public String getGrupo() {
			return grupo;
		}

		public void setGrupo(String grupo) {
			this.grupo = grupo;
		}
	    
	    
	    
	}


