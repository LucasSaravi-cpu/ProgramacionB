import java.util.Date;

import javax.swing.SwingUtilities;

public class MultithreadingRunner {

	public MultithreadingRunner() {
		
	}
	
	public static void main(String[] args) {
	
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					Counter counter = new Counter();
					CounterWindow frame = new CounterWindow("Contador actualizado por múltiples hilos");
					frame.setVisible(true);
					Date date = new Date();

		        	ThreadCounter thread1 = new ThreadCounter("Hilo 1", counter, frame.textArea, date);
		        	ThreadCounter thread2 = new ThreadCounter("Hilo 2", counter, frame.textArea, date);
		        	ThreadCounter thread3 = new ThreadCounter("Hilo 3", counter, frame.textArea, date);
		        	thread1.setPriority(Thread.MAX_PRIORITY);
		        	thread2.setPriority(Thread.MIN_PRIORITY);
		        	thread3.setPriority(Thread.MIN_PRIORITY);
		        	thread1.start();
		        	thread2.start();
		        	thread3.start();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
