package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import controlador.Provincia;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = -2004716158443861219L;
	private JPanel panelProvincia;
	private final JPanel panelBotones = new JPanel();
	
	public VentanaPrincipal(Provincia provincia) { //, PanelPropiedades panelReceta, PanelProducto panelProducto, PanelBebida panelBebida, PanelVino panelVino) {
		setTitle(provincia == null ? "Provincia" : provincia.getNombre());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 566);
		panelProvincia = new JPanel();
		panelProvincia.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelProvincia);
		panelProvincia.setLayout(new MigLayout("", "[grow]", "[grow][]"));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Propiedades", new PanelPropiedades(provincia));
		tabbedPane.addTab("Impuestos", new PanelImpuestos(provincia));
		tabbedPane.setToolTipText("");
		panelProvincia.add(tabbedPane, "cell 0 0,grow");
		panelProvincia.add(panelBotones, "cell 0 1");
		
/*		JButton btnAgregar= new JButton("Agregar a Carta");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				PanelItemCartaGastronomica unPanel = (PanelItemCartaGastronomica)tabbedPane.getSelectedComponent(); 
				if (unPanel.validarCampos()) {
					provincia.agregar(unPanel.generarItemCartaGastronomica());
					unPanel.limpiarCampos();
				}
			}
		});
		
		JButton btnListar = new JButton("Listar Carta");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(tabbedPane.getTabCount()-1);
				panelCarta.mostrar(provincia.imprimirCartaGastronomica());
			}
		});
		
		JButton btnLimpiarCampos = new JButton("Limpiar campos");
		btnLimpiarCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelItemCartaGastronomica unPanel = (PanelItemCartaGastronomica)tabbedPane.getSelectedComponent(); 
				unPanel.limpiarCampos();

			}
		});
		panelBotones.add(btnAgregar);
		panelBotones.add(btnLimpiarCampos);
		panelBotones.add(btnListar);
*/		
/*	    tabbedPane.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent e) {
        		btnAgregar.setEnabled(tabbedPane.getSelectedIndex() != tabbedPane.getTabCount()-1);
        		btnLimpiarCampos.setEnabled(tabbedPane.getSelectedIndex() != tabbedPane.getTabCount()-1);
        		if (tabbedPane.getSelectedIndex() == tabbedPane.getTabCount()-1) {
        			btnListar.doClick();
        		}
	        }
	    });
*/
	}
}
