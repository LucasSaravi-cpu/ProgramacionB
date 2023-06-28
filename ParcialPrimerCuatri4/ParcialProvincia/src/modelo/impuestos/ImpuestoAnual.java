package modelo.impuestos;

public class ImpuestoAnual {

	private int anio;
	private float importe;
	private Propiedad propiedad;
		
	public ImpuestoAnual(int anio, float importe, Propiedad propiedad) {
		super();
		this.anio = anio;
		this.importe = importe;
		this.propiedad = propiedad;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("Año Impuesto: %d\t Importe: %.2f", anio, importe));
		return sb.toString();
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public float getImporte() {
		return importe;
	}

	public void setImporte(float importe) {
		this.importe = importe;
	}

	public Propiedad getPropiedad() {
		return propiedad;
	}

	public void setPropiedad(Propiedad propiedad) {
		this.propiedad = propiedad;
	}

	
}
