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
	//result는 자판기 맨 윗쪽의 빈 공간으로, 여기에서 음료 가격계산과 '선택완료', '결제하세요'등의 메세지가 나옵니다
	private TextField result; 
	
	@FXML
	//operator는 가격 버튼을 의미합니다. 여기서 가격버튼의 숫자를 받아옵니다.
	private void operator(ActionEvent event) {
		result.setText(((Button) event.getSource()).getText());
		
	}
	
	@FXML
	//select는 선택완료, 추가선택 버튼을 의미합니다.
	//select 메소드는 model class와 연결되고, 선택한 음료의 총 가격을 result에 표시해줍니다. 
	private void select(ActionEvent event) {
		if(((Button) event.getSource()).getText().equals("선택완료")){
			result.setText(model.calculate(select, x, Integer.parseInt(result.getText()))+""+"원을 결제하세요");
			} else {
				//선택완료를 누르지 않았을 경우, 선택한 음료 값이 저장되지 않습니다(다른 음료를 선택하면 다른 값으로 바뀜)
				select = ((Button) event.getSource()).getText();
				x = Integer.parseInt(result.getText());
			}	
		}
	
	@FXML
	
	//************************************ error ****************************************
	//************************************ error ****************************************
	//************************************ error ****************************************
	//************************************ error ****************************************
	//************************************ error ****************************************
	//************************************ error ****************************************
	//금액을 투입하는 경우인데 여기가 에러가 나는 부분입니다 ㅠㅠ
	//x에 select에서 '선택완료'를 눌렀을 때의 계산값을 받아와서 거스름돈을 계산하고 싶은데 x에 값을 어떻게 받아올지 모르겠어요
	//parsing에서도 비슷한걸로 고민했던 기억이 나는데 답은 떠오르지 않고
	//제가 매개변수랑 지역변수, 접근제어자 부분을 열심히 봐도!! 혼자서는 해결이 어려워서 여쭤봅니다..
	//
	private void paymentOption(ActionEvent event) {
		if(((Button) event.getSource()).getText().equals("5000원 투입")){
			//여기 아래의 this.x에 계산해야할 총액을 받아오고 싶어요
			//현재 이 아래의 if문 두개는 통째로 실행이 안되고 있습니다..
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