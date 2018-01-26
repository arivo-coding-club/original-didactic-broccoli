package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class Controller {

	private String select = "";
	private int x = 0;
	private Model model = new Model();
	
	@FXML
	private TextField result; 
	
	@FXML
	private void operator(ActionEvent event) {
		//result.setText(((Button) event.getSource()).getText());
		result.setText(((Button) event.getSource()).getText());
		//if(result.get
		
	}
	
	@FXML
	private void select(ActionEvent event) {
		if(((Button) event.getSource()).getText().equals("선택완료")){
			result.setText(model.calculate(select, x, Integer.parseInt(result.getText()))+""+"원을 결제하세요");
			} else {
				select = ((Button) event.getSource()).getText();
				x = Integer.parseInt(result.getText());
			}	
		}
	
	@FXML
	private void paymentOption(ActionEvent event) {
		if(((Button) event.getSource()).getText().equals("5000원 투입")){
			if(this.x < 5000) {
				String minus = String.valueOf(5000-this.x);
				result.setText("결제가 완료되었습니다. 거스름돈은 "+minus+"원 입니다");
			} else {
				result.setText("금액이 부족합니다");
			}
		} else {
			if(x < 10000) {
				String minus = String.valueOf(10000-x);
				result.setText("결제가 완료되었습니다. 거스름돈은 "+minus+"원 입니다");
			} else {
				result.setText("금액이 부족합니다");
			}	
		}
		
		result.setText("안녕히 가십시오..");
	}
}