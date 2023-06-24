package vista;

import javax.swing.JLabel;
import javax.swing.JTextField;
import controlador.Restaurant;
import modelo.carta.ItemCartaGastronomica;
import modelo.carta.Vino;
import modelo.carta.parametricas.TipoItem;

public class PanelVino extends PanelBebida {
	
	private static final long serialVersionUID = -878569591297041506L;
	protected JTextField textFieldVarietal;
	protected JTextField textFieldProcedencia;

	public PanelVino(Restaurant restaurant, TipoItem vinos) {
		super(restaurant, vinos); 
		JLabel lblVarietal = new JLabel("Varietal:");
		panelItemCartaGeneral.add(lblVarietal, "cell 0 4");
		
		textFieldVarietal = new JTextField();
		panelItemCartaGeneral.add(textFieldVarietal, "cell 1 4 5 1, growx");
		textFieldVarietal.setColumns(10);
		
		JLabel lblProcedencia = new JLabel("Procedencia:");
		panelItemCartaGeneral.add(lblProcedencia, "cell 0 5");
		
		textFieldProcedencia = new JTextField();
		panelItemCartaGeneral.add(textFieldProcedencia, "cell 1 5 5 1, growx");
		textFieldProcedencia.setColumns(10);
	}

	public void limpiarCampos() {
		super.limpiarCampos();
		textFieldVarietal.setText("");
		textFieldProcedencia.setText("");
	}
	
	@Override
	public ItemCartaGastronomica generarItemCartaGastronomica() {
		ItemCartaGastronomica item = new Vino(textFieldDescripcion.getText(), (TipoItem)comboBoxTiposItem.getSelectedItem(), (float)spinnerCosto.getValue(), 
												(float)spinnerVolumen.getValue(), textFieldVarietal.getText(), textFieldProcedencia.getText());
		return item;
	}

}
