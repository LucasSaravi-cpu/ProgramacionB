public class Automovil {
    private String patente;
    private String dueño;
    private Motor motor; // composicion

    public Automovil(String patente, String dueño, Motor motor) { //Constructor
        this.patente = patente;
        this.dueño = dueño;
        this.motor = motor;
    }

    @Override
    public String toString() {
        return "Patente: " + patente + "\nDueño: " + dueño +
                "\nCilindrada del motor: " + motor.getCilindrada() + "cc" +
                "\nTipo de motor: " + motor.getTipo() + "\n";
    }
}