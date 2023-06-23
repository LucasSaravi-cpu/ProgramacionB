package Modelo;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class PanelFigura extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelFigura() {
		setLayout(null);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		rdbtnNewRadioButton.setBounds(17, 76, 103, 21);
		add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("New radio button");
		rdbtnNewRadioButton_1.setBounds(17, 124, 103, 21);
		add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("New radio button");
		rdbtnNewRadioButton_2.setBounds(17, 183, 103, 21);
		add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("New radio button");
		rdbtnNewRadioButton_3.setBounds(17, 239, 103, 21);
		add(rdbtnNewRadioButton_3);

	}
}
