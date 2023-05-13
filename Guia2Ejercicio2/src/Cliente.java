
public class Cliente extends Persona {
    private String telefonoContacto;
    private double totalAdeudado;

    public Cliente(String nombre, String fechaNacimiento, String telefonoContacto, double totalAdeudado) {
        super(nombre, fechaNacimiento);
        this.telefonoContacto = telefonoContacto;
        this.totalAdeudado = totalAdeudado;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public double getTotalAdeudado() {
        return totalAdeudado;
    }

    @Override
    public String toString() {
        return super.toString() + ", Tel�fono de contacto: " + telefonoContacto + ", Total adeudado: " + totalAdeudado;
    }
}


