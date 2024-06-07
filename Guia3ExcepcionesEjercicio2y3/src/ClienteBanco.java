
public class ClienteBanco {
	
	
	    private String nombre;
	    private int PIN;
	    private double saldo;

	    public ClienteBanco(String nombre, int PIN, double saldo) {
	        this.nombre = nombre;
	        this.PIN = PIN;
	        this.saldo = saldo;
	    }

	    public void depositar(double cantidad) {
	        this.saldo += cantidad;
	    }

	    public void extraer(double cantidad) throws SaldoInsuficiente {
	        if (cantidad > saldo) {
	            throw new SaldoInsuficiente(saldo, cantidad);
	        }
	        this.saldo -= cantidad;
	    }

	    public double getSaldo() {
	        return saldo;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public int getPIN() {
	        return PIN;
	    }

	   @Override
	   public String toString() {
		return   nombre + "  saldo  " + saldo ;
	    }

	}


