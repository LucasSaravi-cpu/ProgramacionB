package Model;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;

public abstract class Alquiler {

    private LocalDateTime desdeFecha;
    private LocalDateTime hastaFecha;
    private BigDecimal costoPorDia;
    private int kilometrajeInicio;
    private int kilometrajeFin;
    private boolean devolvioConTanqueCompleto;
    private BigDecimal recargoTanqueIncompleto;

    private Cliente cliente;
    private Automovil automovil;

    public Alquiler(LocalDateTime desdeFecha,LocalDateTime hastaFecha,BigDecimal costoPorDia,int kilometrajeInicio,int kilometrajeFin,
          boolean devolvioConTanqueCompleto,BigDecimal recargoTanqueIncompleto,Cliente cliente,Automovil automovil) {

  

        this.desdeFecha = desdeFecha;
        this.hastaFecha = hastaFecha;
        this.costoPorDia = costoPorDia;
        this.kilometrajeInicio = kilometrajeInicio;
        this.kilometrajeFin = kilometrajeFin;
        this.devolvioConTanqueCompleto = devolvioConTanqueCompleto;
        this.recargoTanqueIncompleto = recargoTanqueIncompleto;
        this.cliente = cliente;
        this.automovil = automovil;
    }
    
    public abstract BigDecimal calcularRecargoExtra();
    public abstract String tipo ();
    
    public int getKilometrosRecorridos() {
        return kilometrajeFin - kilometrajeInicio;
    }
    
  
    public BigDecimal calcularCostoBase() {

        long horas = Duration.between(desdeFecha, hastaFecha).toHours();
        long dias = (horas + 23) / 24; // redondeo hacia arriba

        return costoPorDia.multiply(BigDecimal.valueOf(dias));
    }

 
    public BigDecimal calcularRecargoTanque() {
        if (!devolvioConTanqueCompleto)
            return recargoTanqueIncompleto;
        return BigDecimal.ZERO;
    }

   

   
    public BigDecimal calcularCostoTotal() {
        return calcularCostoBase()
                .add(calcularRecargoTanque())
                .add(calcularRecargoExtra());
    }

	public LocalDateTime getDesdeFecha() {
		return desdeFecha;
	}

	public void setDesdeFecha(LocalDateTime desdeFecha) {
		this.desdeFecha = desdeFecha;
	}

	public LocalDateTime getHastaFecha() {
		return hastaFecha;
	}

	public void setHastaFecha(LocalDateTime hastaFecha) {
		this.hastaFecha = hastaFecha;
	}

	public BigDecimal getCostoPorDia() {
		return costoPorDia;
	}

	public void setCostoPorDia(BigDecimal costoPorDia) {
		this.costoPorDia = costoPorDia;
	}

	public int getKilometrajeInicio() {
		return kilometrajeInicio;
	}

	public void setKilometrajeInicio(int kilometrajeInicio) {
		this.kilometrajeInicio = kilometrajeInicio;
	}

	public int getKilometrajeFin() {
		return kilometrajeFin;
	}

	public void setKilometrajeFin(int kilometrajeFin) {
		this.kilometrajeFin = kilometrajeFin;
	}

	public boolean isDevolvioConTanqueCompleto() {
		return devolvioConTanqueCompleto;
	}

	public void setDevolvioConTanqueCompleto(boolean devolvioConTanqueCompleto) {
		this.devolvioConTanqueCompleto = devolvioConTanqueCompleto;
	}

	public BigDecimal getRecargoTanqueIncompleto() {
		return recargoTanqueIncompleto;
	}

	public void setRecargoTanqueIncompleto(BigDecimal recargoTanqueIncompleto) {
		this.recargoTanqueIncompleto = recargoTanqueIncompleto;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Automovil getAutomovil() {
		return automovil;
	}

	public void setAutomovil(Automovil automovil) {
		this.automovil = automovil;
	}
    
    
    
    
    
    
}
