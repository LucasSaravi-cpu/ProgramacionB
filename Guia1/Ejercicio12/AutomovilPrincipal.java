
public class AutomovilPrincipal {


	public static void main(String[] args) {
	    Motor motor1 = new Motor(1800, "naftero");
	    Automovil auto1 = new Automovil("ABC123", "Lucas", motor1);

	    Motor motor2 = new Motor(2100, "diesel");
	    Automovil auto2 = new Automovil("DEF456", "Rodrigo", motor2);

	    Motor motor3 = new Motor(1400, "eléctrico");
	    Automovil auto3 = new Automovil("GHI789", "Marcos", motor3);

	    Automovil[] autos = {auto1, auto2, auto3};

	    for (Automovil auto : autos) {
	        System.out.println(auto.toString());
	    }
	}
}
