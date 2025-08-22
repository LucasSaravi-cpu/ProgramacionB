package modelo;

import java.util.List;


public abstract class PuestoTrabajo {
	
	public static final double SALARIOSMENORES= 0.05; // < 50.000
	public static final double SALARIOSENTRE = 0.03; // 50.000..100.000
	public static final double SALARIOSMAYORES = 0.015; // > 100.000


	private Empresa empresa;
	private String descripcion;
	private double salarioOfrecido;
	private int aniosEperienciaRequerida ;
	private Modalidad modalidad;
	private List<Habilidad> habilidadesRequeridas ;
	
	
	public PuestoTrabajo(Empresa empresa, String descripcion, double salarioOfrecido, int aniosEperienciaRequerida,
			Modalidad modalidad,List<Habilidad> habilidadesRequeridas) {
		super();
		this.empresa = empresa;
		this.descripcion = descripcion;
		this.salarioOfrecido = salarioOfrecido;
		this.aniosEperienciaRequerida = aniosEperienciaRequerida;
		this.modalidad = modalidad;
		this.habilidadesRequeridas = habilidadesRequeridas;
	}


	public Empresa getEmpresa() {
		return empresa;
	}


	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public double getSalarioOfrecido() {
		return salarioOfrecido;
	}


	public void setSalarioOfrecido(double salarioOfrecido) {
		this.salarioOfrecido = salarioOfrecido;
	}


	public int getAniosEperienciaRequerida() {
		return aniosEperienciaRequerida;
	}


	public void setAniosEperienciaRequerida(int aniosEperienciaRequerida) {
		this.aniosEperienciaRequerida = aniosEperienciaRequerida;
	}


	public Modalidad getModalidad() {
		return modalidad;
	}


	public void setModalidad(Modalidad modalidad) {
		this.modalidad = modalidad;
	}


	public List<Habilidad> getHabilidadesRequeridas() {
		return habilidadesRequeridas;
	}


	public void setHabilidadesRequeridas(List<Habilidad> habilidadesRequeridas) {
		this.habilidadesRequeridas = habilidadesRequeridas;
	}
	
	
	
	 public  double costoAdministrativo() {
	        double base = basePorSalario();
	        double descuento = Bonificacionesadicionales();
	        return base * (1 - descuento);
	    }

	    private double basePorSalario() {
	      
			if (salarioOfrecido < 50000)
				 return salarioOfrecido *  SALARIOSMENORES;
			else if (salarioOfrecido <= 1000000)
				 return salarioOfrecido * SALARIOSENTRE;
			else	
	             return salarioOfrecido * SALARIOSMAYORES;
	    }

	   public abstract double Bonificacionesadicionales ();


	   @Override
	   public String toString() {
	       StringBuilder sb = new StringBuilder();
	              
	       
	       sb.append(empresa)
	         .append(" - ")
	         .append(descripcion)
	         .append(" $")
	         .append(costoAdministrativo())
	         .append(" | Años de experiencia: ")
	         .append(aniosEperienciaRequerida)
	         .append(" | Modalidad: ")
	         .append(modalidad)
	         .append(" | Habilidades requeridas: ")
	         .append(habilidadesRequeridas);
	       
	       return sb.toString();
	   }
	
	   public abstract String getTipo();
	   
	   
	  

}
