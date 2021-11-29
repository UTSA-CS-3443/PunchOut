/**
 * 
 */
package application.controller;

import application.Main;
import application.model.PersistentStorageSingleton;
import application.model.ScoreData;
import javafx.fxml.FXML;
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

	@Override
	public void update(long nanoSeconds) {
		
	}
	
	public void onSaveScore() {
		
		int mockScore = 100;
		String mockTime = "1:20";
		
		ScoreData score = new ScoreData(usernameField.getText(), mockScore, mockTime);
		
		score.saveToPersistentStorage();
		
		
	}
}
