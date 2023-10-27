package vista;

import java.util.Iterator;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import controlador.Empresa;
import modelo.internaciones.Internacion;
import modelo.internaciones.VisitasXProfesional;
import modelo.parametricas.DiasSemana.Dia;
import modelo.personas.Paciente;
import modelo.personas.Profesional;
import net.miginfocom.swing.MigLayout;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JCheckBox;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;

public class PanelCargaInternados extends JPanel {

	private static final long serialVersionUID = -1255930017207139392L;
	protected JTextField textFieldDomicilio;
	protected JPanel panelCargaInternacion;
	public Empresa empresa;
	private JLabel lblPaciente;
	private  JComboBox<Paciente> comboBoxPaciente;
	private JLabel lblTipoInternacion;
	private JLabel lblDescripciontipointernacion;
	private JLabel lblDiagnostico;
	private JTextField textFieldDiagnostico;
	private JLabel lblPeso;
	private JSpinner spinnerPeso;
	private JLabel lblAltura;
	private JSpinner spinnerAltura;
	private JLabel lblFechaInternacion;
	private JSpinner spinnerFechaInternacion;
	private JPanel panel;
	private JComboBox<Profesional> comboBoxProfesional;
	private JLabel lblProfesional;
	private JLabel lblDiasVisitas;
	private JCheckBox chckbxLunes;
	private JCheckBox chckbxMartes;
	private JCheckBox chckbxMiercoles;
	private JCheckBox chckbxJueves;
	private JCheckBox chckbxViernes;
	private JCheckBox chckbxSabado;
	private JCheckBox chckbxDomingo;
	private JLabel lblVisitasProgramadasPor;
	private JTextArea textAreaVisitasProgramadas;
	private JButton btnAgregarPlanVisita;
	private JScrollPane scrollPane;
	private JButton btnConfirmarInternacion;
	private JButton btnCancelar;
	private JLabel lblPlanDeVisitas;
	private static List<VisitasXProfesional> listPlanVisitas = new ArrayList<VisitasXProfesional>();
	
	
	
	
	
	public PanelCargaInternados(Empresa empresa) {
		super();
		this.empresa = empresa;
		this.setLayout(new MigLayout("", "[46px,grow]", "[14px,grow][grow]"));
		
		panelCargaInternacion = new JPanel();
		this.add(panelCargaInternacion, "cell 0 0 1 2,grow");
		panelCargaInternacion.setLayout(new MigLayout("", "[::170px,grow,right][200px,grow][][][][][][]", "[][][][][][][grow][][grow]"));
		
		lblPaciente = new JLabel("Paciente:");
		lblPaciente.setFont(new Font("Tahoma", Font.BOLD, 13));
		panelCargaInternacion.add(lblPaciente, "cell 0 0,alignx trailing");
		
		comboBoxPaciente = new JComboBox<Paciente>();

		panelCargaInternacion.add(comboBoxPaciente, "cell 1 0,growx");
				
		lblTipoInternacion = new JLabel("Tipo Internacion:");
		lblTipoInternacion.setFont(new Font("Tahoma", Font.BOLD, 13));
		panelCargaInternacion.add(lblTipoInternacion, "cell 3 0");
		
		lblDescripciontipointernacion = new JLabel("DescripcionTipoInternacion");
		panelCargaInternacion.add(lblDescripciontipointernacion, "cell 4 0");
				
		lblFechaInternacion = new JLabel("Fecha internaci\u00F3n:");
		lblFechaInternacion.setFont(new Font("Tahoma", Font.BOLD, 13));
		panelCargaInternacion.add(lblFechaInternacion, "cell 0 1");
				
		spinnerFechaInternacion = new JSpinner();
		spinnerFechaInternacion.setModel(new SpinnerDateModel(new Date(System.currentTimeMillis()), null, null, Calendar.DAY_OF_YEAR));
		panelCargaInternacion.add(spinnerFechaInternacion, "cell 1 1");
		
		JLabel lblDomicilio = new JLabel("Domicilio:");
		lblDomicilio.setFont(new Font("Tahoma", Font.BOLD, 13));
		panelCargaInternacion.add(lblDomicilio, "cell 0 2");
		
		textFieldDomicilio = new JTextField();
		panelCargaInternacion.add(textFieldDomicilio, "cell 1 2,growx");
		textFieldDomicilio.setColumns(10);
		
		lblDiagnostico = new JLabel("Diagnostico:");
		lblDiagnostico.setFont(new Font("Tahoma", Font.BOLD, 13));
		panelCargaInternacion.add(lblDiagnostico, "cell 0 3,alignx trailing");
		
		textFieldDiagnostico = new JTextField();
		panelCargaInternacion.add(textFieldDiagnostico, "cell 1 3,growx");
		textFieldDiagnostico.setColumns(10);
		
		lblPeso = new JLabel("Peso (kg):");
		lblPeso.setFont(new Font("Tahoma", Font.BOLD, 13));
		panelCargaInternacion.add(lblPeso, "cell 0 4");
		
		spinnerPeso = new JSpinner();
		spinnerPeso.setModel(new SpinnerNumberModel(new Integer(60), null, null, new Integer(10)));
		panelCargaInternacion.add(spinnerPeso, "flowx,cell 1 4,growx");
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCargaInternacion.add(panel, "cell 0 6 8 1,grow");
		panel.setLayout(new MigLayout("", "[][grow][]", "[][][][grow]"));
		
		lblVisitasProgramadasPor = new JLabel("Visitas programadas por Semana");
		lblVisitasProgramadasPor.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblVisitasProgramadasPor, "cell 0 0");
		
		lblProfesional = new JLabel("Profesional");
		lblProfesional.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel.add(lblProfesional, "cell 0 1,alignx right");
		
		comboBoxProfesional = new JComboBox<Profesional>();
		panel.add(comboBoxProfesional, "cell 1 1,growx");
		
		btnAgregarPlanVisita = new JButton("Agregar al plan de visitas");
		btnAgregarPlanVisita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (validarPlanVisitas()) { 
					VisitasXProfesional planVisitas = new VisitasXProfesional((Profesional)comboBoxProfesional.getSelectedItem(), getDiasAtencionSeleccionados());
					listPlanVisitas.add(planVisitas);	
					textAreaVisitasProgramadas.append(planVisitas.toString() + "\n");
					limpiarCamposPlanVisitas();
				}
				else {
					JOptionPane.showMessageDialog((JButton)e.getSource(), "No se seleccionó ningún profesional o no se seleccionó ningún día de la semana");
					comboBoxProfesional.requestFocusInWindow();
				}
			}
			private List<Dia> getDiasAtencionSeleccionados() {
				List<Dia> listDiasSemana = new ArrayList<Dia>();
				if (chckbxLunes.isSelected()) listDiasSemana.add(Dia.LUNES);
				if (chckbxMartes.isSelected()) listDiasSemana.add(Dia.MARTES);
				if (chckbxMiercoles.isSelected()) listDiasSemana.add(Dia.MIERCOLES);
				if (chckbxJueves.isSelected()) listDiasSemana.add(Dia.JUEVES);
				if (chckbxViernes.isSelected()) listDiasSemana.add(Dia.VIERNES);
				if (chckbxSabado.isSelected()) listDiasSemana.add(Dia.SABADO);
				if (chckbxDomingo.isSelected()) listDiasSemana.add(Dia.DOMINGO);
				return listDiasSemana;
			}
			private boolean validarPlanVisitas() {
				if (comboBoxProfesional.getSelectedIndex() == -1) {
					return false;
				}
				if (chckbxDomingo.isSelected() || chckbxLunes.isSelected() || chckbxMartes.isSelected() || chckbxMiercoles.isSelected() ||
					chckbxJueves.isSelected() || chckbxViernes.isSelected() || chckbxSabado.isSelected()) {
					return true;					
				}
				else {
					return false;					
				}
			}
		});
		panel.add(btnAgregarPlanVisita, "cell 2 1 1 2,grow");
		
		lblDiasVisitas = new JLabel("D\u00EDas Visitas");
		lblDiasVisitas.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel.add(lblDiasVisitas, "cell 0 2,alignx right");
		
		chckbxLunes = new JCheckBox("Lunes");
		panel.add(chckbxLunes, "flowx,cell 1 2");
		
		chckbxMartes = new JCheckBox("Martes");
		panel.add(chckbxMartes, "cell 1 2,alignx left");
		
		chckbxMiercoles = new JCheckBox("Mi\u00E9rcoles");
		panel.add(chckbxMiercoles, "cell 1 2");
		
		chckbxJueves = new JCheckBox("Jueves");
		panel.add(chckbxJueves, "cell 1 2");
		
		chckbxViernes = new JCheckBox("Viernes");
		panel.add(chckbxViernes, "cell 1 2");
		
		chckbxSabado = new JCheckBox("S\u00E1bado");
		panel.add(chckbxSabado, "cell 1 2");
		
		chckbxDomingo = new JCheckBox("Domingo");
		panel.add(chckbxDomingo, "cell 1 2");
		
		lblPlanDeVisitas = new JLabel("Plan de Visitas");
		lblPlanDeVisitas.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel.add(lblPlanDeVisitas, "cell 0 3,alignx right,aligny top");
		
		scrollPane = new JScrollPane();
		panel.add(scrollPane, "cell 1 3 2 1,grow");
		
		textAreaVisitasProgramadas = new JTextArea();
		textAreaVisitasProgramadas.setEditable(false);
		scrollPane.setViewportView(textAreaVisitasProgramadas);
		
		btnConfirmarInternacion = new JButton("Confirmar Internaci\u00F3n");
		btnConfirmarInternacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (validarCampos()) {
					
/***************
 ****** Desarrollar aquí la funcionalidad para crear las Internaciones
 ***************/
					
					Date fechaInicio = null; //FuncionesVarias.formateaStringAFecha(lblFechaInternacion.getText());
					Date fechaFin= null; //?
					String diagnostico= textFieldDiagnostico.getText(); 
					
					String domicilio= textFieldDomicilio.getText();
					
					Internacion internacion = new Internacion (fechaInicio, fechaFin, diagnostico, domicilio, listPlanVisitas);
					empresa.agregar(internacion);

					
					
					
					
					
					
					limpiarCampos();
					JOptionPane.showMessageDialog((JButton)e.getSource(), "Internación creada correctamente!");
					comboBoxPaciente.requestFocusInWindow();
				}
			}
		});
		btnConfirmarInternacion.setFont(new Font("Tahoma", Font.BOLD, 13));
		panelCargaInternacion.add(btnConfirmarInternacion, "cell 1 7,alignx right");
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCampos();
			}
		});
		panelCargaInternacion.add(btnCancelar, "cell 2 7");
		
		lblAltura = new JLabel("      Altura (cm):");
		lblAltura.setFont(new Font("Tahoma", Font.BOLD, 13));
		panelCargaInternacion.add(lblAltura, "cell 1 4,alignx right");
		
		spinnerAltura = new JSpinner();
		spinnerAltura.setModel(new SpinnerNumberModel(new Integer(120), null, null, new Integer(5)));
		panelCargaInternacion.add(spinnerAltura, "cell 1 4,growx");

		if (empresa != null)	{	
			for (Iterator<Profesional> iterator = this.empresa.getProfesionales(); iterator.hasNext();) {
				comboBoxProfesional.addItem(iterator.next());
			}
			for (Iterator<Paciente> iterator = this.empresa.getPacientes(); iterator.hasNext();) {
				comboBoxPaciente.addItem(iterator.next());
			}
		}
		comboBoxPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBoxPaciente.getSelectedIndex() != -1) {
						Paciente paciente = (Paciente)comboBoxPaciente.getSelectedItem();
						textFieldDomicilio.setText(paciente.getDomicilio());
						lblAltura.setVisible(paciente.getEdad() < 18);
						lblPeso.setVisible(paciente.getEdad() < 18);
						spinnerAltura.setVisible(paciente.getEdad() < 18);
						spinnerPeso.setVisible(paciente.getEdad() < 18);
						lblDescripciontipointernacion.setText(paciente.getDescripcionTipoPaciente());
				}
			}
		});
		limpiarCampos();
	}
		
	public boolean validarCampos() {
		if (comboBoxPaciente.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "No ha seleccionado ningún paciente");
            comboBoxPaciente.requestFocusInWindow();
            return false;
		}
		if (textFieldDomicilio.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo Domicilio no puede estar vacío");
            textFieldDomicilio.requestFocusInWindow();
            return false;
		}
		if (textFieldDiagnostico.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo Diagnóstico no puede estar vacío");
            textFieldDiagnostico.requestFocusInWindow();
            return false;
		}
		if (spinnerFechaInternacion.getValue() == null) {
            JOptionPane.showMessageDialog(this, "No ha ingresado la fecha de internación");
            spinnerFechaInternacion.requestFocusInWindow();
            return false;
		}
		if (listPlanVisitas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No ha especificado un Plan de Visitas");
            comboBoxProfesional.requestFocusInWindow();
            return false;			
		}
		return true;
	}
	
	public void limpiarCampos() {
		limpiarCamposPlanVisitas();
		textFieldDomicilio.setText("");
		textFieldDiagnostico.setText("");
		textAreaVisitasProgramadas.setText("");
		if (comboBoxPaciente.getItemCount()>0) {
			comboBoxPaciente.setSelectedIndex(-1);
			lblDescripciontipointernacion.setText("---");
		}
		spinnerPeso.setValue(60);
		spinnerAltura.setValue(120);
		spinnerAltura.setVisible(false);
		spinnerPeso.setVisible(false);
		lblAltura.setVisible(false);
		lblPeso.setVisible(false);
		spinnerFechaInternacion.setValue(new Date(System.currentTimeMillis()));		
		listPlanVisitas = new ArrayList<VisitasXProfesional>();
	}

	private void limpiarCamposPlanVisitas() {
		chckbxLunes.setSelected(false);
		chckbxMartes.setSelected(false);
		chckbxMiercoles.setSelected(false);
		chckbxJueves.setSelected(false);
		chckbxViernes.setSelected(false);
		chckbxSabado.setSelected(false);
		chckbxDomingo.setSelected(false);
		if (comboBoxProfesional.getItemCount()>0) {
			comboBoxProfesional.setSelectedIndex(-1);
		}		
	}

	
	//Para devolver la lista 
	public static List<VisitasXProfesional> getListPlanVisitas() {
		return listPlanVisitas;
	}
	
	


}
