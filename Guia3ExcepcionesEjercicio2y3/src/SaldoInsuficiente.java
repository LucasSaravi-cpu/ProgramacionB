class SaldoInsuficiente extends Exception {
	
    private double saldoActual;
    private double cantidadSolicitada;

    public SaldoInsuficiente(double saldoActual, double cantidadSolicitada) {
        this.saldoActual = saldoActual;
        this.cantidadSolicitada = cantidadSolicitada;
    }

    public double getSaldoActual() {
        return saldoActual;
    }

    public double getCantidadSolicitada() {
        return cantidadSolicitada;
    }
}