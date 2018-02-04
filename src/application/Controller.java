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
	//투입한 금액을 표시하고 계산합니다
	private void push(ActionEvent event) {
		result.setText(pushButton(event));
	}
	
	//여기부터는 음료를 클릭했을 때, (1)투입한 금액에서 음료 가격을 빼고 (2)해당 음료 재고를 줄이는 버튼입니다
	//다른 클래스로 만들려고 했지만 javafx의 버튼은 Controller클래스에 있어야 오류가 나지 않아서 여기에 그대로 두었습니다
	//★★★★★??메소드로 만들어 보려고 했는데 실패. stock1, stock2등 stock+i로 만드는 것이 오류.
	
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
	//카드를 투입했을 경우 임의의 수 7을 입력해서, 현금결제가 아닌 카드 결제가 되도록 합니다
	private void card(ActionEvent event) throws Exception{
		result.setText("카드 투입완료\n음료를 고르세요");
		model.addRemain(7);
	}
	
	@FXML
	//재고를 알려줍니다
	private void stock(ActionEvent event) {
		result.setText(Stock.HowManyBeverageRemain());
	}
	
	@FXML
	//거스름돈을 반환합니다
	private void change(ActionEvent event) {
		changeButton(event);
	}
	
	
	public String pushButton(ActionEvent event) {
		int amount = Integer.parseInt(((Button)event.getSource()).getText());
		
		// 투입금액에 추가
		model.addRemain(amount);
		
		//전체 투입된 금액을 result에 표시 	
		return Model.getRemain()+"";
	}

	public void changeButton(ActionEvent event) {
		if(Model.getRemain()==7) {
			result.setText("카드 반환완료");
			//카드 반환시 임의의 변수 7을 제함. 이때, 카드를 빼지 않고 현금을 투입할 경우 오류 발생
			Model.buy(7);
			//return "카드 반환완료";
		} else {	
		new Thread(() ->  {
			// 작업 스레드 (UI 스레드가아님)
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