package main.yshmeel;
import javafx.application.*;
import javafx.scene.Scene;
import javafx.stage.*;
import javafx.scene.layout.BorderPane;
import javafx.css.*;
import javafx.util.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class yshmeel extends Application {
	@Override
	public void start (Stage primaryStage) {
		try {
            Parent root = FXMLLoader.load(getClass()
                    .getResource("/main/yshmeel/scenes/main.fxml"));
			Scene scene = new Scene(root, 400, 400);
			scene.getStylesheets().add(
					getClass().getResource("assets/application.css").toExternalForm()
			);

			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main (String[] args) {
		System.out.println("Hello world");
		launch(args);
	}
}