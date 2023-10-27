package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import controlador.Empresa;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class VentanaInternaciones extends JFrame {

	private static final long serialVersionUID = -2004716158443861219L;
	private JPanel panel;
	
	public VentanaInternaciones(Empresa empresa) {
		setTitle(empresa == null ? "Empresa" : empresa.getNombre());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 717);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(new MigLayout("", "[grow]", "[grow][]"));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Carga de Internaciones", new PanelCargaInternados(empresa));
		PanelListaInternados panelListaInternados = new PanelListaInternados();
		tabbedPane.addTab("Lista Pacientes internados", panelListaInternados);
		tabbedPane.setToolTipText("");
		panel.add(tabbedPane, "cell 0 0,grow");
		
	    tabbedPane.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent e) {
        		if (tabbedPane.getSelectedIndex() == tabbedPane.getTabCount()-1) {
    				panelListaInternados.mostrar(empresa.listarInternados());
        		}
	        }
	    });
	}
}
