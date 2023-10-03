package view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.CineController;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.TextArea;
import java.awt.Font;
import java.awt.Color;
import java.awt.Button;

public class MontosWindows extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MontosWindows frame = new MontosWindows();
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
	public MontosWindows() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 701, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		TextArea textArea = new TextArea();
		textArea.setBackground(new Color(224, 255, 255));
		textArea.setBounds(0, 69, 693, 330);
		contentPane.add(textArea);
		
		JButton btnNewButton = new JButton("Mostrar Resultados");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CineController cinecontroller = new CineController();
				textArea.setText(cinecontroller.getMonto());
			}
		});
		btnNewButton.setBackground(new Color(224, 255, 255));
		btnNewButton.setFont(new Font("Sylfaen", Font.BOLD, 17));
		btnNewButton.setBounds(0, 0, 693, 76);
		contentPane.add(btnNewButton);
		
		
	}
}
