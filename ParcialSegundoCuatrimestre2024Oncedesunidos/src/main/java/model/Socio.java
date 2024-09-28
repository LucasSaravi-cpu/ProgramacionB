package model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Socio {
	
	 private static final BigDecimal DESCUENTO_MULTIPLES_DEPORTES = BigDecimal.valueOf(0.8); 

	
	 private long idSocio;
	 private String nombre;
	 private char genero;
	 private boolean vitalicio;
	 
	 private List<Deporte> deportes;
	 
	 
	 
	 
	 public Socio(long idSocio, String nombre, char genero, boolean vitalicio) {
		super();
		this.idSocio = idSocio;
		this.nombre = nombre;
		this.genero = genero;
		this.vitalicio = vitalicio;
		this.deportes = new ArrayList<>();
	}
	 
	 
	 
	 
	 
	 
	public long getIdSocio() {
		return idSocio;
	}






	public void setIdSocio(long idSocio) {
		this.idSocio = idSocio;
	}






	public String getNombre() {
		return nombre;
	}






	public void setNombre(String nombre) {
		this.nombre = nombre;
	}






	public char getGenero() {
		return genero;
	}






	public boolean isVitalicio() {
		return vitalicio;
	}






	public void setVitalicio(boolean vitalicio) {
		this.vitalicio = vitalicio;
	}






	public void setGenero(char genero) {
		this.genero = genero;
	}






	public List<Deporte> getDeportes() {
			return deportes;
		}
		public void setDeportes(List<Deporte> deportes) {
			this.deportes = deportes;
		}


		
		public BigDecimal calculaCuota(int cantidad, BigDecimal valor) {
		  
		  BigDecimal total = valor;
			
		   
		    if (cantidad >= 2) {
		    	  total = valor.multiply(DESCUENTO_MULTIPLES_DEPORTES); 
		    }
		    
		    return total;
		}
		
		
		

	@Override
		public int hashCode() {
			return Objects.hash(deportes, genero, idSocio, nombre, vitalicio);
		}


		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Socio other = (Socio) obj;
			return Objects.equals(deportes, other.deportes) && genero == other.genero && idSocio == other.idSocio
					&& Objects.equals(nombre, other.nombre) && vitalicio == other.vitalicio;
		}






	public String esVitalicio() {
		
		  
		
		return "Comun";
		
	}
}
