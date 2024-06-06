
public class Motor {
	
	  private int cilindrada;
	    private String tipo;

	    public Motor(int cilindrada, String tipo) {
	        this.cilindrada = cilindrada;
	        this.tipo = tipo;
	    }

		public int getCilindrada() {
			return cilindrada;
		}

		public String getTipo() {
			return tipo;
		}

		public void setCilindrada(int cilindrada) {
			this.cilindrada = cilindrada;
		}

		public void setTipo(String tipo) {
			this.tipo = tipo;
		}
	    
	    

}
