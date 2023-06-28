package Modelo;
import java.util.ArrayList;
import java.util.List;

public class Stand {

	private int nroStand;
	private int superficie;
	private Cliente cliente;
	private float precioM2;
	private List<Accesorio> ListaAccesorios;
	
	public Stand(int nroStand, int superficie, Cliente cliente, float precioM2) {
		this.nroStand = nroStand;
		this.superficie = superficie;
		this.cliente = cliente;
		this.precioM2 = precioM2;
		ListaAccesorios = new ArrayList<Accesorio>();
	}
	
	public void agregar(Accesorio accesorio) {
		ListaAccesorios.add(accesorio);
	}

	public int getNroStand() {
		return nroStand;
	}

	public void setNroStand(int nroStand) {
		this.nroStand = nroStand;
	}

	public int getSuperficie() {
		return superficie;
	}

	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public float getPrecioM2() {
		return precioM2;
	}

	public void setPrecioM2(float precioM2) {
		this.precioM2 = precioM2;
	}

	public List<Accesorio> getListaAccesorios() {
		return ListaAccesorios;
	}

	public void setListaAccesorios(List<Accesorio> listaAccesorios) {
		ListaAccesorios = listaAccesorios;
	}
	
	public float CostoAlquiler() {
		float alquiler=0;
		alquiler = superficie*precioM2;
		for (Accesorio x:ListaAccesorios) {
			alquiler= alquiler+x.getValorAlquiler();
		}
		return alquiler;
	}

	@Override
	public String toString() {
		return "nroStand:" + nroStand + ", superficie:" + superficie + "m2, cliente:" + cliente + ", precioM2: $" + precioM2 + ", ListaAccesorios:" + ListaAccesorios;
	}
	
}
