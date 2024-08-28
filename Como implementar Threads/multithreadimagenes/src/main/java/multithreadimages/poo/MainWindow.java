package multithreadimages.poo;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class MainWindow extends JFrame {

	JPanel panel;
	JScrollPane scroll;
	private int imgQty;
	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setTitle("Multithreading sobre paginas web que contienen imagenes");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		panel.setLayout(new GridLayout(0, 9, 1, 1));
		scroll = new JScrollPane(panel);
		add(BorderLayout.CENTER, scroll);
		setSize(1500, 700);
		setLocationRelativeTo(null);
		setVisible(true);
		
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		this.setContentPane(scroll);
	}
	public int getImgQty() {
		return imgQty;
	}
	public void setImgQty(int imgQty) {
		this.imgQty = imgQty;
	}
	
}
