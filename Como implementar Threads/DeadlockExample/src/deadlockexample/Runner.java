package deadlockexample;

public class Runner {

	public static void main(String[] args) {
		Integer a = 1;
		Integer b = 2;
		DeadlockExampleThread thread1 = new DeadlockExampleThread(a, b, "Hilo Nº 1", 2000);
		DeadlockExampleThread thread2 = new DeadlockExampleThread(b, a, "Hilo Nº 2", 2000);
		thread1.start();
		thread2.start();
	}

}
