package application;

public class Model {
	String newLine = "\n";
	
	private static int remain = 0;
	
	public void addRemain(int amount) {
		remain += amount;
	}
	
	public static int getRemain() {
		return remain;
	}
	
	public static void buy(int price) {
		remain -= price;
	}
	
	public int decreaseRemain() {
		
		remain -= 100;
		return remain;
	}
}