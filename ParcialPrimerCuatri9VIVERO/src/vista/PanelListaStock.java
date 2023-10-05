package vista;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import controlador.Empresa;

import javax.swing.JScrollPane;
import java.awt.Component;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelListaStock extends JPanel {
	
	private JTextArea textArea;
	private Empresa empresa;

	public PanelListaStock(Empresa empresa) {
		this.empresa = empresa;
		BoxLayout mainLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
		setLayout(new MigLayout("", "[grow][][][][][]", "[][][grow]"));
		
		JButton btnCrearEspecies = new JButton("Crear Especies");
		btnCrearEspecies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				empresa.crearEspecies();
				((Component)e.getSource()).setEnabled(false);
			}
		});
		add(btnCrearEspecies, "flowx,cell 0 0");
		
		JButton btnCrearEjemplares = new JButton("Crear 10 Ejemplares");
		btnCrearEjemplares.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				empresa.crearEjemplares();
			}
		});
		add(btnCrearEjemplares, "cell 1 0");


		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "cell 0 2 6 1,grow");
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		JButton btnListarEjemplares = new JButton("Listar Ejemplares");
		btnListarEjemplares.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(empresa.listarEjemplares());
			}
		});
		add(btnListarEjemplares, "cell 2 0");
			
		
	}
	
	public void mostrar(String texto) {
		textArea.setText(texto);
	}

}
