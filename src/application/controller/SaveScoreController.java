/**
 * 
 */
package application.controller;

import application.Main;
import application.model.PersistentStorageSingleton;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * @author cassidybaskerville
 */
public class SaveScoreController extends BaseController {
	
	@FXML
	TextField usernameField;
	
	@FXML
	TextField scoreField;
	
	@FXML
	Button saveButton;

	@Override
	public void update(long nanoSeconds) {
		
	}
	
	public void onSaveScore() {
		
		PersistentStorageSingleton storage = PersistentStorageSingleton.getInstance();
		
		try {
			storage.saveScore(usernameField.getText(), Integer.parseInt(scoreField.getText()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
