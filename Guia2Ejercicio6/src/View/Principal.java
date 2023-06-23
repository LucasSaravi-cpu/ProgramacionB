package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import Modelo.Circulo;
import Modelo.Cuadrado;
import Modelo.Elipce;
import Modelo.Figura;
import Modelo.Rectangulo;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import java.awt.Checkbox;

public class Principal extends JFrame {

	private JPanel contentPane;
	private ArrayList<Figura> listaFiguras;
	
	private final ButtonGroup buttonGroupTipoFigura = new ButtonGroup();
	private JCheckBox CheckBoxCuadrado;
	private JCheckBox CheckBoxRectangulo;
	private JButton btnNewButton;
    private JRadioButton rdbtnNewRadioButton_1Rectangulo;
    private JRadioButton rdbtnNewRadioButtonCuadrado;
   
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		
	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 691, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 10, 667, 424);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Figuras", null, panel, null);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 10, 642, 377);
		panel.add(panel_2);
		panel_2.setLayout(null);
		 
		 JComboBox Radio = new JComboBox();
		 Radio.setBounds(218, 146, 77, 21);
		 panel_2.add(Radio);
		 
		 JComboBox TamañoEjeMenor = new JComboBox();
		 TamañoEjeMenor.setBounds(392, 64, 63, 21);
		 panel_2.add(TamañoEjeMenor);
		 
		 JComboBox tamañosEjeMayor = new JComboBox();
		 tamañosEjeMayor.setBounds(215, 64, 63, 21);
		 panel_2.add(tamañosEjeMayor);
		 
		 JComboBox<Float> tamañosAltura = new JComboBox<Float>();
		 tamañosAltura.setBounds(392, 24, 63, 21);
		 panel_2.add(tamañosAltura);
		
		 rdbtnNewRadioButtonCuadrado = new JRadioButton("Cuadrado");
		rdbtnNewRadioButtonCuadrado.setBounds(16, 24, 103, 21);
		panel_2.add(rdbtnNewRadioButtonCuadrado);
		buttonGroupTipoFigura.add(rdbtnNewRadioButtonCuadrado);
		
		
		
		
		
		JComboBox<Float> tamañoslados = new JComboBox<>();		
		tamañoslados.setBounds(215, 24, 63, 21);
		panel_2.add(tamañoslados);
		
		
		for (float i = 1; i <= 100.0; i += 0.1) {
		    tamañoslados.addItem((float)i);
		}
		
		
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Lados");
		lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewJgoodiesLabel.setBounds(162, 24, 43, 21);
		panel_2.add(lblNewJgoodiesLabel);
		
	
		
		
		JRadioButton rdbtnNewRadioElipce = new JRadioButton("Elipce");
		rdbtnNewRadioElipce.setBounds(16, 64, 103, 21);
		panel_2.add(rdbtnNewRadioElipce);
		buttonGroupTipoFigura.add(rdbtnNewRadioElipce);
		rdbtnNewRadioButton_1Rectangulo = new JRadioButton("Rectangulo");
		rdbtnNewRadioButton_1Rectangulo.setBounds(16, 108, 103, 21);
		panel_2.add(rdbtnNewRadioButton_1Rectangulo);
		buttonGroupTipoFigura.add(rdbtnNewRadioButton_1Rectangulo);
		JRadioButton rdbtnNewRadioButton_2Circulo = new JRadioButton("Circulo");
		rdbtnNewRadioButton_2Circulo.setBounds(16, 146, 103, 21);
		panel_2.add(rdbtnNewRadioButton_2Circulo);
		buttonGroupTipoFigura.add(rdbtnNewRadioButton_2Circulo);
		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("Altura");
		lblNewJgoodiesLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewJgoodiesLabel_1.setBounds(324, 21, 72, 26);
		panel_2.add(lblNewJgoodiesLabel_1);
		for (float i = 1; i <= 100.0; i += 0.1) {
		    tamañosAltura.addItem((float)i);
		}
		
		ArrayList<Figura> listaFiguras = new ArrayList<>();
		
		
	
		
		btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				
				if (rdbtnNewRadioButtonCuadrado.isSelected()) {		
					
					 float numeroSeleccionado = (float) tamañoslados.getSelectedItem();
					 Cuadrado cuadrado = new Cuadrado(numeroSeleccionado, numeroSeleccionado);
					 listaFiguras.add(cuadrado);			
				}
				
				else
				{
				
						
						if(rdbtnNewRadioButton_1Rectangulo.isSelected()) {
							
							float numeroSeleccionado = (float) tamañoslados.getSelectedItem();
							float numeroSeleccionado2 = (float) tamañosAltura.getSelectedItem();
							
							Rectangulo rectangulo = new Rectangulo(numeroSeleccionado,numeroSeleccionado2);
							listaFiguras.add(rectangulo);
							
							
							
						}
					
				}
				
				
		
				
			}
			
			
			
			
		});
		
	
		btnNewButton.setBounds(16, 200, 155, 47);
		panel_2.add(btnNewButton);
		
		JLabel lblNewJgoodiesLabel_2 = DefaultComponentFactory.getInstance().createLabel("Eje mayor");
		lblNewJgoodiesLabel_2.setBounds(117, 68, 88, 13);
		panel_2.add(lblNewJgoodiesLabel_2);
		
		JLabel lblNewJgoodiesLabel_3 = DefaultComponentFactory.getInstance().createLabel("Radio");
		lblNewJgoodiesLabel_3.setBounds(117, 150, 88, 13);
		panel_2.add(lblNewJgoodiesLabel_3);
	
		
	
		
		
		
		
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Listado", null, panel_1, null);
		panel_1.setLayout(null);
		
		JCheckBox CheckBoxElipce = new JCheckBox("Elipce");
		CheckBoxElipce.setBounds(16, 108, 93, 21);
		panel_1.add(CheckBoxElipce);
		
		JCheckBox CheckBoxCirculo = new JCheckBox("circulo");
		CheckBoxCirculo.setBounds(16, 75, 93, 21);
		panel_1.add(CheckBoxCirculo);
		
		CheckBoxRectangulo = new JCheckBox("Rectangulo");
		CheckBoxRectangulo.setBounds(16, 47, 93, 21);
		panel_1.add(CheckBoxRectangulo);
		
		CheckBoxCuadrado = new JCheckBox("Cuadrado");
		CheckBoxCuadrado.setBounds(16, 24, 93, 21);
		panel_1.add(CheckBoxCuadrado);

		
	
	 
	 
	 
	 
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setEnabled(false);
		textArea.setBounds(10, 232, 642, 155);
		panel_1.add(textArea);
		
		JButton btnNewButton_1 = new JButton("Listar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				for ( Figura listafiguras : listaFiguras) {
					
				   
				
					if (CheckBoxCuadrado.isSelected()) {
						if (listafiguras instanceof Cuadrado) {
							 Cuadrado cuadrado = (Cuadrado) listafiguras;
							 
							 textArea.append(cuadrado.toString());
							 System.out.println(cuadrado.toString());
							 
						}
						
					}
					if (CheckBoxRectangulo.isSelected()) {
						
						if (listafiguras instanceof Rectangulo && !(listafiguras instanceof Cuadrado) ) {
							Rectangulo rectangulo = (Rectangulo) listafiguras;
							textArea.append(rectangulo.toString());
							 System.out.println(rectangulo.toString());
						}
					}
						
					}
					
					
				
			
			}
			
			
		});
		
		
		
		
		
	

		
		
		
		btnNewButton_1.setBounds(530, 24, 85, 21);
		panel_1.add(btnNewButton_1);
		
		
		
		
	}
}
