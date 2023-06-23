package Modelo;
public class Elipce extends Figura {

	float SemiEjeMayor,SemiEjeMenor;
	
	
	

	public Elipce(float semiEjeMayor, float semiEjeMenor) {
		super();
		this.SemiEjeMayor = semiEjeMayor;
		this.SemiEjeMenor = semiEjeMenor;
	}
	

	public float getSemiEjeMayor() {
		return SemiEjeMayor;
	}

	public float getSemiEjeMenor() {
		return SemiEjeMenor;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return Math.PI*SemiEjeMenor*SemiEjeMayor;
	}

	@Override
	public double getPerimetro() {
		// TODO Auto-generated method stub
		return Math.PI*(SemiEjeMenor+SemiEjeMayor);
	}

	@Override
	public String getInfoAtributos() {
		// TODO Auto-generated method stub
		return " Su semi Eje menor es " +SemiEjeMenor +"Su semi eje mayor "+SemiEjeMayor;
	}

	@Override
	public String getTipoFigura() {
		// TODO2 Auto-generated method stub
		return "Es una elipce";
	}
	
	

}
