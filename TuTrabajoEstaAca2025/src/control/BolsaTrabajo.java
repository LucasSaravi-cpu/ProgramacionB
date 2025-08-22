package control;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import modelo.Candidato;
import modelo.Empresa;
import modelo.Habilidad;
import modelo.Modalidad;
import modelo.PuestoTrabajo;



	public class BolsaTrabajo {
	    private String nombre;
	    private List<Habilidad> habilidades;
	    private List<Empresa> empresas;
		private List<PuestoTrabajo> ofertasLaborales;
		private List<Candidato> candidatos ;

	    public BolsaTrabajo(String nombre) {
	        this.nombre = nombre;
	        habilidades = new ArrayList<Habilidad>();
	        empresas = new ArrayList<Empresa>();
	        candidatos = new ArrayList<Candidato>();
	        ofertasLaborales = new ArrayList<PuestoTrabajo>();
	    }
	    
	    
	    
	    public void agregar(Candidato candidato) {
	    	 candidatos.add(candidato);
	    }
	    
	    public void agregar(PuestoTrabajo puestotrabajo) {
	    	 ofertasLaborales.add(puestotrabajo);
	    }
	    
	    

	    public void agregar(Habilidad habilidad) {
	        habilidades.add(habilidad);
	    }
	    public void agregar(Empresa empresa) {
	        empresas.add(empresa);
	    }

	    public Empresa empresaAlAzar() {
	        Random rand = new Random();
	        return empresas.get(rand.nextInt(empresas.size()));
	    }

	    public Modalidad modalidadAlAzar() {
	        Modalidad[] opciones = Modalidad.values();
	        int indice = new Random().nextInt(opciones.length);
	        return opciones[indice];
	    }

	    public List<Habilidad> habilidadesAlAzar() {
	        Random rand = new Random();
	        int cantidad = rand.nextInt(habilidades.size()) + 1; // al menos una
	        if (cantidad == habilidades.size())
	            cantidad = cantidad - 3;
	        else if (cantidad < 3)
	                cantidad = cantidad + 3;
	        List<Habilidad> copia = new ArrayList<>(habilidades);
	        Collections.shuffle(copia);
	        return copia.subList(0, cantidad);
	    }



		public String getNombre() {
			return nombre;
		}



		public void setNombre(String nombre) {
			this.nombre = nombre;
		}



		public List<Habilidad> getHabilidades() {
			return habilidades;
		}



		public void setHabilidades(List<Habilidad> habilidades) {
			this.habilidades = habilidades;
		}



		public List<Empresa> getEmpresas() {
			return empresas;
		}



		public void setEmpresas(List<Empresa> empresas) {
			this.empresas = empresas;
		}



		public List<PuestoTrabajo> getOfertasLaborales() {
			return ofertasLaborales;
		}



		public void setOfertasLaborales(List<PuestoTrabajo> ofertasLaborales) {
			this.ofertasLaborales = ofertasLaborales;
		}



		public List<Candidato> getCandidatos() {
			return candidatos;
		}



		public void setCandidatos(List<Candidato> candidatos) {
			this.candidatos = candidatos;
		}
	    
	    
		public String ListarPuestosConCandidatos(double umbralPorcentaje) {
		    StringBuilder sb = new StringBuilder();

		  /*  //  Ordenar por empresa alfabéticamente y luego por tipo
		    ofertasLaborales.sort(
		        Comparator.comparing((PuestoTrabajo p) -> p.getEmpresa().getNombre())
		                  .thenComparing(PuestoTrabajo::getTipo)
		    );*/

		    //Ordena por tipo y luego por empresa
		    ofertasLaborales.sort(
		            Comparator.comparing(PuestoTrabajo::getTipo)
		                      .thenComparing(p -> p.getEmpresa().getNombre())
		        );
		    
		    for (PuestoTrabajo p : ofertasLaborales) {
		        sb.append("--------------------------------------------------\n");
		        sb.append(p.toString()).append("\n");
		        sb.append("Empresa: ").append(p.getEmpresa().getNombre()).append("\n");
		        sb.append(p.getTipo()).append("\n");

		        // Listar candidatos con % de match >= umbral
		        sb.append(">> Candidatos que cumplen al menos ")
		          .append(umbralPorcentaje)
		          .append("%:\n");

		        for (Candidato c : candidatos) {
		            double porcentaje = c.getPorcentajeCoincidencia(p);
		            if (porcentaje >= umbralPorcentaje) {
		                sb.append("   - ")
		                  .append(c.getNombre())
		                  .append(" (")
		                  .append(String.format("%.2f", porcentaje))
		                  .append("%) habilidades: ")
		                  .append(c.getHabilidades())
		                  .append("\n");
		            }
		        }
		    }

		    return sb.toString();
		}
	
		        
		    
		
		 
	    
	    

	}	

