package vista;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollPane;
import java.awt.Rectangle;
import java.awt.Dimension;

public class PanelCarta extends JPanel {
	
	private JTextArea textArea;

	public PanelCarta() {
		
		textArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setSize(new Dimension(780, 780));
		scrollPane.setBounds(new Rectangle(0, 0, 780, 780));
		scrollPane.setBounds(0,0,780,780);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		this.add(scrollPane);
	}
	
	public void mostrar(String texto) {
		textArea.setText(texto);
	}

}
