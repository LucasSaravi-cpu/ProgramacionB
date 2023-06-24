package init;

import java.util.ArrayList;
import java.util.List;

import controlador.Restaurant;
import modelo.carta.parametricas.TipoItem;
import modelo.carta.parametricas.Ingrediente;
import modelo.carta.parametricas.ParametrosValorizacion;
import modelo.carta.parametricas.UnidadMedida;
import vista.PanelBebida;
import vista.PanelProducto;
import vista.PanelReceta;
import vista.PanelVino;
import vista.VentanaCartaGastronomica;

public class RunRestaurant {

	public static void main(String[] args) {
		ParametrosValorizacion parametrosValorizacion = new ParametrosValorizacion((float)1.0, (float)1.10, (float)1.30);
		Restaurant restaurant = new Restaurant("Breaking Bar", parametrosValorizacion);
		
		restaurant.agregar(new TipoItem("Entradas", 1));
		restaurant.agregar(new TipoItem("Platos Principales", 2));
		restaurant.agregar(new TipoItem("Ensaladas", 3));
		restaurant.agregar(new TipoItem("Postres", 4));
		TipoItem bebidas = new TipoItem("Bebidas", 5);
		restaurant.agregar(bebidas);
		TipoItem vinos = new TipoItem("Vinos", 6);
		restaurant.agregar(vinos);
		
		UnidadMedida kilogramo = new UnidadMedida("kg");
		UnidadMedida litro = new UnidadMedida("litro");
		UnidadMedida unidad = new UnidadMedida("unidad");
		
		restaurant.agregar(new Ingrediente("Lomo", 500, kilogramo));
		restaurant.agregar(new Ingrediente("Salmon", 500, kilogramo));
		restaurant.agregar(new Ingrediente("Jamon", 100, kilogramo));
		restaurant.agregar(new Ingrediente("Queso", 100, kilogramo));
		restaurant.agregar(new Ingrediente("Arroz", 50, kilogramo));
		restaurant.agregar(new Ingrediente("Huevo", 1, unidad));
		restaurant.agregar(new Ingrediente("Crema", 100, litro));
		restaurant.agregar(new Ingrediente("Leche", 50, litro));
		restaurant.agregar(new Ingrediente("Papa", 50, kilogramo));
		restaurant.agregar(new Ingrediente("Tomate", 50, kilogramo));
		restaurant.agregar(new Ingrediente("Lechuga", 50, kilogramo));
		restaurant.agregar(new Ingrediente("Harina", 100, kilogramo));
		restaurant.agregar(new Ingrediente("Agua", 0, litro));
		
		List<TipoItem> tiposExcluidos = new ArrayList<TipoItem>();
		tiposExcluidos.add(bebidas);
		tiposExcluidos.add(vinos);
		
		PanelReceta panelReceta = new PanelReceta(restaurant, tiposExcluidos);
		PanelProducto panelProducto = new PanelProducto(restaurant, tiposExcluidos);
		PanelBebida panelBebida = new PanelBebida(restaurant, bebidas);
		PanelVino panelVino = new PanelVino(restaurant, vinos);
	
		VentanaCartaGastronomica ventana = new VentanaCartaGastronomica(restaurant, panelReceta, panelProducto, panelBebida, panelVino);
		ventana.setVisible(true);
	}

}
