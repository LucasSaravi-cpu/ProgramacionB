package multithreadimages.poo;
import java.net.URL;

import javax.swing.SwingUtilities;

public class MultithreadingRunner {

	public MultithreadingRunner() {
		
	}
	
	public static void main(String[] args) {
	
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
		        	URL url1 = new URL("https://www.freepik.es/search?dates=any&format=search&page=1&query=ni%C3%B1os&selection=1&sort=popular&type=photo"); //"https://www.freepik.es/fotos-populares");   
		        	URL url2 = new URL("https://www.freepik.es/search?dates=any&format=search&page=1&query=paisajes&selection=1&sort=popular&type=photo"); 
		        	URL url3 = new URL("https://www.freepik.es/search?dates=any&format=search&page=1&query=deportes&selection=1&sort=popular&type=photo");
		        	URL url4 = new URL("https://www.freepik.es/search?dates=any&format=search&page=1&query=floricultura&sort=popular");
		        	URL url8 = new URL("https://www.ole.com.ar");
		        	ThreadImageProcessor thread1 = new ThreadImageProcessor("threadNiños", url1, frame);
		        	ThreadImageProcessor thread2 = new ThreadImageProcessor("threadPaisajes", url2, frame);
		        	ThreadImageProcessor thread3 = new ThreadImageProcessor("threadDeportistas", url3, frame);
		        	ThreadImageProcessor thread4 = new ThreadImageProcessor("threadFlores", url4, frame);
		        	ThreadImageProcessor thread8 = new ThreadImageProcessor("threadOLE", url8, frame);
		        	thread1.start();
		        	thread2.start();
		        	thread3.start();
		        	thread4.start();
		        	thread8.start();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
