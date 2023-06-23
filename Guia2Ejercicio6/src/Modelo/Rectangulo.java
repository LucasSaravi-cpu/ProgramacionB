package Modelo;
public class Rectangulo extends Figura {

 float base ,altura;
 



public Rectangulo(float base, float altura) { //Constructores de nuestros atributos
	super();
	this.base = base;
	this.altura = altura;
}


public float getBase() {
	return base;
}


public float getAltura() {
	return altura;
}


@Override
public  double getArea() {
  
	return base*altura;
	
}

@Override
public  double getPerimetro() {
	
	return base+base+altura+altura;
}

@Override
public  String getInfoAtributos() {
	
	return "Su base es igual a " +base+" y su altura es igual a " +altura;
}


@Override
public  String getTipoFigura () {
	
	return "Es un Rectangulo";
}


@Override
public String toString() {
	return "Rectangulo base " + base + ", altura " + altura + "\n";
}





 
}

	

