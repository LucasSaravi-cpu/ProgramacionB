package view;

import DAO.SociosDAO;
import DAO.DeportesDAO;
import model.Deporte;
import model.Socio;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.sql.SQLException;

public class SociosForm extends ABMBaseForm {

    private JTextField nombreField, idSocioField;

    private JRadioButton masculinoRB;
    private JRadioButton femeninoRB;
    private ButtonGroup generoBG;
    private JCheckBox vitalicioCheckBox;
    private JPanel deportesPanel;

    private SociosDAO sociosDAO;
    private DeportesDAO deportesDAO;

    public SociosForm(String titulo, SociosDAO sociosDAO, DeportesDAO deportesDAO) {
        super(titulo);

        this.sociosDAO = sociosDAO;
        this.deportesDAO = deportesDAO;

        JLabel idSocioLabel = new JLabel("Identificador:");
        idSocioField = new JTextField(20);
        idSocioField.setEnabled(false);

        JLabel nombreLabel = new JLabel("Nombre:");
        nombreField = new JTextField(20);

        JLabel generoLabel = new JLabel("Género:");

        masculinoRB = new JRadioButton("Masculino");
        femeninoRB = new JRadioButton("Femenino");

        generoBG = new ButtonGroup();
        generoBG.add(masculinoRB);
        generoBG.add(femeninoRB);
        masculinoRB.setSelected(false);
        femeninoRB.setSelected(false);

        vitalicioCheckBox = new JCheckBox("Vitalicio:");
        vitalicioCheckBox.setSelected(false);
        vitalicioCheckBox.setHorizontalTextPosition(SwingConstants.LEFT);

        JPanel verticalPanel = new JPanel();
        verticalPanel.setLayout((new BoxLayout(verticalPanel, BoxLayout.Y_AXIS)));
        JPanel horizontalPanel = new JPanel(new GridLayout());
        horizontalPanel.add(idSocioLabel);
        horizontalPanel.add(idSocioField);
        verticalPanel.add(horizontalPanel);

        horizontalPanel = new JPanel(new GridLayout());
        horizontalPanel.add(nombreLabel);
        horizontalPanel.add(nombreField);
        verticalPanel.add(horizontalPanel);

        horizontalPanel = new JPanel(new GridLayout());
        horizontalPanel = new JPanel(new GridLayout());
        horizontalPanel.add(generoLabel);

        horizontalPanel = new JPanel(new GridLayout());
        horizontalPanel.add(generoLabel);
        horizontalPanel.add(masculinoRB);
        horizontalPanel.add(femeninoRB);
        verticalPanel.add(horizontalPanel);

        horizontalPanel = new JPanel(new GridLayout());
        horizontalPanel.add(vitalicioCheckBox);
        verticalPanel.add(horizontalPanel);

        deportesPanel = new JPanel(new GridLayout(0, 3));
        deportesPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Deportes", TitledBorder.LEFT, TitledBorder.TOP));
        try {
            List<Deporte> deportesList = deportesDAO.getListaDeportes();
            for (Deporte deporte: deportesList) {
                JCheckBox cb = new JCheckBox(deporte.getDescripcion());
                cb.setSelected(false);
                cb.putClientProperty("deporte", deporte); // Asocia el objeto Deporte al JCheckBox
                deportesPanel.add(cb);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        verticalPanel.add(deportesPanel);

        fieldsPanel.add(verticalPanel);
        inputPanel.add(fieldsPanel, BorderLayout.CENTER);

        // Definir las columnas de la tabla
        tablaModel.addColumn("ID");
        tablaModel.addColumn("Nombre");
        tablaModel.addColumn("Genero");
        tablaModel.addColumn("Vitalicio");

        // Configurar selección de fila en la tabla
        tabla.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = tabla.getSelectedRow();
                    if (selectedRow != -1) {
                        desmarcaDeportes();
                        // Mostrar datos de la fila seleccionada en los campos de texto
                        Long idSocio = (Long)(tabla.getValueAt(selectedRow, 0));
                        idSocioField.setText(idSocio.toString());
                        String nombre = (String) tabla.getValueAt(selectedRow, 1);
                        char genero = (char) tabla.getValueAt(selectedRow, 2);
                        boolean vitalicio = (boolean) tabla.getValueAt(selectedRow, 3);
                        try {
                            List<Deporte> listaDeportesSocio = sociosDAO.getDeportesSocio(idSocio);
                            setDeportesSocio(listaDeportesSocio);
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null, "Error al cargar deportes del socio: " + ex.getMessage(),
                                    "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        nombreField.setText(nombre);
                        if (genero == 'M')
                            masculinoRB.setSelected(true);
                        else
                            femeninoRB.setSelected(true);
                        vitalicioCheckBox.setSelected(vitalicio);
                    }
                }
            }
        });
        clearFields();
        loadData();
    }
    @Override
    public void loadData() {
        try {
            // Limpiar tabla antes de cargar nuevos datos
            tablaModel.setRowCount(0);

            // Obtener lista de mascotas desde la base de datos
            List<Socio> listaSocios = sociosDAO.getListaSocios();

            // Llenar la tabla con los datos obtenidos
            for (Socio socio : listaSocios) {
                Object[] row = {socio.getIdSocio(), socio.getNombre(), socio.getGenero(), socio.isVitalicio()};
                tablaModel.addRow(row);
            }
            tablaModel.fireTableDataChanged();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al cargar datos: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public boolean validateFields() {
        boolean response = false;
        if (nombreField.getText().isBlank()) {
            setMessage("El nombre es un campo obligatorio");
            nombreField.requestFocus();
        }
        else if (!masculinoRB.isSelected() && !femeninoRB.isSelected()) {
            setMessage("El género es un campo obligatorio");
            masculinoRB.requestFocus();
        }
        else
            response = true;
        return response;
    }

    @Override
    public void insert() {
        String nombre = nombreField.getText();
        char genero = masculinoRB.isSelected() ? 'M' : 'F';
        boolean vitalicio = vitalicioCheckBox.isSelected();
        List<Deporte> listaDeportes = getDeportesSeleccionados();
        try {

           sociosDAO.insertarSocio(nombre, genero, vitalicio, listaDeportes);
            JOptionPane.showMessageDialog(this, "Registro insertado correctamente");
            clearFields();
            loadData(); // Recargar la tabla después de la inserción
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al insertar el registro: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private List<Deporte> getDeportesSeleccionados() {
        List<Deporte> lista = new ArrayList<>();
        for (Component comp : deportesPanel.getComponents()) {
            if (comp instanceof JCheckBox) {
                JCheckBox checkBox = (JCheckBox) comp;
                if (checkBox.isSelected()) {
                    lista.add((Deporte) checkBox.getClientProperty("deporte"));
                }
            }
        }
        return lista;
    }

    private void desmarcaDeportes() {
        for (Component comp : deportesPanel.getComponents())
            if (comp instanceof JCheckBox)
                ((JCheckBox) comp).setSelected(false);
    }

    private void setDeportesSocio(List<Deporte> listaDeportes) {
        for (Deporte deporte: listaDeportes) {
            for (Component comp : deportesPanel.getComponents()) {
                if (comp instanceof JCheckBox) {
                    JCheckBox checkBox = (JCheckBox) comp;
                    if (checkBox.getClientProperty("deporte").equals(deporte)){
                        checkBox.setSelected(true);
                    }
                }
            }
        }
    }
    @Override
    public void update() {
        int selectedRow = tabla.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Por favor seleccionar un registro para actualizar",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        long id = (long) tabla.getValueAt(selectedRow, 0);
        String nombre = nombreField.getText();
        char genero = masculinoRB.isSelected() ? 'M' : 'F';
        boolean vitalicio = vitalicioCheckBox.isSelected();
        List<Deporte> listaDeportes = getDeportesSeleccionados();

        try {
            sociosDAO.actualizarSocio(id, nombre, genero, vitalicio, listaDeportes);
            JOptionPane.showMessageDialog(this, "Registro actualizado correctamente");
            clearFields();
            loadData(); // Recargar la tabla después de la actualización
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al actualizar el registro: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void delete() {
        int selectedRow = tabla.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Por favor seleccione un registro para eliminar",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "¿Estás seguro de eliminar el registro?",
                "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            long id = (long) tabla.getValueAt(selectedRow, 0);

            try {
                sociosDAO.eliminarSocio(id);
                JOptionPane.showMessageDialog(this, "Registro eliminado correctamente");
                clearFields();
                loadData(); // Recargar la tabla después de la eliminación
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error al eliminar el registro: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @Override
    public void persist() {
        if (validateFields()) {
            int selectedRow = tabla.getSelectedRow();
            if (selectedRow == -1)
                insert();
            else
                update();
        }
    }

    @Override
    public void clearFields() {
        nombreField.setText("");
        idSocioField.setText("");
        generoBG.clearSelection(); // Desmarca todos los botones del grupo
        vitalicioCheckBox.setSelected(false);
        desmarcaDeportes();
        tabla.clearSelection();
        messageLabel.setText(" ");
        messageLabel.setOpaque(false);
    }
}


