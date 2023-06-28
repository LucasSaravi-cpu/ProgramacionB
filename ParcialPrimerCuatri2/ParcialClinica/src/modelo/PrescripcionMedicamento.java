package modelo;

public class PrescripcionMedicamento extends Indicacion {
	
	private int cantidad;
	private int frecuencia;
    private int horaInicio;
    private Medicamento medicamento;
	
   

	public PrescripcionMedicamento(Profesional medicoPrescripto, modelo.Paciente paciente, int fechaPrescripcion,
			String indicacion, int cantidad, int frecuencia, int horaInicio, Medicamento medicamento) {
		super(medicoPrescripto, paciente, fechaPrescripcion, indicacion);
		this.cantidad = cantidad;
		this.frecuencia = frecuencia;
		this.horaInicio = horaInicio;
		this.medicamento = medicamento;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getFrecuencia() {
		return frecuencia;
	}

	public void setFrecuencia(int frecuencia) {
		this.frecuencia = frecuencia;
	}

	public int getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(int horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	@Override
	public String toString() {
		return "Medicamento Cantidad  " + cantidad + ", frecuencia en el que la tiene que tomar " + frecuencia + ", horaInicio: "
				+ horaInicio + ",  medicamento: " + medicamento ;
	}
    

	

   
    
    

}
