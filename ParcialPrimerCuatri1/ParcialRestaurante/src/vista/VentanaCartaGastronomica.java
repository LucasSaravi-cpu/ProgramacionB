package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import controlador.Restaurant;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class VentanaCartaGastronomica extends JFrame {

	private static final long serialVersionUID = -2004716158443861219L;
	private JPanel panelRestaurant;
	private final JPanel panelBotones = new JPanel();
	
	public VentanaCartaGastronomica(Restaurant restaurant, PanelReceta panelReceta, PanelProducto panelProducto, PanelBebida panelBebida, PanelVino panelVino) {
		setTitle(restaurant == null ? "Restaurant" : restaurant.getNombre());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 566);
		panelRestaurant = new JPanel();
		panelRestaurant.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelRestaurant);
		panelRestaurant.setLayout(new MigLayout("", "[grow]", "[grow][]"));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Receta", panelReceta);
		tabbedPane.addTab("Producto", panelProducto);
		tabbedPane.addTab("Bebida", panelBebida);
		tabbedPane.addTab("Vino", panelVino);
		PanelCarta panelCarta = new PanelCarta();
		tabbedPane.addTab("Carta", panelCarta);
		tabbedPane.setToolTipText("");
		panelRestaurant.add(tabbedPane, "cell 0 0,grow");
		panelRestaurant.add(panelBotones, "cell 0 1");
		
		JButton btnAgregar= new JButton("Agregar a Carta");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				PanelItemCartaGastronomica unPanel = (PanelItemCartaGastronomica)tabbedPane.getSelectedComponent(); 
				if (unPanel.validarCampos()) {
					restaurant.agregar(unPanel.generarItemCartaGastronomica());
					unPanel.limpiarCampos();
				}
			}
		});
		
		JButton btnListar = new JButton("Listar Carta");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(tabbedPane.getTabCount()-1);
				panelCarta.mostrar(restaurant.imprimirCartaGastronomica());
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
		
	    tabbedPane.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent e) {
        		btnAgregar.setEnabled(tabbedPane.getSelectedIndex() != tabbedPane.getTabCount()-1);
        		btnLimpiarCampos.setEnabled(tabbedPane.getSelectedIndex() != tabbedPane.getTabCount()-1);
        		if (tabbedPane.getSelectedIndex() == tabbedPane.getTabCount()-1) {
        			btnListar.doClick();
        		}
	        }
	    });
	}
}
