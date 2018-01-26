package application;

//import javafx.scene.control.Button;

public class Model {

	public int calculate(String select, int x, int y) {
		if(!select.equals("추가선택")) {
			return y;
		} else {
			return x+y;
		}
	}
}