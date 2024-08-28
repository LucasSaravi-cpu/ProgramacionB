package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controller.TankController;
import events.ChangeFlowEvent;
import events.ChangeFlowListener;
import events.FullTankListener;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/** 
 * The digital panel (VIEW) used to command the filling/emptying of the tank and to visualize its state 
 */
public class PanelTank extends JFrame implements ViewTankInterface {
	
	/**
	 * Panel that contains the UI controls of the digital panel tank
	 */
	private JPanel contentPane;
	/**
	 * Graphic visualization of the level of the tank
	 */
	private JProgressBar graphicTank;
	
	/**
	 * Digital display of the level of the tank
	 */
	private JLabel level;
	
	/**
	 * Command to reduce/increment the flow volume. 
	 */
	private JSlider flowControl;
	
	/**
	 * Listener that receive a ChangeFlowEvent when the flow is changed from the View
	 */
	private ChangeFlowListener changeFlowListener;

	
	/**
	 * Create the UI Panel Tank.
	 */
	public PanelTank() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 571, 282);
		
		JPanel graphicTankPanel = new JPanel();
		graphicTank = new JProgressBar();
		graphicTank.setOrientation(SwingConstants.VERTICAL);
		graphicTank.setMinimum(0);
		graphicTank.setMaximum(100);
		graphicTank.setValue(0);
		graphicTank.setBorder(new BevelBorder(BevelBorder.RAISED));
		graphicTank.setForeground(Color.BLUE);
		graphicTank.setSize(100, 100);
		graphicTank.setVisible(true);
		graphicTankPanel.add(graphicTank, BorderLayout.EAST);
		
		JPanel levelControlPanel = new JPanel();
		levelControlPanel.setLayout(new BorderLayout());
		level = new JLabel("000");
		level.setFont(new Font("Serif", Font.PLAIN, 48));
		level.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		levelControlPanel.add(level, BorderLayout.CENTER);
		levelControlPanel.setBorder(new EmptyBorder(0, 100, 0, 100));
		JPanel sliderControlPanel = new JPanel();
		sliderControlPanel.setLayout(new BorderLayout());
		
		JLabel sliderLabel = new JLabel("Flow control", JLabel.CENTER);
        sliderLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		flowControl = new JSlider();
		flowControl.setMinimum(-5);
		flowControl.setMaximum(5);
		flowControl.setMajorTickSpacing(5);
		flowControl.setMinorTickSpacing(1);
		flowControl.setPaintTicks(true);
		flowControl.setValue(0);
		flowControl.setBounds(5, 5, 50, 10);
		flowControl.setLabelTable(flowControl.createStandardLabels(1, -5));  
		flowControl.setPaintLabels(true);
		flowControl.setAlignmentX(Component.CENTER_ALIGNMENT);
		flowControl.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				int newFlow = ((JSlider)e.getSource()).getValue();
				changeFlowListener.listenChangeFlowEvent(new ChangeFlowEvent(newFlow));
			}			
		});
		
		sliderControlPanel.add(sliderLabel, BorderLayout.NORTH);
		sliderControlPanel.add(flowControl, BorderLayout.SOUTH);
		
		JPanel rigthPanel = new JPanel();
		rigthPanel.setLayout(new BorderLayout());
		rigthPanel.add(levelControlPanel, BorderLayout.NORTH);
		rigthPanel.add(sliderControlPanel, BorderLayout.SOUTH);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
		contentPane.setLayout(new BorderLayout());
		contentPane.add(graphicTankPanel, BorderLayout.WEST);
		contentPane.add(rigthPanel, BorderLayout.EAST);		
		setContentPane(contentPane);
		this.pack();
	}

	/**
	 * Shows the content of the Tank in the Level's digital display and in the graphical representation of the Tank
	 */
	@Override
	public void showTankLevel(Integer levelValue) {
		level.setText(String.format("%03d", levelValue));
		graphicTank.setValue(levelValue.intValue());
	}

	/**
	 * Sets the tank to the stationary mode: The tank is not receiving/releasing fluid
	 */	
	@Override
	public void closeTank() {
		flowControl.setValue(0);
	}
	
	/**
	 * Register the Controller as a listener of events generated from the View
	 */	
	@Override
	public void setChangeFlowListener(ChangeFlowListener listener) {
        changeFlowListener = listener;
	}

	@Override
	public void initialize() {
		setVisible(true);		
	}

}
