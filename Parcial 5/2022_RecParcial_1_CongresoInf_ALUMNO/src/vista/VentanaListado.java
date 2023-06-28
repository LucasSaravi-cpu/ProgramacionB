package vista;

import javax.swing.Box;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import controlador.Congreso;

public class VentanaListado extends JDialog {

	private static final long serialVersionUID = -7481486603940617686L;

	public VentanaListado(Congreso congreso) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(200, 200, 1200, 700);
		Box box = Box.createHorizontalBox();
		JTextArea textArea = new JTextArea(10, 10);
		box.add(textArea);
		this.add(box);
		textArea.setText(congreso.getListaInscriptos());
		setModal(true);
	}

}
