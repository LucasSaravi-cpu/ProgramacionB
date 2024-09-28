package view;

import model.Deporte;
import model.Socio;
import java.awt.*;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.*;

public class ListadoCuotasForm extends JFrame {
    private JTextArea areaDeTexto;
    public ListadoCuotasForm(String titulo) {
        setTitle(titulo);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        // Crear el área de texto (JTextArea)
        areaDeTexto = new JTextArea(40, 150);
        areaDeTexto.setLineWrap(true);  // Habilitar salto de línea automático
        areaDeTexto.setWrapStyleWord(true);  // Saltar líneas en palabras completas
        areaDeTexto.setFont(new Font("Monospaced", Font.PLAIN, 12));

        // Envolver el JTextArea en un JScrollPane para hacerlo scrollable
        JScrollPane scrollPane = new JScrollPane(areaDeTexto);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        // Añadir el JScrollPane (con el JTextArea dentro) al formulario
        add(scrollPane, BorderLayout.CENTER);

        // Mostrar la ventana
        pack(); // Ajustar el tamaño de la ventana automáticamente
        setLocationRelativeTo(null); // Centrar ventana
        setVisible(true);
    }

    public void listarCuotas(List<Socio> listaSocios) {
        //TO DO: Listar Socios y sus cuotas, en el TextArea
    	  StringBuilder texto = new StringBuilder();
    	    texto.append("Listado de Cuotas Socio\n");
    	    texto.append("=======================================\n");

    	    for (Socio so : listaSocios) {
    	        int deportesQuePractica = 0;
    	        texto.append(so.getNombre()).append("\t").append(so.getGenero()).append("\t").append(so.esVitalicio()).append("\n");
    	        
    	        texto.append("Deportes:\n");
    	        BigDecimal valorCuota = BigDecimal.ZERO;

    	        for (Deporte de : so.getDeportes()) {
    	            texto.append(de.getDescripcion()).append("\t").append(de.getValor()).append("\n");
    	            
    	            deportesQuePractica++;
    	           
    	            valorCuota = valorCuota.add(de.getValor());
    	            
    	        }
               	        
    	        BigDecimal cuota = so.calculaCuota(deportesQuePractica, valorCuota);
    	        
    	        texto.append("Valor cuota: ").append(cuota).append("\n\n");
    	    }

    	    areaDeTexto.setText(texto.toString());
    	
    }

}
