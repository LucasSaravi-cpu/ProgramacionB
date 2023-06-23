
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
		btnNewButton.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
		
			}
			
			//es un evento que se activa cuando se presiona uno de los botones del mouse
			/*Obtener la posición del mouse: Puedes obtener las coordenadas x e y del puntero del mouse
			 Cambiar el estado de un componente: Puedes cambiar el estado visual o funcional de un componente cuando se detecta el evento "mousePressed"
		   Iniciar una interacción o acción: Puedes iniciar una interacción o una acción específica en respuesta al evento "mousePressed". 
		   Por ejemplo, abrir un menú desplegable, arrastrar y soltar un elemento, iniciar una operación de dibujo, entre otras.*/

			@Override
			public void mousePressed(MouseEvent e) {
				panel.setBackground(Color.GREEN);
				
				
				int clicks = e.getButton();
				
                int x = e.getX();
                int y = e.getY();
                
                
                if (clicks == MouseEvent.BUTTON1) {
                
                textArea.append("Usted apreto en el click izquierdo en el boton verde en las coordenadas " +"("+x+","+y+") \n");
                } 
                else if (clicks == MouseEvent.BUTTON3) {
                	   textArea.append("Usted apreto en el click derecho en el boton verde en las coordenadas " +"("+x+","+y+") \n");
                }
                
				
			}
            
			// es un evento que se activa cuando el botón del mouse se suelta después de haber sido presionado. 
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
				
			}
            
			// se refiere a un evento que se activa cuando el puntero del mouse ingresa a un componente
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			// Se activa cuando el puntero del mouse sale de un componente o área específica en una interfaz gráfica de usuario.
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		btnNewButton.setBounds(121, 473, 98, 51);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Rojo");
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.addMouseListener(new MouseListener() {
			
				
			
				
				
					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
						panel.setBackground(Color.RED);
						
						
						
						int clicks = e.getButton();
						
		                int x = e.getX();
		                int y = e.getY();
		                
		                
		                if (clicks == MouseEvent.BUTTON1) {
		                
		                textArea.append("Usted apreto en el click derecho en el boton rojo en las coordenadas " +"("+x+","+y+") \n");
		                } 
		                else if (clicks == MouseEvent.BUTTON3) {
		                	   textArea.append("Usted apreto en el click izquierdo en el boton rojo en las coordenadas " +"("+x+","+y+") \n");
		                }
						
					}
					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					
					
			
		});
		btnNewButton_1.setBounds(229, 473, 98, 51);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("azul");
		btnNewButton_2.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
				panel.setBackground(Color.BLUE);
				
				int clicks = e.getButton();
				
                int x = e.getX();
                int y = e.getY();
                
                
                if (clicks == MouseEvent.BUTTON1) {
                
                textArea.append("Usted apreto en el click izquierdo en el boton azul en las coordenadas " +"("+x+","+y+") \n");
                } 
                else if (clicks == MouseEvent.BUTTON3) {
                	   textArea.append("Usted apreto en el click  derecho en el boton azul en las coordenadas " +"("+x+","+y+") \n");
                }
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
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
		btnNewButton_4.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
				  int x = e.getX();
	              int y = e.getY();
				
	              textArea.append("Usted eligio salir del panel en las coordenadas " +"("+x+","+y+") \n");
	             
	             
	             int opcion= JOptionPane.showConfirmDialog(null, "¿Deseas salir del programa?", "Confirmación", JOptionPane.YES_NO_OPTION);
	              
	              if (opcion == JOptionPane.YES_OPTION) {
	                  System.exit(0);
	              }
			     
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
							
			 
			
		});
		btnNewButton_4.setBounds(548, 473, 85, 51);
		contentPane.add(btnNewButton_4);
	}
}
