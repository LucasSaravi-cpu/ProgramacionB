package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import controller.ClinicController;

public class PrescriptionsWindow {
	
	public PrescriptionsWindow(final ClinicController racerController) {
		JFrame frame = new JFrame("Prescripciones - Costos");       
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
		final JTextArea textArea = new JTextArea();       
		textArea.setPreferredSize(new Dimension(900, 600));   
		JButton button = new JButton("Mostrar costos");
		button.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	textArea.setText(racerController.costsReports());
			}
	    });		
		frame.getContentPane().add(button, BorderLayout.BEFORE_LINE_BEGINS);
		frame.getContentPane().add(textArea, BorderLayout.CENTER);     
		frame.pack();       
		frame.setLocationRelativeTo(null);       
		frame.setVisible(true);		
	}	
}
