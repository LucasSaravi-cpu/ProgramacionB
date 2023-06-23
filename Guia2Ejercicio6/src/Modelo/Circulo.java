package Modelo;

public class Circulo extends Elipce {



	public Circulo(float SemiEjeMayor, float SemiEjeMenor) {
		super(SemiEjeMayor, SemiEjeMenor);
		
	}
	
	public float getRadio(float radio) {
		
	 radio=SemiEjeMayor=SemiEjeMenor;
	 
		return radio ;
	}

	
	@Override
	public  double getArea() {
	  
		return Math.PI*(getRadio(SemiEjeMayor)*getRadio(SemiEjeMayor));
		
	}

	@Override
	public  double getPerimetro() {
		
		return Math.PI*getRadio(SemiEjeMayor);
	}

	@Override
	public  String getInfoAtributos() {
		
		return "Su radio es " + getRadio(SemiEjeMayor);
	}


	@Override
	public  String getTipoFigura () {
		
		return "Es un Circulo";
	}
	 
	
}