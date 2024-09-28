package view;

import DAO.DeportesDAO;
import jakarta.annotation.PostConstruct;
import model.Deporte;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeportesForm extends ABMBaseForm {

    private JTextField idDeporteField;
    private JTextField nombreField;
    private JTextField valorField;
    private DeportesDAO deportesDAO;

    public DeportesForm(String titulo, DeportesDAO deportesDAO) {
        super(titulo);
        this.deportesDAO = deportesDAO;

        JLabel idDeporteLabel = new JLabel("Identificador:");
        idDeporteField = new JTextField(20);
        idDeporteField.setEnabled(false);

        JLabel descriptionLabel = new JLabel("Descripción:");
        nombreField = new JTextField(20);

        JLabel valorLabel = new JLabel("Valor($):");
        valorField = new JTextField(20);

        JPanel verticalPanel = new JPanel();
        verticalPanel.setLayout((new BoxLayout(verticalPanel, BoxLayout.Y_AXIS)));
        JPanel horizontalPanel = new JPanel(new GridLayout());
        horizontalPanel.add(idDeporteLabel);
        horizontalPanel.add(idDeporteField);
        verticalPanel.add(horizontalPanel);

        horizontalPanel = new JPanel(new GridLayout());
        horizontalPanel.add(descriptionLabel);
        horizontalPanel.add(nombreField);
        verticalPanel.add(horizontalPanel);

        horizontalPanel = new JPanel(new GridLayout());
        horizontalPanel.add(valorLabel);
        horizontalPanel.add(valorField);
        verticalPanel.add(horizontalPanel);

        fieldsPanel.add(verticalPanel);
        inputPanel.add(fieldsPanel, BorderLayout.CENTER);

        // Definir las columnas de la tabla
        tablaModel.addColumn("ID");
        tablaModel.addColumn("Descripción");
        tablaModel.addColumn("Valor($)");

        // Configurar selección de fila en la tabla
        tabla.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = tabla.getSelectedRow();
                    if (selectedRow != -1) {
                        // Mostrar datos de la fila seleccionada en los campos de texto
                        idDeporteField.setText(((Long)(tabla.getValueAt(selectedRow, 0))).toString());
                        String description = (String) tabla.getValueAt(selectedRow, 1);
                        BigDecimal valor = (BigDecimal) tabla.getValueAt(selectedRow, 2);
                        nombreField.setText(description);
                        valorField.setText(valor.toString());
                    }
                }
            }
        });
        clearFields();
        loadData();
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
    public void loadData() {
        try {
            // Limpiar tabla antes de cargar nuevos datos
            tablaModel.setRowCount(0);

            // Obtener lista de registros desde la base de datos
            List<Deporte> listaDeportes = deportesDAO.getListaDeportes();

            // Llenar la tabla con los datos obtenidos
            for (Deporte deporte : listaDeportes) {
                Object[] row = {deporte.getIdDeporte(), deporte.getDescripcion(), deporte.getValor()};
                tablaModel.addRow(row);
            }
            tablaModel.fireTableDataChanged(); //Actualiza contenido de la tabla
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al cargar datos: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public boolean validateFields() {
        boolean response = false;
        if (nombreField.getText().isBlank()) {
            setMessage("La descripción es un campo obligatorio");
            nombreField.requestFocus();
        }
        else
        if (valorField.getText().isBlank()) {
            setMessage("El valor es un campo obligatorio");
            valorField.requestFocus();
        }
        else
            response = true;
        return response;

    }
    public void insert() {
        String descripcion = nombreField.getText();
        BigDecimal valor = BigDecimal.valueOf(Float.parseFloat(valorField.getText()));

        try {
            deportesDAO.insertarDeporte(descripcion, valor);
            JOptionPane.showMessageDialog(this, "Registro insertado correctamente");
            clearFields();
            loadData(); // Recargar la tabla después de la inserción
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al insertar el registro: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    @Override
    public void update() {
        int selectedRow = tabla.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Por favor selecciona un registro para actualizar",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        long id = (long) tablaModel.getValueAt(selectedRow, 0); // ID del registro seleccionado en la tabla
        String description = nombreField.getText();
        BigDecimal valor = BigDecimal.valueOf(Float.parseFloat(valorField.getText()));
        try {
            deportesDAO.actualizarDeporte(id, description, valor);
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
            JOptionPane.showMessageDialog(this, "Por favor selecciona un Deporte para eliminar",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "¿Estás seguro de eliminar este Deporte?",
                "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            long idDeporte = (long) tablaModel.getValueAt(selectedRow, 0); // ID desde la tabla

            try {
                deportesDAO.borrarDeporte(idDeporte);
                JOptionPane.showMessageDialog(this, "Deporte eliminado correctamente");
                clearFields();
                loadData(); // Recargar la tabla después de la eliminación
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error al eliminar el registro: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @Override
    public void clearFields() {
        nombreField.setText("");
        idDeporteField.setText("");
        valorField.setText("");
        tabla.clearSelection();
        messageLabel.setText(" ");
        messageLabel.setOpaque(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                DeportesDAO deportesDAO = new DeportesDAO();
                new DeportesForm("ABM de Deportes", deportesDAO);
            }
        });
    }
}
