package application;

public class Model {

	//추가선택을 클릭할 경우 기존의 음료 가격에 새로운 음료 가격이 더해지고, 그렇지 않을 경우 하나의 음료 가격만 계산됩니다
	public int calculate(String select, int x, int y) {
		if(!select.equals("추가선택")) {
			return y;
		} else {
			return x+y;
		}
	}
}