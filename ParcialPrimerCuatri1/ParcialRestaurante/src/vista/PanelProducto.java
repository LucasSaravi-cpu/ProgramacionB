package vista;

import java.util.List;

import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import controlador.Restaurant;
import modelo.carta.ItemCartaGastronomica;
import modelo.carta.Producto;
import modelo.carta.parametricas.TipoItem;

public class PanelProducto extends PanelItemCartaGastronomica {

	private static final long serialVersionUID = 2794483980221571170L;

	protected JSpinner spinnerCosto; 
	
	public PanelProducto(Restaurant restaurant, List<TipoItem> tiposExcluidos) {
		super(restaurant);
		if (tiposExcluidos != null) {
			for (TipoItem tipoItem: tiposExcluidos) {
				comboBoxTiposItem.removeItem(tipoItem);
			}
		}
		
		JLabel lblCosto = new JLabel("Costo:");
		panelItemCartaGeneral.add(lblCosto, "cell 0 2");
		
		spinnerCosto = new JSpinner();
		spinnerCosto.setModel(new SpinnerNumberModel(new Float(0), new Float(0), new Float(10000), new Float(1)));
		panelItemCartaGeneral.add(spinnerCosto, "cell 1 2");
	}
	
	public void limpiarCampos() {
		super.limpiarCampos();
		spinnerCosto.setValue(new Float(0));
	}

	@Override
	public ItemCartaGastronomica generarItemCartaGastronomica() {
		ItemCartaGastronomica item = new Producto(textFieldDescripcion.getText(), (TipoItem)comboBoxTiposItem.getSelectedItem(), (float)spinnerCosto.getValue());
		return item;
	}

}
