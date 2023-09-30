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

import controller.RacerController;

public class RankingWindow {
	
	public RankingWindow(final RacerController racerController) {
		JFrame frame = new JFrame("Ranking de jugadores");       
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
		final JTextArea textArea = new JTextArea();       
		textArea.setPreferredSize(new Dimension(900, 600));   
		JButton btRanking = new JButton("Mostrar ranking");
		btRanking.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	textArea.setText(racerController.getRankingReport());
			}
	    });		
		frame.getContentPane().add(btRanking, BorderLayout.BEFORE_LINE_BEGINS);
		frame.getContentPane().add(textArea, BorderLayout.CENTER);     
		frame.pack();       
		frame.setLocationRelativeTo(null);       
		frame.setVisible(true);		
	}	
}
