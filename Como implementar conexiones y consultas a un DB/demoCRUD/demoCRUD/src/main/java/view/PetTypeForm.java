package view;

import DAO.PetTypeDAO;
import model.PetType;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class PetTypeForm extends JFrame {

    private JTextField descriptionField;
    private JButton confirmButton, cancelButton, deleteButton;
    private JTable petTypeTable;
    private DefaultTableModel tableModel;
    private PetTypeDAO petTypeDAO;
    private JLabel messageLabel;

    public PetTypeForm(PetTypeDAO petTypeDAO) {
        this.petTypeDAO = petTypeDAO;

        setTitle("Gestión de Tipos de Mascota");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));

        JLabel descriptionLabel = new JLabel("Descripción:");
        descriptionField = new JTextField(20);


        confirmButton = new JButton("Confirmar");
        ViewUtils.setIconToButton(confirmButton, "/imgs/confirm.png", 16, 16);

        deleteButton = new JButton("Eliminar");
        ViewUtils.setIconToButton(deleteButton, "/imgs/delete.png", 16, 16);

        cancelButton = new JButton("Limpiar");
        ViewUtils.setIconToButton(cancelButton, "/imgs/cancel.png", 16, 16);

        JPanel horizontalPanel = new JPanel(new GridLayout());
        horizontalPanel.add(descriptionLabel);
        horizontalPanel.add(descriptionField);
        inputPanel.add(horizontalPanel);

        horizontalPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        horizontalPanel.add(confirmButton);
        horizontalPanel.add(deleteButton);
        horizontalPanel.add(cancelButton);
        inputPanel.add(horizontalPanel);

        JPanel tablePanel = new JPanel(new BorderLayout());
        tableModel = new DefaultTableModel();

        // Definir las columnas de la tabla
        tableModel.addColumn("ID");
        tableModel.addColumn("Descripción");

        petTypeTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(petTypeTable);

        tablePanel.add(scrollPane, BorderLayout.CENTER);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(tablePanel, BorderLayout.CENTER);
        messageLabel = new JLabel(" ", SwingConstants.CENTER);
        messageLabel.setForeground(Color.WHITE);
        messageLabel.setFont(new Font("Arial", Font.BOLD, 16));
        messageLabel.setBackground(Color.RED);
        messageLabel.setOpaque(false);
        mainPanel.add(messageLabel, BorderLayout.SOUTH);
        getContentPane().add(mainPanel);

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validateFields()) {
                    int selectedRow = petTypeTable.getSelectedRow();
                    if (selectedRow == -1)
                        insert();
                    else
                        update();
                }
            }

        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delete();
            }
        });

        // Cargar datos iniciales de la tabla
        loadPetTypes();

        // Configurar selección de fila en la tabla
        petTypeTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = petTypeTable.getSelectedRow();
                    if (selectedRow != -1) {
                        // Mostrar datos de la fila seleccionada en los campos de texto
                        String description = (String) tableModel.getValueAt(selectedRow, 1);
                        descriptionField.setText(description);
                    }
                }
            }
        });

        pack(); // Ajustar el tamaño de la ventana automáticamente
        setLocationRelativeTo(null); // Centrar ventana
        setVisible(true);
    }

    private void setMessage(String message) {
        messageLabel.setText(message);
        messageLabel.setOpaque(true);
    }
    private void loadPetTypes() {
        try {
            // Limpiar tabla antes de cargar nuevos datos
            tableModel.setRowCount(0);

            // Obtener lista de tipos de mascotas desde la base de datos
            List<PetType> petTypes = petTypeDAO.getAllPetTypes();

            // Llenar la tabla con los datos obtenidos
            for (PetType petType : petTypes) {
                Object[] row = {petType.getPettype(), petType.getDescription()};
                tableModel.addRow(row);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al cargar tipos de mascotas: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean validateFields() {
        boolean response = false;
        if (descriptionField.getText().isBlank()) {
            setMessage("La descripción del tipo de mascota es un campo obligatorio");
            descriptionField.requestFocus();
        }
        else
            response = true;
        return response;

    }
    private void insert() {
        String description = descriptionField.getText();

        try {
            petTypeDAO.insertPetType(description);
            JOptionPane.showMessageDialog(this, "Tipo de mascota insertado correctamente");
            clearFields();
            loadPetTypes(); // Recargar la tabla después de la inserción
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al insertar tipo de mascota: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void update() {
        int selectedRow = petTypeTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Por favor selecciona un tipo de mascota para actualizar",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        long pettypeId = (long) tableModel.getValueAt(selectedRow, 0); // ID del tipo de mascota desde la tabla
        String description = descriptionField.getText();

        try {
            petTypeDAO.updatePetType(pettypeId, description);
            JOptionPane.showMessageDialog(this, "Tipo de mascota actualizado correctamente");
            clearFields();
            loadPetTypes(); // Recargar la tabla después de la actualización
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al actualizar tipo de mascota: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void delete() {
        int selectedRow = petTypeTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Por favor selecciona un tipo de mascota para eliminar",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "¿Estás seguro de eliminar este tipo de mascota?",
                "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            long pettypeId = (long) tableModel.getValueAt(selectedRow, 0); // ID del tipo de mascota desde la tabla

            try {
                petTypeDAO.deletePetType(pettypeId);
                JOptionPane.showMessageDialog(this, "Tipo de mascota eliminado correctamente");
                clearFields();
                loadPetTypes(); // Recargar la tabla después de la eliminación
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error al eliminar tipo de mascota: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void clearFields() {
        descriptionField.setText("");
        petTypeTable.clearSelection();
        messageLabel.setText(" ");
        messageLabel.setOpaque(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                PetTypeDAO petTypeDAO = new PetTypeDAO();
                new PetTypeForm(petTypeDAO);
            }
        });
    }
}
