package model;

import java.math.BigDecimal;

public class SocioVitalicio extends Socio{
	
	 private static final BigDecimal DESCUENTO_VITALICIO = BigDecimal.valueOf(0.4);

	public SocioVitalicio(long idSocio, String nombre, char genero , boolean vitalicio) {
		super(idSocio, nombre, genero, vitalicio);
	}

	
	@Override
	   public BigDecimal calculaCuota(int cantidad, BigDecimal valor) {
      
        BigDecimal cuotaBase = super.calculaCuota(cantidad, valor);
        
      
        return cuotaBase.multiply( DESCUENTO_VITALICIO);
    }

	
	@Override
    public String esVitalicio() {
		
		  
		
		return "Vitalicio";
		
	}

	
	
	
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "SocioVitalicio [getIdSocio()=" + getIdSocio() + ", getNombre()=" + getNombre() + ", getGenero()="
				+ getGenero() + ", isVitalicio()=" + isVitalicio() + ", getDeportes()=" + getDeportes()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
	
	
	
	
	

}
