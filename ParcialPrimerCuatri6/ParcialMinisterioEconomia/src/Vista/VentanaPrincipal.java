package Vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import Controlador.MinisterioEconomia;
import Modelo.Automovil;




public class VentanaPrincipal extends JFrame {
	
	
		
		
			  public VentanaPrincipal(MinisterioEconomia ministerio) {
			        JFrame frame = new JFrame("Listado de autos");
			        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			        
			     
			        final JTextArea textArea = new JTextArea();
			        textArea.setPreferredSize(new Dimension(900, 600));
			        
			        JPanel buttonPanel = new JPanel();
			        JButton btnCombustion = new JButton("Mostrar Automóviles de Combustión");
			        JButton btnElectrico = new JButton("Mostrar Automóviles Eléctricos");
			        JButton btnTodos = new JButton("Mostrar Todos");

			        // Acción para mostrar autos de combustion
			        btnCombustion.addActionListener(new ActionListener() {
			            public void actionPerformed(ActionEvent e) {
			            	  List<Automovil> autosCombustion = ministerio.getAutomoviles().stream()
			                          .filter(auto -> "Combustion".equals(auto.getTipo())) 
			                          .toList();
			                  textArea.setText(ministerio.Listar(autosCombustion));
			            }
			        });

			        // Acción para mostrar autos eléctricos
			        btnElectrico.addActionListener(new ActionListener() {
			            public void actionPerformed(ActionEvent e) {
			            	
			            	  List<Automovil> autosElectricos = ministerio.getAutomoviles().stream()
			                          .filter(auto -> "Electrico".equals(auto.getTipo())) 
			                          .toList();
			                  textArea.setText(ministerio.Listar(autosElectricos));
			            
			            }
			        });

			        // Acción para mostrar todos los autos
			        btnTodos.addActionListener(new ActionListener() {
			            public void actionPerformed(ActionEvent e) {
			              
			            	 textArea.setText(ministerio.Listar(ministerio.getAutomoviles()));
			            	
			            }
			        });

			     
			        buttonPanel.add(btnCombustion);
			        buttonPanel.add(btnElectrico);
			        buttonPanel.add(btnTodos);

			   
			        frame.getContentPane().add(buttonPanel, BorderLayout.NORTH); 
			        frame.getContentPane().add(textArea, BorderLayout.CENTER);   
			        frame.pack();
			        frame.setLocationRelativeTo(null);
			      
			        frame.setVisible(true);
		
	}

		
}
