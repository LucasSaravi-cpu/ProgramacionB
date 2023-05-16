
class Triatleta extends Atleta implements Nadador, Ciclista {
	    public Triatleta(String nombre, String categoria) {
	        super(nombre, categoria);
	      
	    }

	    @Override
	    public void nadar() {
	        System.out.println("El triatleta " + super.getNombre() + " est� nadando.");
	    }

	    @Override
	    public void correr() {
	        System.out.println("El triatleta " + super.getNombre() + " est� andando en bicicleta.");
	    }
	}


