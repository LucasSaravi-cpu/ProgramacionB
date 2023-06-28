package Vista;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

import Controlador.Empresa;
import Modelo.Accesorio;
import Modelo.Cliente;
import Modelo.Stand;
import Modelo.StandExterior;
import Modelo.StandInterior;

import java.awt.Color;

@SuppressWarnings("serial")
public class VentanaStands extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public VentanaStands(Empresa empresa) {
		setTitle(empresa.getNombre());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tipo de Stand:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(23,33,111,16);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();  //panel de Interior-Exterior
		panel.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel.setBounds(146, 17, 173, 50);
		contentPane.add(panel);
		panel.setLayout(null);
		
		ButtonGroup grupodebotones;
		grupodebotones=new ButtonGroup();
		
		JRadioButton rdbtnInterior = new JRadioButton("Interior");
		rdbtnInterior.setBounds(8, 9, 71, 25);
		panel.add(rdbtnInterior);
		rdbtnInterior.setSelected(true);
		
		JRadioButton rdbtnExterior = new JRadioButton("Exterior");
		rdbtnExterior.setBounds(92, 9, 73, 25);
		panel.add(rdbtnExterior);
		
		grupodebotones.add(rdbtnInterior);
		grupodebotones.add(rdbtnExterior);
		
		JLabel lblAccesorios = new JLabel("Accesorios:");
		lblAccesorios.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAccesorios.setBounds(23, 105, 111, 16);
		contentPane.add(lblAccesorios);
		
		JLabel lblClientes = new JLabel("Clientes:");
		lblClientes.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblClientes.setBounds(397, 33, 80, 16);
		contentPane.add(lblClientes);
		
		JComboBox<Cliente> cbCliente = new JComboBox<Cliente>();
		cbCliente.setBounds(475, 28, 173, 27);
		for (Iterator<Cliente> iterator = empresa.getListaClientes().iterator(); iterator.hasNext();) {
			cbCliente.addItem(iterator.next());
		}
		contentPane.add(cbCliente);
		
		DefaultListModel<Accesorio> lm = new DefaultListModel<Accesorio>();
		for (Iterator<Accesorio> iterator = empresa.getListaAccesorios().iterator(); iterator.hasNext();) {
			lm.addElement(iterator.next());
		}
		
		JList<Accesorio> list = new JList<Accesorio>();
		list.setValueIsAdjusting(true);
		list.setBounds(146, 104, 173, 130);
		list.setModel(lm);
		contentPane.add(list);
		
		JLabel lblNroStand = new JLabel("Nro Stand:");
		lblNroStand.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNroStand.setBounds(397, 105, 80, 16);
		contentPane.add(lblNroStand);
		
		JSpinner spStand = new JSpinner();
		spStand.setModel(new SpinnerNumberModel(new Integer(1), new Integer(0), null, new Integer(1)));
		spStand.setBounds(475, 102, 50, 22);
		contentPane.add(spStand);
		
		JLabel lblLuminarias = new JLabel("Luminarias:");
		lblLuminarias.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLuminarias.setBounds(570, 105, 78, 16);
		contentPane.add(lblLuminarias);
		
		JSpinner spLuces = new JSpinner();
		spLuces.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spLuces.setBounds(660, 102, 50, 22);
		contentPane.add(spLuces);
		
		JLabel spm2 = new JLabel("Superficie (m2):");
		spm2.setFont(new Font("Tahoma", Font.BOLD, 13));
		spm2.setBounds(363, 150, 115, 16);
		contentPane.add(spm2);
		
		JSpinner spSuper = new JSpinner();
		spSuper.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(5)));
		spSuper.setBounds(475, 147, 50, 22);
		contentPane.add(spSuper);
		
		JLabel lblValorm = new JLabel("Valor (m2):");
		lblValorm.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblValorm.setBounds(570, 150, 78, 16);
		contentPane.add(lblValorm);
		
		JSpinner spValor = new JSpinner();
		spValor.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(10)));
		spValor.setBounds(660, 144, 50, 22);
		contentPane.add(spValor);
		
		TextArea textArea = new TextArea();
		textArea.setBounds(10, 251, 762, 180);
		contentPane.add(textArea);
		
		JButton BotonCrear = new JButton("Crear Stand");
		BotonCrear.setBounds(363, 209, 135, 25);
		contentPane.add(BotonCrear);
		BotonCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				int NroStand = (int) spStand.getValue();
				int Superficie = (int) spSuper.getValue();
				int Valor = (int) spValor.getValue();
				Cliente cliente = (Cliente) cbCliente.getSelectedItem();
				List<Accesorio> accSelec = new ArrayList<Accesorio>();
				
				List <Accesorio> ingresados = list.getSelectedValuesList();
				for(Accesorio i: ingresados)
					accSelec.add(i);
				list.setSelectedIndex(0);
				
				if (rdbtnInterior.isSelected()) {
					int luces = (int) spLuces.getValue();
					Stand standCreadoInt = new StandInterior(NroStand, Superficie, cliente, Valor, luces);
					for (int i=0; i<accSelec.size(); i++)
						standCreadoInt.agregar(accSelec.get(i));
					empresa.agregar(standCreadoInt);
					spLuces.setValue(0);
				} else {
					Stand standCreadoExt = new StandExterior(NroStand, Superficie, cliente, Valor);
					for (int i=0; i<accSelec.size(); i++)
						standCreadoExt.agregar(accSelec.get(i));
					empresa.agregar(standCreadoExt);
				};
				JOptionPane.showMessageDialog(null, "Stand " + NroStand + cliente.getNombre() + " Creado", "Mensaje de Sistema", JOptionPane.INFORMATION_MESSAGE);
				
				spStand.setValue(0); spSuper.setValue(0); spValor.setValue(0); rdbtnInterior.setSelected(false); rdbtnExterior.setSelected(false); 
			}
		});
		
		JButton BotonListar = new JButton("Listar Stands");
		BotonListar.setBounds(540, 209, 135, 25);
		contentPane.add(BotonListar);
		BotonListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				textArea.setText("Listado de Stands: \n" + empresa.listarStands());
			}
		});
	}
}
