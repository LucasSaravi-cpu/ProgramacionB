package modelo;

import java.util.List;

public class TiempoCompleto extends PuestoTrabajo {
    
	private int horassemanales;

	public TiempoCompleto(Empresa empresa, String descripcion, double salarioOfrecido, int aniosEperienciaRequerida,
			Modalidad modalidad, List<Habilidad> habilidadesRequeridas, int experienciaMinAnios) {
		super(empresa, descripcion, salarioOfrecido, aniosEperienciaRequerida, modalidad, habilidadesRequeridas);
		this.horassemanales=horassemanales;
	}

	@Override
	public double Bonificacionesadicionales() {
	
	  
	        if ( getAniosEperienciaRequerida() == 0)
				return 0.10;
			else
				return 0.0;
	    }

	@Override
	public String toString() {
		return super.toString()+"TiempoCompleto [horassemanales=" + horassemanales + "]";
	}
	

	 @Override
	    public String getTipo() {
	        return "Tiempo Completo";
	    }
  
	
	
}


