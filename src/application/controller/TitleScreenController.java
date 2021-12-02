package application.controller;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 * @author Grandma's Buttermilk Cookies
 * Controller for the title screen
 */
public class TitleScreenController extends BaseController {
	@FXML
	private Button newGameBtn;

	@FXML
	private AnchorPane MainMenuPane;

	@FXML
	private Button continueBtn;
	
	public void update(long nanoSeconds) {
		
	}
	
	public void newGame()
	{
		Main.setView("view/Instructions.fxml");
	}
	
	public void toLeaderboard()
	{
		Main.setView("view/SaveScore.fxml");
	}
}
