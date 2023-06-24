package vista;

import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import controlador.Restaurant;
import modelo.carta.Bebida;
import modelo.carta.ItemCartaGastronomica;
import modelo.carta.parametricas.TipoItem;

public class PanelBebida extends PanelProducto {

	private static final long serialVersionUID = -8044619177065430916L;
	protected JSpinner spinnerVolumen;

	public PanelBebida(Restaurant restaurant, TipoItem tipoItemBebidas) {
		super(restaurant, null);
		comboBoxTiposItem.setSelectedItem(tipoItemBebidas);
		comboBoxTiposItem.setEnabled(false);
		
		JLabel lblVolumen = new JLabel("Volumen (en litros):");
		panelItemCartaGeneral.add(lblVolumen, "cell 0 3");
		
		spinnerVolumen = new JSpinner();
		spinnerVolumen.setModel(new SpinnerNumberModel(new Float(0), new Float(0), new Float(10000), new Float(1)));
		panelItemCartaGeneral.add(spinnerVolumen, "cell 1 3");
	}
	
	public void limpiarCampos() {
		super.limpiarCampos();
		spinnerCosto.setValue(new Float(0));
	}
	
	@Override
	public ItemCartaGastronomica generarItemCartaGastronomica() {
		ItemCartaGastronomica item = new Bebida(textFieldDescripcion.getText(), (TipoItem)comboBoxTiposItem.getSelectedItem(), (float)spinnerCosto.getValue(), (float)spinnerVolumen.getValue());
		return item;
	}

}
