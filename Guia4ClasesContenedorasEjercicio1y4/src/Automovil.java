
public class Automovil {
	
	   private String patente;
	    private String due�o;
	    private Motor motor;
	    private int kilometraje;

	    public Automovil(String patente, String due�o, Motor motor) {
	        this.patente = patente;
	        this.due�o = due�o;
	        this.motor = motor;
	        this.kilometraje = 0;
	    }

		public String getPatente() {
			return patente;
		}

		public String getDue�o() {
			return due�o;
		}

		public Motor getMotor() {
			return motor;
		}

		public void setPatente(String patente) {
			this.patente = patente;
		}

		public void setDue�o(String due�o) {
			this.due�o = due�o;
		}

		public void setMotor(Motor motor) {
			this.motor = motor;
		}

		public int getKilometraje() {
			return kilometraje;
		}

		public void setKilometraje(int kilometraje) {
			this.kilometraje = kilometraje;
		}
	    
	    

}
