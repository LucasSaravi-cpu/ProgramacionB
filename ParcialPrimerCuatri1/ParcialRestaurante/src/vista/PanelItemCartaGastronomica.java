package vista;

import java.util.Iterator;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import controlador.Restaurant;
import modelo.carta.ItemCartaGastronomica;
import modelo.carta.parametricas.TipoItem;
import net.miginfocom.swing.MigLayout;

public abstract class PanelItemCartaGastronomica extends JPanel {

	private static final long serialVersionUID = -1255930017207139392L;
	protected JTextField textFieldDescripcion;
	protected JComboBox<TipoItem> comboBoxTiposItem;
	protected JPanel panelItemCartaGeneral;
	public Restaurant restaurant;
	
	public PanelItemCartaGastronomica(Restaurant restaurant) {
		super();
		this.restaurant = restaurant;
		this.setLayout(new MigLayout("", "[46px,grow]", "[14px,grow][grow]"));
		
		panelItemCartaGeneral = new JPanel();
		this.add(panelItemCartaGeneral, "cell 0 0 1 2,grow");
		panelItemCartaGeneral.setLayout(new MigLayout("", "[::170px,grow,right][200px][][][][][]", "[][][][][][][][][grow]"));
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		panelItemCartaGeneral.add(lblDescripcion, "cell 0 0");

		textFieldDescripcion = new JTextField();
		panelItemCartaGeneral.add(textFieldDescripcion, "cell 1 0 5 1,growx");
		textFieldDescripcion.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo:");
		panelItemCartaGeneral.add(lblTipo, "cell 0 1");
		
		comboBoxTiposItem = new JComboBox<TipoItem>();
		panelItemCartaGeneral.add(comboBoxTiposItem, "cell 1 1,growx");
		if (restaurant != null)	{	
			for (Iterator<TipoItem> iterator = this.restaurant.getTiposItem(); iterator.hasNext();) {
				comboBoxTiposItem.addItem(iterator.next());
			}
		}
	}
	
	public abstract ItemCartaGastronomica generarItemCartaGastronomica();
	
	public boolean validarCampos() {
		if (textFieldDescripcion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo Descripcion no puede estar vacío");
            textFieldDescripcion.requestFocusInWindow();
            return false;
		}
		return true;
	}


	
	public void limpiarCampos() {
		textFieldDescripcion.setText("");
		if (comboBoxTiposItem.getItemCount()>0) {
			comboBoxTiposItem.setSelectedIndex(0);
		}
	}

}
