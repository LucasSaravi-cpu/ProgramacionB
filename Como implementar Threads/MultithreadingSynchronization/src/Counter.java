
public class Counter {
	private int value;
	
	public Counter() {
		value = 0;
	}

	public synchronized int getValue() {
	//public int getValue() {
		return value;
	}

	//public void increment() {
	public synchronized void increment() {
		value++;
	}

	//public int incrementAndGetValue() {
	public synchronized int incrementAndGetValue() {
		value++;
		return value;
	}

}
