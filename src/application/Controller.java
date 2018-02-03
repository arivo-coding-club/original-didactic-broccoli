package application;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;


public class Controller {

	String newLine = "\n";
	
	private Model model = new Model();
	
	@FXML
	private TextArea result;
		

	@FXML
	//������ �ݾ��� ǥ���ϰ� ����մϴ�
	private void push(ActionEvent event) {
		result.setText(pushButton(event));
	}
	
	//������ʹ� ���Ḧ Ŭ������ ��, (1)������ �ݾ׿��� ���� ������ ���� (2)�ش� ���� ��� ���̴� ��ư�Դϴ�
	//�ٸ� Ŭ������ ������� ������ javafx�� ��ư�� ControllerŬ������ �־�� ������ ���� �ʾƼ� ���⿡ �״�� �ξ����ϴ�
	//�ڡڡڡڡ�??�޼ҵ�� ����� ������ �ߴµ� ����. stock1, stock2�� stock+i�� ����� ���� ����.
	
//	public void beverage(ActionEvent event, int i) {
//		BeverageCalculation.beverageCalculation(event);
//		result.setText(Stock.(stock+"i")());
//	}
	
	@FXML
	private void beverage1(ActionEvent event) {
		BeverageCalculation.beverageCalculation(event);
		result.setText(Stock.stock1());
	}	
	
	@FXML
	private void beverage2(ActionEvent event) {
		BeverageCalculation.beverageCalculation(event);
		result.setText(Stock.stock2());
	}	
	
	@FXML
	private void beverage3(ActionEvent event) {
		BeverageCalculation.beverageCalculation(event);
		result.setText(Stock.stock3());
	}	
	@FXML
	private void beverage4(ActionEvent event) {
		BeverageCalculation.beverageCalculation(event);
		result.setText(Stock.stock4());
	}	
	@FXML
	private void beverage5(ActionEvent event) {
		BeverageCalculation.beverageCalculation(event);
		result.setText(Stock.stock5());
	}	
	@FXML
	private void beverage6(ActionEvent event) {
		BeverageCalculation.beverageCalculation(event);
		result.setText(Stock.stock6());
	}	
	
	@FXML
	//ī�带 �������� ��� ������ �� 7�� �Է��ؼ�, ���ݰ����� �ƴ� ī�� ������ �ǵ��� �մϴ�
	private void card(ActionEvent event) throws Exception{
		result.setText("ī�� ���ԿϷ�\n���Ḧ ������");
		model.addRemain(7);
	}
	
	@FXML
	//��� �˷��ݴϴ�
	private void stock(ActionEvent event) {
		result.setText(Stock.HowManyBeverageRemain());
	}
	
	@FXML
	//�Ž������� ��ȯ�մϴ�
	private void change(ActionEvent event) {
		changeButton(event);
	}
	
	
	public String pushButton(ActionEvent event) {
		int amount = Integer.parseInt(((Button)event.getSource()).getText());
		
		// ���Աݾ׿� �߰�
		model.addRemain(amount);
		
		//��ü ���Ե� �ݾ��� result�� ǥ�� 	
		return Model.getRemain()+"";
	}

	public void changeButton(ActionEvent event) {
		if(Model.getRemain()==7) {
			result.setText("ī�� ��ȯ�Ϸ�");
			//ī�� ��ȯ�� ������ ���� 7�� ����. �̶�, ī�带 ���� �ʰ� ������ ������ ��� ���� �߻�
			Model.buy(7);
			//return "ī�� ��ȯ�Ϸ�";
		} else {	
		new Thread(() ->  {
			// �۾� ������ (UI �����尡�ƴ�)
			while (Model.getRemain() > 100) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				Platform.runLater(() -> {
					result.setText(model.decreaseRemain()+"");
				});
			}
		}).start();
		}
	}
	
}