package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
//import javafx.scene.control.TextField;


public class Main extends Application {
	@Override
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
