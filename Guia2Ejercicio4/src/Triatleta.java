
class Triatleta extends Atleta implements Nadador, Ciclista {
	    public Triatleta(String nombre, String categoria) {
	        super(nombre, categoria);
	      
	    }

	    @Override
	    public void nadar() {
	        System.out.println("El triatleta " + super.getNombre() + " está nadando.");
	    }

	    @Override
	    public void correr() {
	        System.out.println("El triatleta " + super.getNombre() + " está andando en bicicleta.");
	    }
	}


