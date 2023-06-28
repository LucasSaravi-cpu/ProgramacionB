package vista;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.LineBorder;
import controlador.Congreso;
import modelo.Alumno;
import modelo.AreaTematica;
import modelo.Empresa;
import modelo.Universidad;

public class VentanaTrabajos extends JFrame {

	private static final long serialVersionUID = -2004716158443861219L;
	private Congreso congreso;
	private JPanel contentPane;
	
	//Datos generales del Trabajo
	private JTextField textTitulo;
	private JSpinner spinnerFechaExposicion;
	private JComboBox<AreaTematica> cbAreaTematica;
	private final ButtonGroup buttonGroupTipoTrabajo = new ButtonGroup();
	private JRadioButton rdbtnInvestigacion;
	private JRadioButton rdbtnEstudiantil;
	private JRadioButton rdbtnEmpresarial;
	
	//Datos Trabajo de Investigacion
	private JPanel panelInvestigacion;
	private JComboBox<Universidad> cbUniversidad;
	private JCheckBox checkPapers;
	
	//Datos Trabajo Estudiantil
	private JPanel panelEstudiantil;
	private JComboBox<Alumno> cbAlumno;
	private JCheckBox checkFinalCarrera;
	private JSpinner spinnerAnioCarrera;
	
	//Datos Trabajo Empresarial
	private JPanel panelEmpresarial;
	private JComboBox<Empresa> cbEmpresa;
	private JCheckBox checkComercial;
	private JSpinner spinnerAnioCreacion;
	
	public VentanaTrabajos(Congreso congreso) {
		this.congreso = congreso;
		setTitle(congreso.getNombre() + " - " + congreso.getLugar());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panelEstudiantil = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5)); 
		panelInvestigacion = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5)); 
		panelEmpresarial = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5)); 
		panelEstudiantil.setVisible(true);
		panelInvestigacion.setVisible(true);
		panelEmpresarial.setVisible(true);

		
		setBounds(100, 100, 1400, 600);
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new FlowLayout()); 
		JPanel panelTituloTrabajo = new JPanel(new FlowLayout());
		JLabel lblTitulo = new JLabel("Título del Trabajo:");
		panelTituloTrabajo.add(lblTitulo);
		textTitulo = new JTextField("", 30);
		panelTituloTrabajo.add(textTitulo);
		JLabel lblFechaExposicion = new JLabel("Fecha:");
		spinnerFechaExposicion = new JSpinner();
		spinnerFechaExposicion.setModel(new SpinnerDateModel(new Date(System.currentTimeMillis()), null, null, Calendar.DAY_OF_YEAR));
		lblFechaExposicion.setLabelFor(spinnerFechaExposicion);
		spinnerFechaExposicion.setBounds(MAXIMIZED_BOTH, ABORT, 30, HEIGHT);
		panelTituloTrabajo.add(lblFechaExposicion, spinnerFechaExposicion);

		northPanel.add(panelTituloTrabajo);
		northPanel.add(lblFechaExposicion);
		northPanel.add(spinnerFechaExposicion);
		
		JLabel lblAreaTematica = new JLabel("Tematica:");
		panelTituloTrabajo.add(lblAreaTematica);
		cbAreaTematica = new JComboBox<AreaTematica>();
		lblAreaTematica.setLabelFor(cbAreaTematica);
		cbAreaTematica.setName("cbAreaTematica");
		panelTituloTrabajo.add(cbAreaTematica);
		
		JPanel panelTipoTrabajo = new JPanel();
		panelTipoTrabajo.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panelTipoTrabajo.setToolTipText("Tipo de Trabajo");
		panelTipoTrabajo.setLayout(new FlowLayout());
		JLabel lblTipoDeTrabajo = new JLabel("Tipo de Trabajo:");
		panelTipoTrabajo.add(lblTipoDeTrabajo);

		rdbtnInvestigacion = new JRadioButton("Investigacion");
		rdbtnInvestigacion.setSelected(true);
		rdbtnInvestigacion.setName("rbInvestigacion");
		panelTipoTrabajo.add(rdbtnInvestigacion);
		buttonGroupTipoTrabajo.add(rdbtnInvestigacion);
		
		rdbtnEstudiantil = new JRadioButton("Estudiantil");
		rdbtnEstudiantil.setName("rbEstudiantil");
		panelTipoTrabajo.add(rdbtnEstudiantil);
		buttonGroupTipoTrabajo.add(rdbtnEstudiantil);

		rdbtnEmpresarial = new JRadioButton("Empresarial");
		rdbtnEmpresarial.setName("tbEmpresarial");
		panelTipoTrabajo.add(rdbtnEmpresarial);

		buttonGroupTipoTrabajo.add(rdbtnEmpresarial);
		buttonGroupTipoTrabajo.clearSelection();
		northPanel.add(panelTipoTrabajo);
		for (Iterator<AreaTematica> iterator = congreso.getAreasTematicas(); iterator.hasNext();) {
			cbAreaTematica.addItem(iterator.next());
		}
		getContentPane().add(northPanel, BorderLayout.NORTH); 
		
		JPanel panelCentral = new JPanel();
		panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));
		
		JLabel lblUniversidad = new JLabel("Universidad:");
		panelInvestigacion.add(lblUniversidad);	
		cbUniversidad = new JComboBox<Universidad>();
		cbUniversidad.setName("cbUniversidad");
		panelInvestigacion.add(cbUniversidad);
		checkPapers = new JCheckBox("Papers publicados");
		checkPapers.setSelected(false);
		panelInvestigacion.add(checkPapers);		
		panelCentral.add(panelInvestigacion); 


		JLabel lblAlumno = new JLabel("Alumno:");
		panelEstudiantil.add(lblAlumno);
	
		cbAlumno = new JComboBox<Alumno>();
		cbAlumno.setName("cbAlumno");
		panelEstudiantil.add(cbAlumno);	
		panelCentral.add(panelEstudiantil);
		
		checkFinalCarrera = new JCheckBox("Proyecto de Final de Carrera");
		checkFinalCarrera.setSelected(false);

		panelEstudiantil.add(checkFinalCarrera);	
		
		JLabel lblAnioCarrera = new JLabel("Año de la Carrera:");
		panelEstudiantil.add(lblAnioCarrera);	
		spinnerAnioCarrera = new JSpinner();
		spinnerAnioCarrera.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), new Integer(5), new Integer(1)));
		panelEstudiantil.add(spinnerAnioCarrera);
		lblAnioCarrera.setLabelFor(spinnerAnioCarrera);
			
		JLabel lblEmpresa = new JLabel("Empresa:");
		panelEmpresarial.add(lblEmpresa);
		
		cbEmpresa = new JComboBox<Empresa>();
		cbEmpresa.setName("cbEmpresas");
		panelEmpresarial.add(cbEmpresa);
		checkComercial = new JCheckBox("Comercializable");
		checkComercial.setSelected(false);
		panelEmpresarial.add(checkComercial);		
		JLabel lblAnioCreacion = new JLabel("Año de Creacion:");
		panelEmpresarial.add(lblAnioCreacion);	
		spinnerAnioCreacion = new JSpinner();
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		System.out.println(currentYear);
		spinnerAnioCreacion.setModel(new SpinnerNumberModel(currentYear, currentYear - 20, currentYear, 1));
		panelEmpresarial.add(spinnerAnioCreacion);
		lblAnioCreacion.setLabelFor(spinnerAnioCreacion);
				
		panelCentral.add(panelEmpresarial);

		for (Iterator<Empresa> iterator = congreso.getClientes(); iterator.hasNext();) {
			cbEmpresa.addItem(iterator.next());
		}
		for (Iterator<Alumno> iterator = congreso.getAlumnos(); iterator.hasNext();) {
			cbAlumno.addItem(iterator.next());
		}		
		for (Iterator<Universidad> iterator = congreso.getUniversidades(); iterator.hasNext();) {
			cbUniversidad.addItem(iterator.next());
		}
		getContentPane().add(panelCentral, BorderLayout.CENTER); 
		
		JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 5));
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				crearTrabajo();	
			}
		});
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				limpiarCampos();
			}
		});	
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaListado(congreso).setVisible(true);;
			}
		});	
		southPanel.add(btnConfirmar);
		southPanel.add(btnCancelar);		
		southPanel.add(btnListar);		

		getContentPane().add(southPanel, BorderLayout.SOUTH);	
		limpiarCampos();
	}
	
	private void crearTrabajo() {
      //TODO: Implementar código aquí
	}

	private void limpiarCampos() {
	  //TODO: Implementar código aquí
	}

}
