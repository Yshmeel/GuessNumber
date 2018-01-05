package main.yshmeel;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Random;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
public class yshmeelController implements Initializable {
	@FXML
	private TextField number;
	Integer randomNumber = 0;
	Integer playerNumber = randomNumber;
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
	@FXML
	public void startGame(javafx.event.ActionEvent event) {
		Random rand = new Random();
		randomNumber = rand.nextInt(30);
		playerNumber = Integer.parseInt(number.getText());
		if(playerNumber > 30) {
			playerNumber = 30;
		} else if(playerNumber < 0) {
			playerNumber = 1;
		}
		try {
	        Parent root = FXMLLoader.load(getClass()
	                .getResource("/main/yshmeel/scenes/game.fxml"));
	        Scene scene = new Scene(root);
	        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	        appStage.setScene(scene);
	        appStage.show();	
	        Label gameTitle = (Label) scene.lookup("#gameTitle");
	        Label computerNumber = (Label) scene.lookup("#computerNumber");
	        Label yourNumber = (Label) scene.lookup("#yourNumber");
			if(randomNumber == playerNumber) {
				gameTitle.setText("Вы выиграли");
			} else {
				gameTitle.setText("Вы проиграли");
			}

			computerNumber.setText(String.format("Число компьютера: %d", randomNumber));
			yourNumber.setText(String.format("Твое число: %d", playerNumber));
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
	public void backToMenu(javafx.event.ActionEvent event) {
		try {
			randomNumber = 0;
			playerNumber = 0;
	        Parent root = FXMLLoader.load(getClass()
	                .getResource("/main/yshmeel/scenes/main.fxml"));
	        Scene scene = new Scene(root);
	        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	        appStage.setScene(scene);
	        appStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}