import java.awt.FlowLayout;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.JTextField;

public class CounterWindow extends JFrame {

	JPanel contentPane;
	FlowLayout layout;
	JTextArea textArea;
	/**
	 * Create the frame.
	 */
	public CounterWindow(String title) {
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 605, 610);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		layout = new FlowLayout();
		contentPane.setLayout(layout);
		setContentPane(contentPane);
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setColumns(35);
		textArea.setRows(30);
		JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(5,10, 620, 630);
		scroll.setViewportView(textArea);
		contentPane.add(scroll);
		
	}
}
