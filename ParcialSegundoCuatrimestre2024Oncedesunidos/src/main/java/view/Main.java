package view;

import DAO.SociosDAO;
import DAO.DeportesDAO;

import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;

public class Main {

    public Main() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Menú Principal");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                JMenuBar menuBar = new JMenuBar();
                JMenu formsMenu = new JMenu("Formularios");

                // Crear los items del menú
                JMenuItem deportesFormMenuItem = new JMenuItem("Deportes");
                JMenuItem sociosFormMenuItem = new JMenuItem("Socios");
                JMenuItem listadoFormMenuItem = new JMenuItem("Listado de Cuotas");


                DeportesDAO deportesDAO = new DeportesDAO();
                // Agregar ActionListener para abrir los formularios respectivos
                deportesFormMenuItem.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        new DeportesForm("ABM de Deportes",deportesDAO);
                    }
                });

                SociosDAO sociosDAO = new SociosDAO();
                sociosFormMenuItem.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        new SociosForm("ABM de Socios", sociosDAO, deportesDAO);
                    }
                });

                listadoFormMenuItem.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            new ListadoCuotasForm("Listado de Cuotas" ).listarCuotas(sociosDAO.getListaSocios());
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                });
                formsMenu.add(deportesFormMenuItem);
                formsMenu.add(sociosFormMenuItem);
                formsMenu.add(listadoFormMenuItem);
                menuBar.add(formsMenu);

                frame.setJMenuBar(menuBar);
                frame.setSize(700, 600);
                frame.setLocationRelativeTo(null); // Centrar ventana
                frame.setVisible(true);
            }
        });
    }
}
