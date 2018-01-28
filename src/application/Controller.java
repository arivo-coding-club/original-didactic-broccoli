package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class Controller {

	private String push = "";
	private int x = 0;
	private int y = 0;
	private Model model = new Model();
	
	@FXML
	private TextField result;
		

	@FXML
	//������ �ݾ�
	private void push(ActionEvent event) {
		result.setText(((Button) event.getSource()).getText()+"");
	}
	
	@FXML
	private void beverage(ActionEvent event) {
		//if((((Button) event.getSource()).getText()).equals("5000")){
		int y = Integer.parseInt(((Button) event.getSource()).getText());
		int x = Integer.parseInt(result.getText());//�̰� ����� 10000���� �ǰ�, ������ 5000������
		result.setText(model.calculate(push, x, y)+"");
			
		push = result.getText();
	}
	
	@FXML
	private void change(ActionEvent event) {
		result.setText("");
	}
}