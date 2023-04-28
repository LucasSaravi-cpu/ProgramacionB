public class Automovil {
    private String patente;
    private String due�o;
    private Motor motor; // composicion

    public Automovil(String patente, String due�o, Motor motor) { //Constructor
        this.patente = patente;
        this.due�o = due�o;
        this.motor = motor;
    }

    @Override
    public String toString() {
        return "Patente: " + patente + "\nDue�o: " + due�o +
                "\nCilindrada del motor: " + motor.getCilindrada() + "cc" +
                "\nTipo de motor: " + motor.getTipo() + "\n";
    }
}