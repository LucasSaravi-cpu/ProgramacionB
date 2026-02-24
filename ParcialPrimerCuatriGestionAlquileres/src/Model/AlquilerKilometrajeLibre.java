package Model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AlquilerKilometrajeLibre extends Alquiler{
	
	
	 private boolean incluyeMultiplesConductores;
	    private BigDecimal porcentajeRecargoMultiplesConductores;


	    public AlquilerKilometrajeLibre(LocalDateTime desdeFecha, LocalDateTime hastaFecha, BigDecimal costoPorDia,
				int kilometrajeInicio, int kilometrajeFin, boolean devolvioConTanqueCompleto,
				BigDecimal recargoTanqueIncompleto, Cliente cliente, Automovil automovil,boolean incluyeMultiplesConductores, BigDecimal porcentajeRecargoMultiplesConductores) {
			super(desdeFecha, hastaFecha, costoPorDia, kilometrajeInicio, kilometrajeFin, devolvioConTanqueCompleto,
					recargoTanqueIncompleto, cliente, automovil);
			
			
			this.incluyeMultiplesConductores = incluyeMultiplesConductores;
			this.porcentajeRecargoMultiplesConductores = porcentajeRecargoMultiplesConductores;
		}


		@Override
	    public BigDecimal calcularRecargoExtra() {

	        if (incluyeMultiplesConductores) {

	            return getCostoPorDia()
	                    .multiply(porcentajeRecargoMultiplesConductores)
	                    .divide(BigDecimal.valueOf(100));
	        }

	        return BigDecimal.ZERO;
	    }


		@Override
		public String tipo() {
			
			return "AlquilerKilometrajeLibre";
		}
	

}
