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
		if(((Button) event.getSource()).getText().equals("���ÿϷ�")){
			result.setText(model.calculate(select, x, Integer.parseInt(result.getText()))+""+"���� �����ϼ���");
			} else {
				select = ((Button) event.getSource()).getText();
				x = Integer.parseInt(result.getText());
			}	
		}
	
	@FXML
	private void paymentOption(ActionEvent event) {
		if(((Button) event.getSource()).getText().equals("5000�� ����")){
			if(this.x < 5000) {
				String minus = String.valueOf(5000-this.x);
				result.setText("������ �Ϸ�Ǿ����ϴ�. �Ž������� "+minus+"�� �Դϴ�");
			} else {
				result.setText("�ݾ��� �����մϴ�");
			}
		} else {
			if(x < 10000) {
				String minus = String.valueOf(10000-x);
				result.setText("������ �Ϸ�Ǿ����ϴ�. �Ž������� "+minus+"�� �Դϴ�");
			} else {
				result.setText("�ݾ��� �����մϴ�");
			}	
		}
		
		result.setText("�ȳ��� ���ʽÿ�..");
	}
}