package modelo;

import java.util.List;


public class Independiente  extends PuestoTrabajo{
	
	private int duracionestimadodias;

	public Independiente(Empresa empresa, String descripcion, double salarioOfrecido, int aniosEperienciaRequerida,
			Modalidad modalidad, List<Habilidad> habilidadesRequeridas, int duracionestimadodias) {
		super(empresa, descripcion, salarioOfrecido, aniosEperienciaRequerida, modalidad, habilidadesRequeridas);
		this.duracionestimadodias = duracionestimadodias;
	}

	@Override
	public double Bonificacionesadicionales() {
		
			return 0.0;
	}

	@Override
	public String toString() {
		return super.toString()+"Independiente [duracionestimadodias=" + duracionestimadodias + "]";
	}

	  @Override
	    public String getTipo() {
	        return "Independiente";
	    }
	
	
	

}
