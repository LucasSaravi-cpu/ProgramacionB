package vista;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controlador.Provincia;
import modelo.impuestos.Automotor;
import modelo.impuestos.Inmueble;
import modelo.impuestos.Propiedad;
import modelo.provincia.parametricas.Propietario;

import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.awt.event.ActionEvent;

public class PanelPropiedades extends JPanel {
	private JTextField textFieldIdCatastral;
	private final ButtonGroup buttonGroupTipoPropiedad = new ButtonGroup();
	private JTextField textFieldDomicilioInmueble;
	private JTextField textFieldMarcaModelo;
	private JComboBox<Propietario> comboBoxPropietarios;
	private JSpinner spinnerAnioFabricacion;
	private JSpinner spinnerSupTerreno;
	private JSpinner spinnerSupEdificada;
	private JSpinner spinnerValFiscal;
	
	public PanelPropiedades(Provincia provincia) {
		setLayout(new MigLayout("", "[grow][grow]", "[][][][][grow][grow][grow]"));
		
		JLabel lblTipoPropiedad = new JLabel("Tipo de Propiedad");
		lblTipoPropiedad.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblTipoPropiedad, "cell 0 0,alignx right");
		
		JRadioButton rdbtnInmueble = new JRadioButton("Inmueble");
		rdbtnInmueble.setSelected(true);
		buttonGroupTipoPropiedad.add(rdbtnInmueble);
		add(rdbtnInmueble, "flowx,cell 1 0");
		
		JLabel lblIdcatastral = new JLabel("Id.Catastral");
		add(lblIdcatastral, "cell 0 1,alignx trailing");
		
		textFieldIdCatastral = new JTextField();
		lblIdcatastral.setLabelFor(textFieldIdCatastral);
		textFieldIdCatastral.setHorizontalAlignment(SwingConstants.LEFT);
		add(textFieldIdCatastral, "cell 1 1,growx");
		textFieldIdCatastral.setColumns(10);
		
		JRadioButton rdbtnAutomotor = new JRadioButton("Automotor");
		rdbtnAutomotor.setSelected(true);
		buttonGroupTipoPropiedad.add(rdbtnAutomotor);
		add(rdbtnAutomotor, "cell 1 0");
			
		JLabel lblValFiscal = new JLabel("Val. Fiscal");
		add(lblValFiscal, "cell 0 2,alignx right");
		
		spinnerValFiscal = new JSpinner();
		lblValFiscal.setLabelFor(spinnerValFiscal);
		spinnerValFiscal.setModel(new SpinnerNumberModel(new Float(50000), new Float(0), null, new Float(50000)));
		add(spinnerValFiscal, "cell 1 2,growx");
		
		JLabel lblPropietario = new JLabel("Propietario");
		add(lblPropietario, "cell 0 3,alignx trailing");
		
		comboBoxPropietarios = new JComboBox<Propietario>();
		lblPropietario.setLabelFor(comboBoxPropietarios);
		add(comboBoxPropietarios, "cell 1 3,growx");
		if (provincia != null)	{	
			for (Iterator<Propietario> iterator = provincia.getPropietarios(); iterator.hasNext();) {
				comboBoxPropietarios.addItem(iterator.next());
			}
		}	
				
		JPanel panelInmueble = new JPanel();
		add(panelInmueble, "cell 0 4 2 1,grow");
		panelInmueble.setLayout(new MigLayout("", "[][grow]", "[][][]"));
		
		JLabel lblDomicilioInmueble = new JLabel("Domicilio inmueble");
		panelInmueble.add(lblDomicilioInmueble, "cell 0 0,alignx trailing");
		
		textFieldDomicilioInmueble = new JTextField();
		lblDomicilioInmueble.setLabelFor(textFieldDomicilioInmueble);
		panelInmueble.add(textFieldDomicilioInmueble, "cell 1 0,growx");
		textFieldDomicilioInmueble.setColumns(10);
		
		JLabel lblSuperficieTerrenom = new JLabel("Superficie Terreno (m2)");
		panelInmueble.add(lblSuperficieTerrenom, "cell 0 1");
		
		spinnerSupTerreno = new JSpinner();
		lblSuperficieTerrenom.setLabelFor(spinnerSupTerreno);
		spinnerSupTerreno.setModel(new SpinnerNumberModel(new Integer(30), new Integer(0), null, new Integer(10)));
		panelInmueble.add(spinnerSupTerreno, "cell 1 1,growx");
		
		JLabel lblSuperficieEdificadam = new JLabel("Superficie edificada (m2)");
		panelInmueble.add(lblSuperficieEdificadam, "cell 0 2");
		
		spinnerSupEdificada = new JSpinner();
		lblSuperficieEdificadam.setLabelFor(spinnerSupEdificada);
		spinnerSupEdificada.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(10)));
		panelInmueble.add(spinnerSupEdificada, "cell 1 2,growx");
		
		JPanel panelAutomotor = new JPanel();
		add(panelAutomotor, "cell 0 5 2 1,grow");
		panelAutomotor.setLayout(new MigLayout("", "[][grow]", "[][]"));
		
		JLabel lblModelo = new JLabel("Marca / Modelo");
		panelAutomotor.add(lblModelo, "cell 0 0,alignx trailing");
		
		textFieldMarcaModelo = new JTextField();
		lblModelo.setLabelFor(textFieldMarcaModelo);
		panelAutomotor.add(textFieldMarcaModelo, "cell 1 0,growx");
		textFieldMarcaModelo.setColumns(10);
		
		JLabel lblAnioFabricacion = new JLabel("A\u00F1o Fabricaci\u00F3n");
		panelAutomotor.add(lblAnioFabricacion, "cell 0 1");
		
		spinnerAnioFabricacion = new JSpinner();
		spinnerAnioFabricacion.setModel(new SpinnerNumberModel(new Integer(2020), null, null, new Integer(1)));
		lblAnioFabricacion.setLabelFor(spinnerAnioFabricacion);
		panelAutomotor.add(spinnerAnioFabricacion, "cell 1 1,growx");
		
		JPanel panelButtons = new JPanel();
		add(panelButtons, "cell 0 6 2 1,grow");
		panelButtons.setLayout(new MigLayout("", "[][][][][][][][][][]", "[]"));
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Propiedad p = null;
				if ((rdbtnInmueble.isSelected()) && (camposInmuebleValidos())) {
					p = new Inmueble(textFieldIdCatastral.getText(), (Propietario)comboBoxPropietarios.getSelectedItem(), ((Float)(spinnerValFiscal.getValue())).floatValue(), 
									 textFieldDomicilioInmueble.getText(), 
									 ((Integer)(spinnerSupTerreno.getValue())).intValue(), 
									 ((Integer)(spinnerSupEdificada.getValue())).intValue());
				}
				else 
				if ((rdbtnAutomotor.isSelected()) && camposAutomotorValidos()) {
					p = new Automotor(textFieldIdCatastral.getText(), (Propietario)comboBoxPropietarios.getSelectedItem(), ((Float)(spinnerValFiscal.getValue())).floatValue(), 
							 textFieldMarcaModelo.getText(), 
							 ((Integer)(spinnerAnioFabricacion.getValue())).intValue());
				}
				if (p != null) {
					provincia.agregar(p);
					limpiarCampos();
				}
			}
		});
		panelButtons.add(btnAgregar, "cell 7 0");
					
		JButton btnLimpiarCampos = new JButton("Limpiar campos");
		btnLimpiarCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCampos();
			}
		});
		panelButtons.add(btnLimpiarCampos, "cell 9 0");
		
	    ActionListener alTipoPropiedad = new ActionListener() {
	        public void actionPerformed(ActionEvent actionEvent) {
	          JRadioButton aButton = (JRadioButton) actionEvent.getSource();
	          if (aButton.equals(rdbtnInmueble)) {
	        	  panelAutomotor.setVisible(false);
	          }
	          else {
	        	  panelAutomotor.setVisible(true);	        	  
	          }
	          panelInmueble.setVisible(!panelAutomotor.isVisible());
	        }
	    };
	    
	    rdbtnAutomotor.addActionListener(alTipoPropiedad);
	    rdbtnInmueble.addActionListener(alTipoPropiedad);
	    
	    rdbtnInmueble.doClick();
	}

	public void limpiarCampos() {
		textFieldIdCatastral.setText("");
		textFieldDomicilioInmueble.setText("");
		textFieldMarcaModelo.setText("");
		spinnerAnioFabricacion.setValue(new Integer(2000));
		spinnerSupTerreno.setValue(new Integer(30));
		spinnerSupEdificada.setValue(new Integer(0));
		spinnerValFiscal.setValue(new Integer(50000));
	}	
	private boolean camposGeneralesValidos() {
		if (textFieldIdCatastral.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo Id.Catastral no puede estar vacío");
            textFieldIdCatastral.requestFocusInWindow();
            return false;
		}
		if (comboBoxPropietarios.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Un propietario debe ser seleccionado");
            comboBoxPropietarios.requestFocusInWindow();
            return false;
		}
		return true;
	}
	
	private boolean camposInmuebleValidos() {
		if (camposGeneralesValidos()) {
			if (textFieldDomicilioInmueble.getText().isEmpty()) {
	            JOptionPane.showMessageDialog(this, "El campo Domicilio no puede estar vacío");
	            textFieldDomicilioInmueble.requestFocusInWindow();
	            return false;
			}
			return true;
		}
		return false;
	}
	
	private boolean camposAutomotorValidos() {
		if (camposGeneralesValidos()) {
			if (textFieldMarcaModelo.getText().isEmpty()) {
	            JOptionPane.showMessageDialog(this, "El campo Marca/Modelo no puede estar vacío");
	            textFieldMarcaModelo.requestFocusInWindow();
	            return false;
			}
			return true;
		}
		return false;
	}


}
