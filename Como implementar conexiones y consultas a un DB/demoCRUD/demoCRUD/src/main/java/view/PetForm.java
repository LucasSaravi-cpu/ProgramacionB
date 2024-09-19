package view;  // Define el paquete en el que se encuentra esta clase.

import DAO.PetDAO;  // Importa la clase PetDAO para gestionar operaciones de mascotas en la base de datos.
import DAO.PetTypeDAO;  // Importa la clase PetTypeDAO para gestionar tipos de mascotas en la base de datos.
import model.Pet;  // Importa la clase Pet para manejar datos de mascotas.
import model.PetType;  // Importa la clase PetType para manejar datos de tipos de mascotas.

import javax.swing.*;  // Importa las clases necesarias para construir interfaces gráficas con Swing.
import javax.swing.event.ListSelectionEvent;  // Importa clases para manejar eventos de selección de filas en una tabla.
import javax.swing.event.ListSelectionListener;  // Importa la interfaz para escuchar eventos de selección en una tabla.
import javax.swing.table.DefaultTableModel;  // Importa la clase DefaultTableModel para manejar datos en una tabla de Swing.

import java.awt.*;  // Importa clases para manejar gráficos y diseño de la interfaz.
import java.awt.event.*;  // Importa clases para manejar eventos de interfaz gráfica.
import java.sql.SQLException;  // Importa la clase SQLException para manejar errores de SQL.
import java.util.List;  // Importa la interfaz List para manejar colecciones de objetos.
import view.ViewUtils;  // Importa una clase personalizada para manejar utilidades de vista (asumido).

public class PetForm extends JFrame {  // Define la clase PetForm que extiende JFrame para crear una ventana de aplicación.

    private JTextField nameField, notesField, petIdField;  // Campos de texto para ingresar el nombre, notas y el ID de la mascota.

    private JSpinner yearofbirthField;  // Campo para seleccionar el año de nacimiento de la mascota.
    private JComboBox<PetType> pettypeComboBox;  // ComboBox para seleccionar el tipo de mascota.
    private JButton confirmButton, deleteButton, cancelButton;  // Botones para confirmar, eliminar y cancelar acciones.

    private JLabel messageLabel;  // Etiqueta para mostrar mensajes de estado.
    private JTable petTable;  // Tabla para mostrar la lista de mascotas.
    private DefaultTableModel tableModel;  // Modelo de tabla para manejar datos en la JTable.
    private PetDAO petDAO;  // Instancia de PetDAO para realizar operaciones de base de datos sobre mascotas.
    private PetTypeDAO petTypeDAO;  // Instancia de PetTypeDAO para realizar operaciones de base de datos sobre tipos de mascotas.

    // Constructor de la clase PetForm que recibe instancias de PetDAO y PetTypeDAO.
    public PetForm(PetDAO petDAO, PetTypeDAO petTypeDAO) {
        this.petDAO = petDAO;  // Asigna el PetDAO recibido a la instancia de la clase.
        this.petTypeDAO = petTypeDAO;  // Asigna el PetTypeDAO recibido a la instancia de la clase.

        setTitle("Gestión de Mascotas");  // Establece el título de la ventana.
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);  // Define el comportamiento al cerrar la ventana (ocultarla).

        JPanel inputPanel = new JPanel();  // Crea un panel para los campos de entrada.
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));  // Establece el diseño vertical de los componentes en el panel.

        JLabel petIdLabel = new JLabel("ID de Mascota: ", JLabel.RIGHT);  // Etiqueta para el ID de la mascota.
        petIdField = new JTextField(20);  // Campo de texto para ingresar el ID de la mascota.
        JLabel nameLabel = new JLabel("Nombre: ", JLabel.RIGHT);  // Etiqueta para el nombre de la mascota.
        nameField = new JTextField(20);  // Campo de texto para ingresar el nombre de la mascota.
        JLabel notesLabel = new JLabel("Notas: ", JLabel.RIGHT);  // Etiqueta para las notas sobre la mascota.
        notesField = new JTextField(20);  // Campo de texto para ingresar notas sobre la mascota.
        JLabel yearofbirthLabel = new JLabel("Año de Nacimiento: ", JLabel.RIGHT);  // Etiqueta para el año de nacimiento.
        yearofbirthField = new JSpinner();  // Campo para seleccionar el año de nacimiento de la mascota.

        JLabel pettypeIdLabel = new JLabel("Tipo de Mascota: ", JLabel.RIGHT);  // Etiqueta para el tipo de mascota.
        pettypeComboBox = new JComboBox<>();  // ComboBox para seleccionar el tipo de mascota.
        loadPetTypes();  // Carga los tipos de mascotas en el ComboBox.

        confirmButton = new JButton("Confirmar");  // Botón para confirmar la acción (insertar o actualizar).
        ViewUtils.setIconToButton(confirmButton, "/imgs/confirm.png", 16, 16);  // Asigna un ícono al botón.

        deleteButton = new JButton("Eliminar");  // Botón para eliminar una mascota.
        ViewUtils.setIconToButton(deleteButton, "/imgs/delete.png", 16, 16);  // Asigna un ícono al botón.

        cancelButton = new JButton("Limpiar");  // Botón para limpiar los campos.
        ViewUtils.setIconToButton(cancelButton, "/imgs/cancel.png", 16, 16);  // Asigna un ícono al botón.

        JPanel horizontalPanel = new JPanel(new GridLayout());  // Panel para colocar campos en una fila.
        horizontalPanel.add(petIdLabel);  // Agrega la etiqueta del ID.
        horizontalPanel.add(petIdField);  // Agrega el campo de texto del ID.
        inputPanel.add(horizontalPanel);  // Agrega el panel horizontal al panel de entrada.

        horizontalPanel = new JPanel(new GridLayout());  // Panel para colocar campos en una fila.
        horizontalPanel.add(nameLabel);  // Agrega la etiqueta del nombre.
        horizontalPanel.add(nameField);  // Agrega el campo de texto del nombre.
        inputPanel.add(horizontalPanel);  // Agrega el panel horizontal al panel de entrada.

        horizontalPanel = new JPanel(new GridLayout());  // Panel para colocar campos en una fila.
        horizontalPanel.add(yearofbirthLabel);  // Agrega la etiqueta del año de nacimiento.
        horizontalPanel.add(yearofbirthField);  // Agrega el campo de año de nacimiento.
        inputPanel.add(horizontalPanel);  // Agrega el panel horizontal al panel de entrada.

        horizontalPanel = new JPanel(new GridLayout());  // Panel para colocar campos en una fila.
        horizontalPanel.add(notesLabel);  // Agrega la etiqueta de notas.
        horizontalPanel.add(notesField);  // Agrega el campo de texto de notas.
        inputPanel.add(horizontalPanel);  // Agrega el panel horizontal al panel de entrada.

        horizontalPanel = new JPanel(new GridLayout());  // Panel para colocar campos en una fila.
        horizontalPanel.add(pettypeIdLabel);  // Agrega la etiqueta del tipo de mascota.
        horizontalPanel.add(pettypeComboBox);  // Agrega el ComboBox para seleccionar el tipo de mascota.
        inputPanel.add(horizontalPanel);  // Agrega el panel horizontal al panel de entrada.

        horizontalPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));  // Panel para los botones en un flujo centrado.
        horizontalPanel.add(confirmButton);  // Agrega el botón de confirmar.
        horizontalPanel.add(deleteButton);  // Agrega el botón de eliminar.
        horizontalPanel.add(cancelButton);  // Agrega el botón de limpiar.
        inputPanel.add(horizontalPanel);  // Agrega el panel horizontal al panel de entrada.

        JPanel tablePanel = new JPanel(new BorderLayout());  // Panel para la tabla de mascotas.
        tableModel = new DefaultTableModel() {  // Crea un modelo de tabla con celdas no editables.
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;  // Hacer que todas las celdas sean no editables.
            }
        };
        petTable = new JTable(tableModel);  // Crea una JTable usando el modelo de tabla.

        // Definir las columnas de la tabla.
        tableModel.addColumn("ID de Mascota");
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Fecha Nacimiento");
        tableModel.addColumn("Notas");
        tableModel.addColumn("Tipo de mascota");
        tableModel.addColumn("Object");

        // Establecer los anchos de las columnas.
        petTable.getColumnModel().getColumn(0).setMinWidth(40);
        petTable.getColumnModel().getColumn(0).setPreferredWidth(40);
        petTable.getColumnModel().getColumn(1).setMinWidth(40);
        petTable.getColumnModel().getColumn(1).setPreferredWidth(40);
        petTable.getColumnModel().getColumn(2).setMinWidth(60);
        petTable.getColumnModel().getColumn(2).setPreferredWidth(60);
        petTable.getColumnModel().getColumn(3).setMinWidth(260);
        petTable.getColumnModel().getColumn(3).setPreferredWidth(300);
        petTable.getColumnModel().getColumn(4).setMinWidth(80);
        petTable.getColumnModel().getColumn(4).setPreferredWidth(80);

        // Ocultar la columna del objeto Pet.
        petTable.getColumnModel().getColumn(5).setMinWidth(0);
        petTable.getColumnModel().getColumn(5).setMaxWidth(0);
        petTable.getColumnModel().getColumn(5).setPreferredWidth(0);

        JScrollPane scrollPane = new JScrollPane(petTable);  // Crea un JScrollPane para la JTable.
        tablePanel.add(scrollPane, BorderLayout.CENTER);  // Agrega el JScrollPane al panel de la tabla.

        JPanel mainPanel = new JPanel(new BorderLayout());  // Panel principal que contiene todos los demás paneles.
        mainPanel.add(inputPanel, BorderLayout.NORTH);  // Agrega el panel de entrada al norte del panel principal.
        mainPanel.add(tablePanel, BorderLayout.CENTER);  // Agrega el panel de la tabla al centro del panel principal.
        messageLabel = new JLabel(" ", SwingConstants.CENTER);  // Crea una etiqueta para los mensajes, centrada.
        messageLabel.setForeground(Color.WHITE);  // Establece el color del texto de la etiqueta.
        messageLabel.setFont(new Font("Arial", Font.BOLD, 16));  // Establece la fuente de la etiqueta.
        messageLabel.setBackground(Color.RED);  // Establece el color de fondo de la etiqueta.
        messageLabel.setOpaque(false);  // Define que la etiqueta no sea opaca.
        mainPanel.add(messageLabel, BorderLayout.SOUTH);  // Agrega la etiqueta de mensaje al sur del panel principal.
        mainPanel.setPreferredSize(new Dimension(800,600));  // Establece el tamaño preferido del panel principal.
        getContentPane().add(mainPanel);  // Agrega el panel principal al contenido de la ventana.

        // Configura el evento para el botón de confirmar.
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validateFields()) {  // Valida los campos antes de proceder.
                    int selectedRow = petTable.getSelectedRow();  // Obtiene la fila seleccionada en la tabla.
                    if (selectedRow == -1)
                        insertPet();  // Inserta una nueva mascota si no hay una fila seleccionada.
                    else
                        updatePet();  // Actualiza la mascota existente si hay una fila seleccionada.
                }
            }
        });

        // Configura el evento para el botón de eliminar.
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deletePet();  // Elimina la mascota seleccionada.
            }
        });

        // Configura el evento para el botón de limpiar.
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();  // Limpia todos los campos de entrada.
            }
        });

        // Carga los datos iniciales en la tabla.
        loadPets();

        // Configura la selección de fila en la tabla.
        petTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {  // Verifica que la selección esté completa.
                    int selectedRow = petTable.getSelectedRow();  // Obtiene la fila seleccionada.
                    if (selectedRow != -1) {
                        // Muestra los datos de la fila seleccionada en los campos de entrada.
                        long petId = (long) tableModel.getValueAt(selectedRow, 0);
                        String name = (String) tableModel.getValueAt(selectedRow, 1);
                        int yearofbirth = (int) tableModel.getValueAt(selectedRow, 2);
                        String notes = (String) tableModel.getValueAt(selectedRow, 3);
                        PetType petType = ((Pet) (tableModel.getValueAt(selectedRow, 5))).getPettype();

                        petIdField.setText(String.valueOf(petId));
                        nameField.setText(name);
                        yearofbirthField.setValue(yearofbirth);
                        notesField.setText(notes);
                        pettypeComboBox.setSelectedItem(petType);
                    }
                }
            }
        });
        clearFields();  // Limpia los campos de entrada al iniciar el formulario.
        pack();  // Ajusta el tamaño de la ventana al contenido preferido.
        setLocationRelativeTo(null);  // Centra la ventana en la pantalla.
        setVisible(true);  // Hace visible la ventana.
    }

    // Carga los datos de las mascotas en la tabla.
    private void loadPets() {
        try {
            tableModel.setRowCount(0);  // Limpia la tabla antes de cargar nuevos datos.

            List<Pet> pets = petDAO.getAllPets();  // Obtiene la lista de mascotas desde la base de datos.

            for (Pet pet : pets) {
                Object[] row = {pet.getPet(), pet.getName(), pet.getYearofbirth(), pet.getNotes(), pet.getPettype().getDescription(), pet};
                tableModel.addRow(row);  // Agrega cada mascota a la tabla.
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al cargar mascotas: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);  // Muestra un mensaje de error si ocurre una excepción.
        }
    }

    // Carga los tipos de mascotas en el ComboBox.
    private void loadPetTypes() {
        try {
            List<PetType> petTypes = petTypeDAO.getAllPetTypes();  // Obtiene la lista de tipos de mascotas desde la base de datos.
            for (PetType petType : petTypes) {
                pettypeComboBox.addItem(petType);  // Agrega cada tipo de mascota al ComboBox.
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al cargar tipos de mascotas: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);  // Muestra un mensaje de error si ocurre una excepción.
        }
    }

    // Valida los campos de entrada.
    public boolean validateFields() {
        boolean response = false;
        if (nameField.getText().isBlank()) {  // Verifica si el nombre está vacío.
            setMessage("El nombre de la mascota es un campo obligatorio");
            nameField.requestFocus();  // Pone el foco en el campo de nombre.
        }
        else if ((int)yearofbirthField.getValue() < 2000) {  // Verifica si el año de nacimiento es menor a 2000.
            setMessage("El año de nacimiento no puede ser anterior a 2000");
            yearofbirthField.requestFocus();  // Pone el foco en el campo de año de nacimiento.
        }
        else
            response = true;  // Los campos son válidos.
        return response;
    }

    // Inserta una nueva mascota en la base de datos.
    private void insertPet() {
        String name = nameField.getText();  // Obtiene el nombre de la mascota.
        int yearOfBirth = (int)yearofbirthField.getValue();  // Obtiene el año de nacimiento.
        String notes = notesField.getText();  // Obtiene las notas.
        PetType petType = (PetType) pettypeComboBox.getSelectedItem();  // Obtiene el tipo de mascota seleccionado.
        try {
            petDAO.insertPet(name, yearOfBirth, notes, petType.getPettype());  // Inserta la mascota en la base de datos.
            JOptionPane.showMessageDialog(this, "Mascota insertada correctamente");  // Muestra un mensaje de éxito.
            clearFields();  // Limpia los campos de entrada.
            loadPets();  // Recarga la lista de mascotas en la tabla.
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al insertar mascota: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);  // Muestra un mensaje de error si ocurre una excepción.
        }
    }

    // Actualiza los datos de una mascota existente.
    private void updatePet() {
        int selectedRow = petTable.getSelectedRow();  // Obtiene la fila seleccionada en la tabla.
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Por favor selecciona una mascota para actualizar",
                    "Error", JOptionPane.ERROR_MESSAGE);  // Muestra un mensaje de error si no se ha seleccionado ninguna fila.
            return;
        }

        long petId = (long) tableModel.getValueAt(selectedRow, 0);  // Obtiene el ID de la mascota desde la tabla.
        String name = nameField.getText();  // Obtiene el nombre de la mascota.
        int yearofbirth = (int)yearofbirthField.getValue();  // Obtiene el año de nacimiento.
        String notes = notesField.getText();  // Obtiene las notas.
        PetType petType = (PetType) pettypeComboBox.getSelectedItem();  // Obtiene el tipo de mascota seleccionado.

        try {
            petDAO.updatePet(petId, name, yearofbirth, notes, petType.getPettype());  // Actualiza la mascota en la base de datos.
            JOptionPane.showMessageDialog(this, "Mascota actualizada correctamente");  // Muestra un mensaje de éxito.
            clearFields();  // Limpia los campos de entrada.
            loadPets();  // Recarga la lista de mascotas en la tabla.
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al actualizar mascota: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);  // Muestra un mensaje de error si ocurre una excepción.
        }
    }

    // Establece un mensaje en la etiqueta de mensajes.
    private void setMessage(String message) {
        messageLabel.setText(message);  // Establece el texto del mensaje.
        messageLabel.setOpaque(true);  // Define que la etiqueta sea opaca.
    }

    // Elimina una mascota de la base de datos.
    private void deletePet() {
        int selectedRow = petTable.getSelectedRow();  // Obtiene la fila seleccionada en la tabla.
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Por favor selecciona una mascota para eliminar",
                    "Error", JOptionPane.ERROR_MESSAGE);  // Muestra un mensaje de error si no se ha seleccionado ninguna fila.
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "¿Estás seguro de eliminar esta mascota?",
                "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);  // Solicita confirmación para eliminar.

        if (confirm == JOptionPane.YES_OPTION) {
            long petId = (long) tableModel.getValueAt(selectedRow, 0);  // Obtiene el ID de la mascota desde la tabla.

            try {
                petDAO.deletePet(petId);  // Elimina la mascota de la base de datos.
                JOptionPane.showMessageDialog(this, "Mascota eliminada correctamente");  // Muestra un mensaje de éxito.
                clearFields();  // Limpia los campos de entrada.
                loadPets();  // Recarga la lista de mascotas en la tabla.
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error al eliminar mascota: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);  // Muestra un mensaje de error si ocurre una excepción.
            }
        }
    }

    // Limpia los campos de entrada.
    private void clearFields() {
        petIdField.setText("");  // Limpia el campo de ID de mascota.
        nameField.setText("");  // Limpia el campo de nombre.
        yearofbirthField.setValue(0);  // Limpia el campo de año de nacimiento.
        notesField.setText("");  // Limpia el campo de notas.
        pettypeComboBox.setSelectedIndex(0);  // Resetea el ComboBox al primer ítem.
        petTable.clearSelection();  // Limpia la selección en la tabla.
        petIdField.setEnabled(false);  // Desactiva el campo de ID de mascota.
        nameField.requestFocus();  // Pone el foco en el campo de nombre.
        messageLabel.setText(" ");  // Limpia el mensaje.
        messageLabel.setOpaque(false);  // Define que la etiqueta de mensaje no sea opaca.
    }
}