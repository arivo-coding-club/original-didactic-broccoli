package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	//JavaFx로 자판기를 만들고 이름을 BendingMachine이라고 했습니다
	public void start(Stage stage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("newBendingMachine.fxml"));
		stage.setScene(new Scene(root));
		stage.setTitle("BendingMachine");
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
