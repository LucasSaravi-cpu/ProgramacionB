
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;


import java.awt.Color;

import javax.swing.JTextArea;


import java.awt.Point;


public class Windows extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Windows frame = new Windows();
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
	public Windows() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 571);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.BLACK);
		panel.setToolTipText("");
		panel.setBackground(Color.WHITE);
		panel.setBounds(21, 24, 695, 214);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 695, 214);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Verde");
		btnNewButton.setForeground(Color.GREEN);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panel.setBackground(Color.GREEN);
				

				JButton sourceButton = (JButton) e.getSource();
	               Point buttonLocation = sourceButton.getLocationOnScreen();
	              

	                int x = buttonLocation.x;
	                int y = buttonLocation.y;
					
					
					 textArea.append("Usted apreto en el boton verde en las coordenadas " +"("+x+","+y+") \n");
			}
		});
		btnNewButton.setBounds(121, 473, 98, 51);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Rojo");
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panel.setBackground(Color.RED);
				
				JButton sourceButton = (JButton) e.getSource();
	               Point buttonLocation = sourceButton.getLocationOnScreen();
	              

	                int x = buttonLocation.x;
	                int y = buttonLocation.y;
					
					
					 textArea.append("Usted apreto en el boton rojo en las coordenadas " +"("+x+","+y+") \n");
			}
		});
		btnNewButton_1.setBounds(229, 473, 98, 51);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("azul");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				panel.setBackground(Color.BLUE);
				
				JButton sourceButton = (JButton) e.getSource();
               Point buttonLocation = sourceButton.getLocationOnScreen();
              

                int x = buttonLocation.x;
                int y = buttonLocation.y;
				
				
				 textArea.append("Usted apreto en el boton Azul en las coordenadas " +"("+x+","+y+") \n");
				
				
				 
			}
			
			
			
			
			
		});
		btnNewButton_2.setForeground(Color.BLUE);
		btnNewButton_2.setBounds(337, 473, 106, 51);
		contentPane.add(btnNewButton_2);
		
		textArea = new JTextArea();
		textArea.setEnabled(false);
		textArea.setEditable(false);
		textArea.setBounds(21, 271, 695, 192);
		contentPane.add(textArea);
		
		JButton btnNewButton_3 = new JButton("Limpiar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
			}
		});
		btnNewButton_3.setBounds(453, 473, 85, 51);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("salir");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			 System.exit(0);
			}
		});
		btnNewButton_4.setBounds(548, 473, 85, 51);
		contentPane.add(btnNewButton_4);
	}
}
