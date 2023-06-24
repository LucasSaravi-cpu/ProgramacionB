package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;

import controlador.Restaurant;
import modelo.carta.CantidadXIngrediente;
import modelo.carta.ItemCartaGastronomica;
import modelo.carta.Receta;
import modelo.carta.parametricas.TipoItem;
import modelo.carta.parametricas.Ingrediente;

public class PanelReceta extends PanelItemCartaGastronomica {

	private static final long serialVersionUID = -8434267207650265615L;
	private JSpinner spinnerTiempoPreparacion;
	private JComboBox<Ingrediente> comboBoxIngredientes;
	private JSpinner spinnerCantidad;
	private List<CantidadXIngrediente> ingredientesSeleccionados;
	private JTextArea textAreaIngredientes;
	
	public PanelReceta(Restaurant restaurant, List<TipoItem> tiposExcluidos) {
		super(restaurant);
		if (tiposExcluidos != null) {
			for (TipoItem tipoItem: tiposExcluidos) {
				comboBoxTiposItem.removeItem(tipoItem);
			}
		}
		
		JLabel lblTiempoPreparacinmin = new JLabel("Tiempo Preparaci\u00F3n (min):");
		panelItemCartaGeneral.add(lblTiempoPreparacinmin, "cell 0 2");
		
		spinnerTiempoPreparacion = new JSpinner();
		spinnerTiempoPreparacion.setModel(new SpinnerNumberModel(0, 0, 360, 10));
		panelItemCartaGeneral.add(spinnerTiempoPreparacion, "cell 1 2");
		
		JLabel lblIngrediente = new JLabel("Ingrediente:");
		panelItemCartaGeneral.add(lblIngrediente, "cell 0 4");
		
		comboBoxIngredientes = new JComboBox<Ingrediente>();
		panelItemCartaGeneral.add(comboBoxIngredientes, "flowx,cell 1 4,growx");
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		panelItemCartaGeneral.add(lblCantidad, "cell 2 4,alignx left");
		
		spinnerCantidad = new JSpinner();
		spinnerCantidad.setModel(new SpinnerNumberModel(new Float(0), new Float(0), new Float(1000), new Float(1)));		
		panelItemCartaGeneral.add(spinnerCantidad, "cell 3 4,growx");
		
		JButton btnAgregarAReceta = new JButton("Agregar a receta");
		btnAgregarAReceta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((float)spinnerCantidad.getValue() > 0) {
					CantidadXIngrediente ingredienteXCantidad = new CantidadXIngrediente((Ingrediente)comboBoxIngredientes.getSelectedItem(), (float)spinnerCantidad.getValue());
					textAreaIngredientes.append(ingredienteXCantidad.toString() + "\n");
					ingredientesSeleccionados.add(ingredienteXCantidad);
					spinnerCantidad.setValue(new Integer(0));
				}
			}
		});
		panelItemCartaGeneral.add(btnAgregarAReceta, "cell 6 4");
		textAreaIngredientes = new JTextArea();
		textAreaIngredientes.setRows(5);
		textAreaIngredientes.setColumns(50);
		panelItemCartaGeneral.add(textAreaIngredientes, "cell 1 6 5 1,alignx left,growy");
		ingredientesSeleccionados = new ArrayList<CantidadXIngrediente>();

	    for (Iterator<Ingrediente> iterator = this.restaurant.getIngredientes(); iterator.hasNext();) {
			comboBoxIngredientes.addItem(iterator.next());
		}
	}
	
	public void limpiarCampos() {
		super.limpiarCampos();
		spinnerTiempoPreparacion.setValue(new Integer(0));
		textAreaIngredientes.setText("");
		spinnerCantidad.setValue(new Integer(0));
		ingredientesSeleccionados = new ArrayList<CantidadXIngrediente>();
	}
		
	public ItemCartaGastronomica generarItemCartaGastronomica() {		
		ItemCartaGastronomica item = new Receta(textFieldDescripcion.getText(), 
												(TipoItem)comboBoxTiposItem.getSelectedItem(),
												(int)spinnerTiempoPreparacion.getValue(),
												ingredientesSeleccionados);
		return item;
	}

}
