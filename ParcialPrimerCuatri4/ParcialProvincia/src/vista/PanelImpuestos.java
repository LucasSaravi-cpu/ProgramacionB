package vista;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import controlador.Provincia;
import modelo.impuestos.ImpuestoAnual;
import modelo.impuestos.Propiedad;
import modelo.provincia.parametricas.Propietario;

import javax.swing.JScrollPane;
import java.awt.Rectangle;
import java.awt.Dimension;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JSeparator;
import java.awt.Color;

public class PanelImpuestos extends JPanel {
	
	private JSpinner spinnerAnioImpuesto;
	private JLabel lblResultadoliquidacion;
	private JSpinner spinnerAnioConsulta;
	private JComboBox<Propietario> comboBoxPropietariosConsulta;
	private JTextPane textPaneMostrarImpuestos;

	public PanelImpuestos(Provincia provincia) {
		setLayout(new MigLayout("", "[][grow][][][][]", "[][][][grow]"));
		
		JLabel lblAnioImpuesto = new JLabel("A\u00F1o impuesto");
		add(lblAnioImpuesto, "flowx,cell 1 0");

		spinnerAnioImpuesto = new JSpinner();
		lblAnioImpuesto.setLabelFor(spinnerAnioImpuesto);
		spinnerAnioImpuesto.setModel(new SpinnerNumberModel(new Integer(2020), new Integer(2020), null, new Integer(1)));
		add(spinnerAnioImpuesto, "cell 1 0");
		
		
		lblResultadoliquidacion = new JLabel("lblResultadoLiquidacion");
		lblResultadoliquidacion.setHorizontalAlignment(SwingConstants.TRAILING);
		add(lblResultadoliquidacion, "cell 1 1 5 1");
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		add(separator, "cell 0 2 6 1");
		
		JPanel panel = new JPanel();
		add(panel, "cell 1 3 5 1,grow");
		panel.setLayout(new MigLayout("", "[grow][][][][][][][grow][]", "[][][grow]"));
		
		JLabel lblConsultas = new JLabel("Consulta de Impuestos liquidados");
		panel.add(lblConsultas, "cell 0 0");
		
		JLabel lblAnio = new JLabel("A\u00F1o:");
		panel.add(lblAnio, "flowx,cell 0 1");
		
	
		
		spinnerAnioConsulta = new JSpinner();
		spinnerAnioConsulta.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		panel.add(spinnerAnioConsulta, "cell 0 1,growx");
		
		JLabel lblPropietario = new JLabel("Propietario");
		panel.add(lblPropietario, "cell 1 1,alignx trailing");
		
		comboBoxPropietariosConsulta = new JComboBox<Propietario>();
		panel.add(comboBoxPropietariosConsulta, "flowx,cell 2 1 6 1,growx");
	
		if (provincia != null)	{	
			comboBoxPropietariosConsulta.addItem(null);
			for (Iterator<Propietario> iterator = provincia.getPropietarios(); iterator.hasNext();) {
				comboBoxPropietariosConsulta.addItem(iterator.next());
			}
		}
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPaneMostrarImpuestos.setText(provincia.imprimirImpuestos(((Integer)spinnerAnioConsulta.getValue()).intValue(), (Propietario)comboBoxPropietariosConsulta.getSelectedItem()));
			}
		});
		panel.add(btnConsultar, "cell 8 1");
		
		textPaneMostrarImpuestos = new JTextPane();
		JScrollPane scrollPane = new JScrollPane(textPaneMostrarImpuestos);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		panel.add(scrollPane, "cell 0 2 9 1,grow");
		
		JButton btnLiquidarImpuestoAnual = new JButton("Liquidar Impuesto Anual");
		btnLiquidarImpuestoAnual.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							int anioImpuesto = ((Integer)spinnerAnioImpuesto.getValue()).intValue();
							String resultadoLiquidacion = provincia.liquidarImpuestos(anioImpuesto);
							lblResultadoliquidacion.setText(resultadoLiquidacion);
						}			
				});
		add(btnLiquidarImpuestoAnual, "cell 1 0");

	}
	
	/* public void mostrar(String texto) {
		textArea.setText(texto);
	}
	*/

}
