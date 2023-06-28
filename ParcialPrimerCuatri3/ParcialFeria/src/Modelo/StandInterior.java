package Modelo;


public class StandInterior extends Stand{
	private int CantLuminarias;

	public StandInterior(int nroStand, int superficie, Cliente cliente, float precioM2, int cantLuminarias) {
		super(nroStand, superficie, cliente, precioM2);
		CantLuminarias = cantLuminarias;
	}

	public int getCantLuminarias() {
		return CantLuminarias;
	}

	public void setCantLuminarias(int cantLuminarias) {
		CantLuminarias = cantLuminarias;
	}
	
	public float CostoAlquiler() {
		return 50*CantLuminarias+super.CostoAlquiler();
	}

	public String toString() {
		return "StandInterior [alquiler: $" + CostoAlquiler() + ", CantLuminarias=" + CantLuminarias + ", " + super.toString() + "]";
	}
}