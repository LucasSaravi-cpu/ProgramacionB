package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class ABMBaseForm extends JFrame {

    protected JPanel inputPanel;
    protected JPanel tablaPanel;
    protected JTable tabla;
    protected DefaultTableModel tablaModel;

    protected JPanel fieldsPanel;
   // protected JPanel buttonsPanel;
    protected JButton confirmarButton, cancelarButton, eliminarButton;
    protected JLabel messageLabel;

    public ABMBaseForm(String titulo) {

        setTitle(titulo);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());

        confirmarButton = new JButton("Confirmar");
        ViewUtils.setIconToButton(confirmarButton, "/imgs/confirm.png", 16, 16);

        eliminarButton = new JButton("Eliminar");
        ViewUtils.setIconToButton(eliminarButton, "/imgs/delete.png", 16, 16);

        cancelarButton = new JButton("Limpiar");
        ViewUtils.setIconToButton(cancelarButton, "/imgs/cancel.png", 16, 16);

        fieldsPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout(30,30));
        inputPanel.add(fieldsPanel, BorderLayout.CENTER);

        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonsPanel.add(confirmarButton);
        buttonsPanel.add(eliminarButton);
        buttonsPanel.add(cancelarButton);
        inputPanel.add(buttonsPanel, BorderLayout.SOUTH);

        tablaPanel = new JPanel(new BorderLayout());
        tablaModel = new DefaultTableModel();
        tablaModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hacer que todas las celdas sean no editables
            }
        };

        tabla = new JTable(tablaModel);
        JScrollPane scrollPane = new JScrollPane(tabla);
        tablaPanel.add(scrollPane); //, BorderLayout.CENTER);

        JPanel mainPanel = new JPanel(new BorderLayout());

        messageLabel = new JLabel(" ", SwingConstants.CENTER);
        messageLabel.setForeground(Color.WHITE);
        messageLabel.setFont(new Font("Arial", Font.BOLD, 16));
        messageLabel.setBackground(Color.RED);
        messageLabel.setOpaque(false);

        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(tablaPanel, BorderLayout.CENTER);
        mainPanel.add(messageLabel, BorderLayout.SOUTH);
        getContentPane().add(mainPanel);

        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validateFields()) {
                    persist();
                }
            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delete();
            }
        });



        pack(); // Ajustar el tamaño de la ventana automáticamente
        setLocationRelativeTo(null); // Centrar ventana
        setVisible(true);
    }

    public abstract void persist();

    public void setMessage(String message) {
        messageLabel.setText(message);
        messageLabel.setOpaque(true);
    }

    public abstract void loadData();

    public abstract boolean validateFields();
    public abstract void insert();

    public abstract void update();
    public abstract void delete();

    public void clearFields() {
        messageLabel.setText(" ");
        messageLabel.setOpaque(false);
    }
}
