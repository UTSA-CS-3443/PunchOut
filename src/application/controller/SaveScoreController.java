/**
 * 
 */
package application.controller;

import application.Main;
import application.model.ScoreData;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * @author Grandma's Buttermilk Cookies
 * Controller for the SaveScore view
 */
public class SaveScoreController extends BaseController {
	
	@FXML
	TextField usernameField;
	
	@FXML
	Button saveButton;
	
	@FXML
	Button incWins;

	public void update(long nanoSeconds) {
		
	}
	
	public void onIncrementWins() {
		ScoreData.PLAYER_SCORE.win();
		incWins.setText(String.format("Cheat Code %d", ScoreData.PLAYER_SCORE.getWins()));
	}
	
	public void onSaveScore() {


		ScoreData.PLAYER_SCORE.setUsername(usernameField.getText());
		ScoreData.PLAYER_SCORE.saveToPersistentStorage();
		Main.setView("view/Leaderboard.fxml");
	}
}
