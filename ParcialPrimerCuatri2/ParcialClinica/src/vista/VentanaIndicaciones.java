package vista;

import java.util.Date;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSpinner;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.SpinnerNumberModel;
import java.awt.Dimension;
import javax.swing.border.LineBorder;

import controlador.Clinica;
import modelo.Profesional;
import modelo.Indicacion;
import modelo.Medicamento;
import modelo.Paciente;
import modelo.PrescripcionMedicamento;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;

public class VentanaIndicaciones extends JFrame {

	private static final long serialVersionUID = -2004716158443861219L;
	private JPanel panelIndicaciones;
	private final ButtonGroup buttonGroupTipoIndicacion = new ButtonGroup();
	private JRadioButton rdbtnMedicacion;
	private JRadioButton rdbtnIndicacion;
	private JComboBox<Profesional> cbProfesionales;
	private JComboBox<Paciente> cbPacientes;
	private JComboBox<Medicamento> cbMedicamentos;
	private JPanel panelMedicacion;
	private JLabel lblCantidad;
	private JLabel lblMedicamento;
	private JSpinner spCantidad;
	private JLabel lblCada;
	private JSpinner spCadaHoras;
	private JLabel lblHoraInicio;
	private JSpinner spHoraInicio;
	
	public VentanaIndicaciones(Clinica clinica) {
		setTitle(clinica.getNombre());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 566);
		panelIndicaciones = new JPanel();
		panelIndicaciones.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelIndicaciones);
		panelIndicaciones.setLayout(new MigLayout("", "[0,grow][52.00,grow][66.00][][][]", "[][5,grow 10][][][grow]"));

		JLabel lblTipoIndicacion = new JLabel("Tipo de Indicaci\u00F3n:");
		panelIndicaciones.add(lblTipoIndicacion, "cell 0 0,alignx trailing,aligny center");

		panelMedicacion = new JPanel();

		
		JPanel panelTipoIndicacion = new JPanel();
		panelTipoIndicacion.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panelTipoIndicacion.setToolTipText("Tipo de Stand");
		panelIndicaciones.add(panelTipoIndicacion, "flowx,cell 1 0,alignx left,aligny center");
		panelTipoIndicacion.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		rdbtnIndicacion = new JRadioButton("Indicaci\u00F3n");
		rdbtnIndicacion.setSelected(true);
		rdbtnIndicacion.setName("rbIndicacion");
		panelTipoIndicacion.add(rdbtnIndicacion);
		buttonGroupTipoIndicacion.add(rdbtnIndicacion);
		
		rdbtnMedicacion = new JRadioButton("Medicacion");
		rdbtnMedicacion.setName("rbMedicacion");
		panelTipoIndicacion.add(rdbtnMedicacion);
		buttonGroupTipoIndicacion.add(rdbtnMedicacion);
		cbProfesionales = new JComboBox<Profesional>();
		cbProfesionales.setName("cbProfesionales");
		panelIndicaciones.add(cbProfesionales, "cell 3 0,growx");


		
		JLabel lblPaciente = new JLabel("Paciente:");
		lblPaciente.setHorizontalAlignment(SwingConstants.RIGHT);
		panelIndicaciones.add(lblPaciente, "cell 4 0,alignx right");
		
		cbPacientes = new JComboBox();
		cbPacientes.setMaximumRowCount(10);
		panelIndicaciones.add(cbPacientes, "cell 5 0,growx");


		
		JLabel lblIndicaciones = new JLabel("Indicaci\u00F3n:");
		lblIndicaciones.setVerticalAlignment(SwingConstants.TOP);
		panelIndicaciones.add(lblIndicaciones, "cell 0 1,alignx trailing,aligny top");
		
		JTextArea textAreaIndicacion = new JTextArea();
		textAreaIndicacion.setRows(1);
		textAreaIndicacion.setTabSize(4);
		panelIndicaciones.add(textAreaIndicacion, "cell 1 1 5 1,grow");
		
		panelMedicacion.setToolTipText("Medicacion");
		panelMedicacion.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Medicaci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelIndicaciones.add(panelMedicacion, "cell 0 2 6 1,grow");
		panelMedicacion.setLayout(new MigLayout("", "[0,grow][52.00,grow][66.00][][][][][][][]", "[]"));
		
		lblMedicamento = new JLabel("Medicamento:");
		panelMedicacion.add(lblMedicamento, "cell 0 0,alignx trailing");
		lblMedicamento.setLabelFor(cbMedicamentos);
		cbMedicamentos = new JComboBox<Medicamento>();
		panelMedicacion.add(cbMedicamentos, "cell 1 0 2 1,growx");
		cbMedicamentos.setName("cbMedicamentos");
		
		
		
		
		
		lblCantidad = new JLabel("Cantidad:");
		panelMedicacion.add(lblCantidad, "cell 3 0,alignx right");
		
		spCantidad = new JSpinner();
		panelMedicacion.add(spCantidad, "cell 4 0");
		spCantidad.setModel(new SpinnerNumberModel(new Integer(1), null, null, new Integer(1)));
		spCantidad.setName("spLuminarias");
		spCantidad.setPreferredSize(new Dimension(50, 20));
		
				
		lblCada = new JLabel("Cada (hs):");
		panelMedicacion.add(lblCada, "cell 5 0,alignx right");
		
		spCadaHoras = new JSpinner();
		panelMedicacion.add(spCadaHoras, "cell 6 0");
		spCadaHoras.setModel(new SpinnerNumberModel(1, 1, 24, 1));
		spCadaHoras.setName("spSuperficie");
		spCadaHoras.setPreferredSize(new Dimension(50, 20));
		
		lblHoraInicio = new JLabel("Hora inicio:");
		panelMedicacion.add(lblHoraInicio, "cell 8 0,alignx right");
		
		spHoraInicio = new JSpinner();
		panelMedicacion.add(spHoraInicio, "cell 9 0");
		spHoraInicio.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		spHoraInicio.setName("spValorM2");
		spHoraInicio.setPreferredSize(new Dimension(50, 20));
	
		JButton btnCrearIndicacion = new JButton("Agregar Indicacion");
		btnCrearIndicacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				  int año = 2023;
			      int mes = 6;
			      int día = 27;

			      int fechaInt = (año * 10000) + (mes * 100) + día;
			   
				
				//Si se selecciona el boton indicaciiones 
				
				if (rdbtnIndicacion.isSelected())
				{
					//Se instancian con los botones 
					Indicacion indicacion = new Indicacion ((Profesional)cbProfesionales.getSelectedItem(), (Paciente)cbPacientes.getSelectedItem(),fechaInt,textAreaIndicacion.getText());
					clinica.agregar(indicacion); //Se agrega a la lista correspondiente 
				}
				
				else {
					if (rdbtnMedicacion.isSelected()) {
						
						PrescripcionMedicamento medicacion = new PrescripcionMedicamento ((Profesional)cbProfesionales.getSelectedItem(),(Paciente)cbPacientes.getSelectedItem(),fechaInt, textAreaIndicacion.getText(), (int)spCantidad.getValue(), (int)spCadaHoras.getValue(), (int)spHoraInicio.getValue(), (Medicamento)cbMedicamentos.getSelectedItem());
						clinica.agregar(medicacion);
						
					}
				
				}
			
			
			
				
				
				
				
				
			}
				
				
			
		});
		panelIndicaciones.add(btnCrearIndicacion, "cell 0 3,alignx center");
		
		JScrollPane scrollPane = new JScrollPane();
		panelIndicaciones.add(scrollPane, "cell 0 4 6 1,grow");

		JTextArea textAreaListado = new JTextArea();
		textAreaListado.setFont(new Font("Courier New", Font.PLAIN, 12));
		scrollPane.setViewportView(textAreaListado);
		
		JButton btnListar = new JButton("Listar Indicaciones");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println(clinica.ListaIndicaciones());
				
				textAreaListado.setText(clinica.ListaIndicaciones());
				
			}
		});
		
		panelIndicaciones.add(btnListar, "cell 1 3,alignx center");
		
		JLabel lblProfesional = new JLabel("Profesional:");
		lblProfesional.setHorizontalAlignment(SwingConstants.RIGHT);
		panelIndicaciones.add(lblProfesional, "cell 2 0,alignx right");
	
		//Se listan en sus diferentes botones con un for 
	
		for (Iterator<Profesional> iterator = clinica.getProfesionales(); iterator.hasNext();) {
			cbProfesionales.addItem(iterator.next());
		}
	
		for (Iterator<Medicamento> iterator = clinica.getMedicamentos(); iterator.hasNext();) {
			cbMedicamentos.addItem(iterator.next());
			
		}for (Iterator<Paciente> iterator = clinica.getPacientes(); iterator.hasNext();) {
			cbPacientes.addItem(iterator.next());
		}
	
		
	}
	
	


		

	
}
