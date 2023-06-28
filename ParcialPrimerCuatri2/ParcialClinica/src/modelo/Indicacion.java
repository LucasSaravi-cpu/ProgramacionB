package modelo;

public class Indicacion {
	
	private Profesional MedicoPrescripto;
	private Paciente Paciente;
	private int fechaPrescripcion;
	private String Indicacion;
	public Indicacion(Profesional medicoPrescripto, modelo.Paciente paciente, int fechaPrescripcion,
			String indicacion) {
		super();
		MedicoPrescripto = medicoPrescripto;
		Paciente = paciente;
		this.fechaPrescripcion = fechaPrescripcion;
		Indicacion = indicacion;
	}
	public Profesional getMedicoPrescripto() {
		return MedicoPrescripto;
	}
	public void setMedicoPrescripto(Profesional medicoPrescripto) {
		MedicoPrescripto = medicoPrescripto;
	}
	public Paciente getPaciente() {
		return Paciente;
	}
	public void setPaciente(Paciente paciente) {
		Paciente = paciente;
	}
	public int getFechaPrescripcion() {
		return fechaPrescripcion;
	}
	public void setFechaPrescripcion(int fechaPrescripcion) {
		this.fechaPrescripcion = fechaPrescripcion;
	}
	public String getIndicacion() {
		return Indicacion;
	}
	public void setIndicacion(String indicacion) {
		Indicacion = indicacion;
	}
	@Override
	public String toString() {
		return "Indicaciones:     Medico " + MedicoPrescripto + ",     Paciente:" + Paciente + ",   fecha:"
				+ fechaPrescripcion + ",    Indicacion: "+ Indicacion ;
	}
	
	
	
	
}