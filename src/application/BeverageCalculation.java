package application;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class BeverageCalculation extends Controller{
	public static String beverageCalculation(ActionEvent event) {
		
		int price = Integer.parseInt(((Button) event.getSource()).getText());
		
		if(Model.getRemain()==7) {
			return price+"원 결제완료";
		}

		else if(Model.getRemain() < price) {
			return "잔액부족";
			
		} else {
			Model.buy(price);
			return Model.getRemain() + "";
		}
	}
}
