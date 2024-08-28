import java.io.IOException;
import java.util.Date;

import javax.swing.JTextArea;
import javax.swing.SwingUtilities;


/**
 * Referencias: 
 * https://stackoverflow.com/questions/238036/java-html-parsing
 * https://stackoverflow.com/questions/30731045/generate-thumbnail-in-java
 * https://docs.oracle.com/javase/tutorial/uiswing/concurrency/index.html
 */

public class ThreadCounter extends Thread
{
    private String threadName;
	private Counter counter;
    private JTextArea display;
    private Date date;
    private int times = 0;
    private int LIMIT_VALUE = 200;
  
    final Runnable doShowCounter = new Runnable() {
      public void run() {
    	  if (counter.getValue() < LIMIT_VALUE) {
				/* Caso incrementa y obtiene el valor en 2 metodos distintos */ 
                counter.increment();
	    		display.append(" " + threadName + " >> " + counter.getValue() + "\n");
				times++;
				display.revalidate();
	    		

				/* Caso Incrementa y obtiene el valor en un mismo método atómico   
				display.append(" " + threadName + " >> " + counter.incrementAndGetValue() + "\n");
				times++;
				display.revalidate();
				*/
    	  }
      }
    };
    		
    		
    public ThreadCounter(String threadName, Counter counter, JTextArea display, Date date) throws IOException
    {
        this.threadName = threadName;
    	this.counter = counter;	
        this.display = display;
        this.date = date;
    }
    

	@Override
	public void run() {
			display.append(date + "\n");

			while (counter.getValue() < LIMIT_VALUE) {
				try {
					/* Caso Encola la actualización del contador y de la UI en el hilo principal de Swing */ 
					SwingUtilities.invokeAndWait(doShowCounter);
			  		
					
					/* Caso incrementa y obtiene el valor en 2 metodos distintos  
		    		counter.increment();
		    		display.append(" " + threadName + " >> " + counter.getValue() + "\n");
					times++;
					display.revalidate();
		    		*/

					/* Caso Incrementa y obtiene el valor en un mismo método atómico 
					display.append(" " + threadName + " >> " + counter.incrementAndGetValue() + "\n");
					times++;
					display.revalidate();
					*/					
					Thread.sleep(50);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			long seconds = (new Date().getTime()-date.getTime());
			display.append(threadName + " veces incremento contador: " + times + " (" + seconds +" milisegundos)\n");
	}
	
}