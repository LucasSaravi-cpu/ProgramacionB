package Modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class Alumno {
	
	private String nombre;
	private List<Evaluacion> evaluaciones;
	
	 public Alumno(String nombre) {
	        this.nombre = nombre;
	        this.evaluaciones = new ArrayList<>();
	    }
	
	
	public abstract String Condicion();
	
	public abstract String gettipo();
	
	public String getNombre() {
        return nombre;
    }

    public List<Evaluacion> getEvaluaciones() {
        return evaluaciones;
    }
    
    
    public void agregarEvaluacion(Evaluacion e) {
        evaluaciones.add(e);
    }
    
    public void validarEvaluaciones() throws EvaluacionesIncompletasException {
        if (evaluaciones.size() != 3) {
            throw new EvaluacionesIncompletasException(
                    "El alumno " + nombre + " no tiene 3 evaluaciones.");
        }
    }

    
   //Se calcula el promedio si el contador es igual a 0 . 
    
    public double calcularPromedio() {
        double suma = 0;
        int contador = 0;

        for (Evaluacion e : evaluaciones) {
            if (!e.isAusente()) {
                suma += e.getNota();
                contador++;
            }
        }

        return contador == 0 ? 0 : suma / contador;
    }
    
    //Se verifica si tiene algun ausente en las evaluaciones 

    public boolean tieneAusente() {
        for (Evaluacion e : evaluaciones) {
            if (e.isAusente()) {
                return true;
            }
        }
        return false;
    }

    
    //Se verifica si tiene nota menor a 4
    
    public boolean tieneNotaMenorA4() {
        for (Evaluacion e : evaluaciones) {
            if (!e.isAusente() && e.getNota() < 4) {
                return true;
            }
        }
        return false;
    }


	@Override
	public String toString() {
		return  nombre + "("+ gettipo() +")";
	}


	
    
    
    
    

}
