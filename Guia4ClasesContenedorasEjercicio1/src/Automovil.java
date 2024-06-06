
public class Automovil {
	
	   private String patente;
	    private String dueño;
	    private Motor motor;

	    public Automovil(String patente, String dueño, Motor motor) {
	        this.patente = patente;
	        this.dueño = dueño;
	        this.motor = motor;
	    }

		public String getPatente() {
			return patente;
		}

		public String getDueño() {
			return dueño;
		}

		public Motor getMotor() {
			return motor;
		}

		public void setPatente(String patente) {
			this.patente = patente;
		}

		public void setDueño(String dueño) {
			this.dueño = dueño;
		}

		public void setMotor(Motor motor) {
			this.motor = motor;
		}
	    
	    

}
