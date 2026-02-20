package Modelo;

public class AlumnoRegular extends Alumno{
	
	
	private double porcentajeAsistencia;

    public AlumnoRegular(String nombre, double porcentajeAsistencia) {
        super(nombre);
        this.porcentajeAsistencia = porcentajeAsistencia;
    }

    @Override
    public String Condicion() {

        if (porcentajeAsistencia >= 75 &&
                !tieneAusente() &&
                calcularPromedio() >= 6 &&
                !tieneNotaMenorA4()) {

            return "Aprobado";
        }

        return "Desaprobado";
    }

    public double getPorcentajeAsistencia() {
        return porcentajeAsistencia;
    }

    @Override
	public String toString() {
		return super.toString() + "\n" +" PorcentajeAsistencia"+ "\t"+ porcentajeAsistencia+"\n" ;
	}
    
	@Override
	public String gettipo() {
	
		return "Regular";
	}
	
    
    
    
}
