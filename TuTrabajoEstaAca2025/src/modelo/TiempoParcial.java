package modelo;

import java.util.List;

public class TiempoParcial extends PuestoTrabajo{
	
	private int cantdiasporsemana;
	private int horaspordia;
	
	public TiempoParcial(Empresa empresa, String descripcion, double salarioOfrecido, int aniosEperienciaRequerida,
			Modalidad modalidad, List<Habilidad> habilidadesRequeridas, int cantdiasporsemana, int horaspordia) {
		super(empresa, descripcion, salarioOfrecido, aniosEperienciaRequerida, modalidad, habilidadesRequeridas);
		this.cantdiasporsemana = cantdiasporsemana;
		this.horaspordia = horaspordia;
	}
    
	
	@Override
	public double Bonificacionesadicionales() {
	
	  
	        if (cantdiasporsemana*horaspordia >= 20)
				return 0.03;
			else
				return 0.0;
	    }


	@Override
	public String toString() {
		return super.toString()+"TiempoParcial [cantdiasporsemana=" + cantdiasporsemana + ", horaspordia=" + horaspordia + "]";
	}
	
	 @Override
	    public String getTipo() {
	        return "Tiempo Parcial";
	    }
	

}
