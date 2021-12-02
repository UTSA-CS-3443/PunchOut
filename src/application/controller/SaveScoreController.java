/**
 * 
 */
package application.controller;

import application.Main;
import application.model.PersistentStorageSingleton;
import application.model.ScoreData;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

/**
 * @author cassidybaskerville
 */
public class SaveScoreController extends BaseController {
	
	@FXML
	TextField usernameField;
	
	@FXML
	Button saveButton;
	
	@FXML
	Button incWins;

	@Override
	public void update(long nanoSeconds) {
		
	}
	
	public void onIncrementWins() {
		System.out.println("Increment");
		ScoreData.PLAYER_SCORE.win();
		incWins.setText(String.format("Cheat Code %d", ScoreData.PLAYER_SCORE.getWins()));
	}
	
	public void onSaveScore() {
		ScoreData.PLAYER_SCORE.setUsername(usernameField.getText());
		ScoreData.PLAYER_SCORE.saveToPersistentStorage();
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../view/Leaderboard.fxml"));
			Main.stage.setScene(new Scene(root, 800,800));
			Main.stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
