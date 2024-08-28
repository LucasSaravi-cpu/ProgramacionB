package deadlockexample;

public class DeadlockExampleThread extends Thread {
        private Integer a;  
        private Integer b; 
        private int initialDelay;
        
        public DeadlockExampleThread(Integer a, Integer b,String name, int initialDelay) {  
             super(name);  
             this.a = a;  
             this.b = b;
             this.initialDelay = initialDelay;
        }  
        
        public void run(){  
        	System.out.println("Thread " + this.getName() + ". Comienzo!");

        	try {
				Thread.sleep(this.initialDelay);
	
	        	synchronized(a) 
	        	{  
		              System.out.println("Thread " + this.getName() + " ha bloqueado Integer " + a.intValue());
		              Thread.sleep(100);  
		                     	
		              System.out.println("Thread " + this.getName() + " intentará bloquear a " + b.intValue());
		              
		              synchronized(b) {  
		                  	System.out.println("Thread " + this.getName() + " ha bloqueado Integer " + b.intValue());
		              } 
	    	  		  System.out.println("Thread " + this.getName() + " ha desbloqueado a " + b.intValue());
	            }
	  		  	System.out.println("Thread " + this.getName() + " ha desbloqueado a " + a.intValue());
	            System.out.println("Thread " + this.getName() + " ha terminado");       
	            
			} 
        	catch (InterruptedException e1) {
				e1.printStackTrace();
			}  

        }  
}
