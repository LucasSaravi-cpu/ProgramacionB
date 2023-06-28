package modelo;

public  class TrabajoEstudiantil extends Trabajo {
	


	private int añoCarrera;
	private boolean proyectoFinal;
	private double VALOR;
	private Alumno alumno;
	
	

	
	

	public TrabajoEstudiantil(String titulo, int fecha, AreaTematica areatematica, boolean proyectoFinal,
			int añoCarrera, double vALOR, Alumno alumno) {
		super(titulo, fecha, areatematica);
		this.añoCarrera = añoCarrera;
		this.proyectoFinal = proyectoFinal;
		VALOR = vALOR;
		this.alumno = alumno;
	}





	public int getAñoCarrera() {
		return añoCarrera;
	}





	public void setAñoCarrera(int añoCarrera) {
		this.añoCarrera = añoCarrera;
	}





	public boolean isProyectoFinal() {
		return proyectoFinal;
	}





	public void setProyectoFinal(boolean proyectoFinal) {
		this.proyectoFinal = proyectoFinal;
	}





	public double getVALOR() {
		return VALOR;
	}





	public void setVALOR(double vALOR) {
		VALOR = vALOR;
	}





	public Alumno getAlumno() {
		return alumno;
	}





	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}





	@Override
	public double CalcularTarifa() {
		
		if(alumno.getUniversidad().isPublica()) {
			
		
		return VALOR=1000-(2000*0.3);
		}
		else {
			return VALOR=1000;
		}
		

	
		
	}





	@Override
	public String toString() {
		return "Estudiantil " + super.toString()+"\n"+"Alumno: " +alumno +"Año" + añoCarrera + ", proyecto Final " + proyectoFinal + ", VALOR : " + VALOR;
			
	}
	
	
	
	
}


	






