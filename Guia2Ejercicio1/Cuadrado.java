public class Cuadrado extends Rectangulo {
	
	
	public Cuadrado(float base, float altura) {
		super(base, altura);
		
	}

	public double getLado(double lado) {
		
		lado =base=altura;
		return lado;
	}
	
	
	@Override
	public  double getArea() {
	  
		return getLado(base)*getLado(altura);
		
	}

	@Override
	public  double getPerimetro() {
		
		return (getLado(base))+(getLado(altura)+getLado(base)+getLado(altura));
	}

	@Override
	public  String getInfoAtributos() {
		
		return "Su base es igual a " +base+"y su altura es igual a " +altura;
	}


	@Override
	public  String getTipoFigura () {
		
		return "Es un cuadrado";
	}

}
