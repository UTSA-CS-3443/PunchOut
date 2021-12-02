package application.controller;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 * Controller for the title screen
 */
public class TitleScreenController extends BaseController {
	@FXML
	private Button newGameBtn;

	@FXML
	private AnchorPane MainMenuPane;

	@FXML
	private Button continueBtn;
	
	@Override
	public void update(long nanoSeconds) {
		
	}
	
	public void newGame()
	{
		
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../view/Instructions.fxml"));
			Main.stage.setScene(new Scene(root, 800,800));
			Main.stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void toLeaderboard()
	{
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../view/Leaderboard.fxml"));
			Main.stage.setScene(new Scene(root, 800,800));
			Main.stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
