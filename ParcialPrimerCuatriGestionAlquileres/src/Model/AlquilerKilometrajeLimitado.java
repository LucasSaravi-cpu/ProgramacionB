package Model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AlquilerKilometrajeLimitado extends Alquiler {
	
	   private int topeKilometraje;
	   private BigDecimal porcentajeRecargoKmExcedido;

	   


	   
	    public AlquilerKilometrajeLimitado(LocalDateTime desdeFecha, LocalDateTime hastaFecha, BigDecimal costoPorDia,
			int kilometrajeInicio, int kilometrajeFin, boolean devolvioConTanqueCompleto,
			BigDecimal recargoTanqueIncompleto, Cliente cliente, Automovil automovil,int topeKilometraje,
			BigDecimal porcentajeRecargoKmExcedido) {
		super(desdeFecha, hastaFecha, costoPorDia, kilometrajeInicio, kilometrajeFin, devolvioConTanqueCompleto,
				recargoTanqueIncompleto, cliente, automovil);
		
		this.topeKilometraje = topeKilometraje;
		this.porcentajeRecargoKmExcedido = porcentajeRecargoKmExcedido;
	
	}










		@Override
	    public BigDecimal calcularRecargoExtra() {

	        int kmsExcedidos = getKilometrosRecorridos() - topeKilometraje;

	        if (kmsExcedidos > 0) {

	            BigDecimal recargo = getCostoPorDia()
	                    .multiply(BigDecimal.valueOf(kmsExcedidos))
	                    .multiply(porcentajeRecargoKmExcedido)
	                    .divide(BigDecimal.valueOf(100));

	            return recargo;
	        }

	        return BigDecimal.ZERO;
	    }
		
		@Override
		public String tipo() {
			// TODO Auto-generated method stub
			return "AlquilerKilometrajeLimitado";
		}
		
	}


