package view;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.text.NumberFormat;
import java.util.Locale;

public class ViewUtils {

    public static void setIconToButton(JButton button, String iconFile, int width, int height) {
        URL url = ViewUtils.class.getResource(iconFile);
        if (url != null) {
            ImageIcon icon = new ImageIcon(url);
            Image image = icon.getImage();
            Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            ImageIcon resizedIcon = new ImageIcon(resizedImage);
            button.setIcon(resizedIcon);
        } else {
            System.err.println("No se pudo encontrar la imagen en la ruta especificada");
        }
        button.setHorizontalTextPosition(AbstractButton.LEADING);
    }

    public static String formatearMoneda(float importe) {
        // Formatea moneda usando una localización específica, por ejemplo, para Argentina
        NumberFormat formatoAR = NumberFormat.getCurrencyInstance(new Locale("es", "AR"));
        String importeAR = formatoAR.format(importe); //1234.56 -> $ 1.234,56
        return importeAR;
    }
}
