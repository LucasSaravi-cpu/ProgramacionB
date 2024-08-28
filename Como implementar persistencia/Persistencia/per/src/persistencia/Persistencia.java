package persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;

public class Persistencia {
	
	public static void persistirControlador(Controlador controlador) {
		try {
			   FileOutputStream fos = new FileOutputStream("controlador.file");
	           ObjectOutputStream oos = new ObjectOutputStream(fos);
	           //escribe el objeto serializado a un archivo
	           oos.writeObject(controlador);
	           oos.flush();
	           oos.close();
	       } catch (Exception e) {
	           System.out.println("Excepcion durante la serialización: " + e);
	           System.exit(0);
	       }		
	}

	public static Controlador instanciarControlador() {
         Controlador controlador = null;
		 try {
	            //abre el archivo
	            FileInputStream fis = new FileInputStream("controlador.file");
	            ObjectInputStream ois = new ObjectInputStream(fis);
	            //lee el objeto del archivo
	            controlador = (Controlador) ois.readObject();
	            ois.close();
	      } catch (Exception e) {
	            System.out.println("Exception during deserialization: " + e);
	            System.exit(0);
	      }
		  return controlador;
	}
}
