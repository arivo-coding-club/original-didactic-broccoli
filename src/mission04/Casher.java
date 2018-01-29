package mission04;


public class Casher{

protected static int remainedMoney = 0;

	public static int remainMoney() {
		return remainedMoney;
	}	
	
	public static void addMoney(int inputtedMoney) {
		remainedMoney += inputtedMoney;
	}

	public static void minusMoney(int beveragePrice) {
		remainedMoney -= beveragePrice;
	}
}		
		