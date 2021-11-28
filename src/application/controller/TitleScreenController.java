package application.controller;

import java.io.IOException;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
	
	@FXML
	void newGame(ActionEvent event) throws IOException {
		   
		    AnchorPane rootPane = FXMLLoader.load( Main.class.getResource("view/MatchView.fxml"));
		    MainMenuPane.getChildren().setAll(rootPane);
		   
	}
	
	@FXML
	void continueGame(ActionEvent event) throws IOException {
		   
		    AnchorPane rootPane = FXMLLoader.load( Main.class.getResource("view/MatchView.fxml"));
		    MainMenuPane.getChildren().setAll(rootPane);
		   
	}

}
