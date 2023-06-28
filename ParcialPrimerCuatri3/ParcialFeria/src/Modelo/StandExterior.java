package Modelo;


public class StandExterior extends Stand{

	public StandExterior(int nroStand, int superficie, Cliente cliente, float precioM2) {
		super(nroStand, superficie, cliente, precioM2);
	}

	@Override
	public float CostoAlquiler() {
		if (getListaAccesorios().size()>3) 
			return (float) (super.CostoAlquiler()*0.9);
		else
			return super.CostoAlquiler();
	}

	@Override
	public String toString() {
		return "StandExterior [alquiler: $" + CostoAlquiler() +", " + super.toString() + "]";
	}
	
}