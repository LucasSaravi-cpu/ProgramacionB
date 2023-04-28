import java.util.Scanner;

import javax.swing.JOptionPane;

/* Definir la clase ClienteBanco con tres datos miembro: nombre, PIN, saldo. Implementar 
funciones para mantener los atributos, depositar y extraer dinero, y mostrar el estado de la 
cuenta. Para operar, el cliente debe ingresar un número, y éste debe coincidir con el PIN 
particular*/

public class ClienteBanco {
	
    private String nombre; // datos miembro
    private int pin;
    private double saldo;

    public ClienteBanco(String nombre, int pin, double saldo) {  // Constructor 
    	
        this.nombre = nombre;
        this.pin = pin;
        this.saldo = saldo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void depositar(double monto) {
        saldo += monto;
    }

    public void extraer(double monto) {
        saldo -= monto;
    }

    public void mostrarEstadoCuenta(int ingresadoPIN) {
        if (ingresadoPIN == pin) {
            System.out.println("Nombre del cliente: " + nombre);
            System.out.println("Saldo disponible: " + saldo);
        } else {
            System.out.println("PIN incorrecto. Acceso denegado.");
        }
    }
}