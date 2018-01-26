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
	//result�� ���Ǳ� �� ������ �� ��������, ���⿡�� ���� ���ݰ��� '���ÿϷ�', '�����ϼ���'���� �޼����� ���ɴϴ�
	private TextField result; 
	
	@FXML
	//operator�� ���� ��ư�� �ǹ��մϴ�. ���⼭ ���ݹ�ư�� ���ڸ� �޾ƿɴϴ�.
	private void operator(ActionEvent event) {
		result.setText(((Button) event.getSource()).getText());
		
	}
	
	@FXML
	//select�� ���ÿϷ�, �߰����� ��ư�� �ǹ��մϴ�.
	//select �޼ҵ�� model class�� ����ǰ�, ������ ������ �� ������ result�� ǥ�����ݴϴ�. 
	private void select(ActionEvent event) {
		if(((Button) event.getSource()).getText().equals("���ÿϷ�")){
			result.setText(model.calculate(select, x, Integer.parseInt(result.getText()))+""+"���� �����ϼ���");
			} else {
				//���ÿϷḦ ������ �ʾ��� ���, ������ ���� ���� ������� �ʽ��ϴ�(�ٸ� ���Ḧ �����ϸ� �ٸ� ������ �ٲ�)
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
	//�ݾ��� �����ϴ� ����ε� ���Ⱑ ������ ���� �κ��Դϴ� �Ф�
	//x�� select���� '���ÿϷ�'�� ������ ���� ��갪�� �޾ƿͼ� �Ž������� ����ϰ� ������ x�� ���� ��� �޾ƿ��� �𸣰ھ��
	//parsing������ ����Ѱɷ� ����ߴ� ����� ���µ� ���� �������� �ʰ�
	//���� �Ű������� ��������, ���������� �κ��� ������ ����!! ȥ�ڼ��� �ذ��� ������� ���庾�ϴ�..
	//
	private void paymentOption(ActionEvent event) {
		if(((Button) event.getSource()).getText().equals("5000�� ����")){
			//���� �Ʒ��� this.x�� ����ؾ��� �Ѿ��� �޾ƿ��� �;��
			//���� �� �Ʒ��� if�� �ΰ��� ��°�� ������ �ȵǰ� �ֽ��ϴ�..
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