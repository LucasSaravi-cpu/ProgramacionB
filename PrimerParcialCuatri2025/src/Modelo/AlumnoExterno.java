package Modelo;

public class AlumnoExterno extends Alumno{

	private String institucion;

    public AlumnoExterno(String nombre, String institucion) {
        super(nombre);
        this.institucion = institucion;
    }

    @Override
    public String Condicion() {

        if (tieneAusente() || tieneNotaMenorA4()) {
            return "Certificado de Asistencia";
        }

        double promedio = calcularPromedio();

        if (promedio >= 7) {
            return "Certificado de Aprobación Sobresaliente";
        } else if (promedio >= 5) {
            return "Certificado de Aprobación";
        }

        return "Certificado de Asistencia";
    }

    public String getInstitucion() {
        return institucion;
    }

	@Override
	public String toString() {
		return super.toString() + "\n" +"Insitucion "+ "\t"+ institucion+"\n" ;
	}

	@Override
	public String gettipo() {
	
		return "Externo";
	}
	

    
    
}
