package com.example.demoCRUD;  // Define el paquete donde se encuentra esta clase.

import DAO.PetDAO;  // Importa la clase PetDAO desde el paquete DAO.
import DAO.PetTypeDAO;  // Importa la clase PetTypeDAO desde el paquete DAO.
import view.PetForm;  // Importa la clase PetForm desde el paquete view.
import view.PetTypeForm;  // Importa la clase PetTypeForm desde el paquete view.

import javax.swing.*;  // Importa todas las clases del paquete javax.swing para crear interfaces gráficas de usuario.
import java.awt.event.*;  // Importa todas las clases del paquete java.awt.event para manejar eventos de GUI.

public class Main {  // Define la clase Main.

    public Main() {  // Define el constructor de la clase Main.
        SwingUtilities.invokeLater(new Runnable() {  // Programa el código en el Runnable para ser ejecutado en el hilo de eventos de Swing, asegurando que la interfaz gráfica se cree en el hilo adecuado.
            public void run() {  // Define el método run() del Runnable.
                JFrame frame = new JFrame("Menú Principal");  // Crea una nueva ventana (JFrame) con el título "Menú Principal".
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Configura la operación de cierre para que termine la aplicación cuando se cierre la ventana.

                JMenuBar menuBar = new JMenuBar();  // Crea una barra de menú (JMenuBar) que se colocará en la parte superior de la ventana.
                JMenu formsMenu = new JMenu("Formularios");  // Crea un menú desplegable (JMenu) titulado "Formularios".

                // Crear los items del menú
                JMenuItem petTypeFormMenuItem = new JMenuItem("Gestión de Tipos de Mascota");  // Crea un ítem de menú (JMenuItem) para la gestión de tipos de mascotas.
                JMenuItem petFormMenuItem = new JMenuItem("Gestión de Mascotas");  // Crea un ítem de menú (JMenuItem) para la gestión de mascotas.

                PetTypeDAO petTypeDAO = new PetTypeDAO();  // Crea una nueva instancia de PetTypeDAO, que probablemente maneje la lógica de acceso a datos para tipos de mascotas.

                // Agregar ActionListener para abrir los formularios respectivos
                petTypeFormMenuItem.addActionListener(new ActionListener() {  // Agrega un ActionListener al ítem de menú de gestión de tipos de mascotas.
                    public void actionPerformed(ActionEvent e) {  // Define el método actionPerformed() que se ejecutará cuando se seleccione el ítem del menú.
                        new PetTypeForm(petTypeDAO);  // Crea una nueva instancia de PetTypeForm, pasando la instancia de PetTypeDAO para gestionar los datos.
                    }
                });

                petFormMenuItem.addActionListener(new ActionListener() {  // Agrega un ActionListener al ítem de menú de gestión de mascotas.
                    public void actionPerformed(ActionEvent e) {  // Define el método actionPerformed() que se ejecutará cuando se seleccione el ítem del menú.
                        PetDAO petDAO = new PetDAO();  // Crea una nueva instancia de PetDAO, que probablemente maneje la lógica de acceso a datos para mascotas.
                        new PetForm(petDAO, petTypeDAO);  // Crea una nueva instancia de PetForm, pasando las instancias de PetDAO y PetTypeDAO para gestionar los datos de mascotas y tipos de mascotas.
                    }
                });

                // Agregar los items al menú
                formsMenu.add(petTypeFormMenuItem);  // Agrega el ítem de menú de gestión de tipos de mascotas al menú "Formularios".
                formsMenu.add(petFormMenuItem);  // Agrega el ítem de menú de gestión de mascotas al menú "Formularios".
                menuBar.add(formsMenu);  // Agrega el menú "Formularios" a la barra de menú.

                // Agregar el menú al JFrame principal
                frame.setJMenuBar(menuBar);  // Establece la barra de menú en la ventana principal.

                frame.setSize(400, 300);  // Define el tamaño de la ventana en 400x300 píxeles.
                frame.setLocationRelativeTo(null);  // Centra la ventana en la pantalla.
                frame.setVisible(true);  // Hace visible la ventana.
            }
        });
    }
}