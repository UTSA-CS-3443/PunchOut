package application.controller;

import java.nio.file.Paths;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;

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
	
	String songLoc = "src/ST.wav";
	Media media = new Media(Paths.get(songLoc).toUri().toString());
	AudioClip mediaPlayer = new AudioClip(media.getSource());
	
	public void initialize()
	{
		//music();
	}
	
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
//		try {
//			Parent root = FXMLLoader.load(getClass().getResource("../view/Leaderboard.fxml"));
//			Main.stage.setScene(new Scene(root, 800,800));
//			Main.stage.show();
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
		
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../view/save_score_view.fxml"));
			Main.stage.setScene(new Scene(root, 800,800));
			Main.stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void volUp()
	{
		if(mediaPlayer.getVolume() < 1.0)
		{
			mediaPlayer.setVolume(mediaPlayer.getVolume() + .25);
			System.out.println("Vol up\n");
		}
	}
	
	public void volDown()
	{
		if(mediaPlayer.getVolume() > 0.0)
		{
			mediaPlayer.setVolume(mediaPlayer.getVolume() - .25);
			System.out.println("Vol down\n");
		}
	}
	
	public void music()
	{
		mediaPlayer.setVolume(1.0);
		mediaPlayer.setCycleCount(AudioClip.INDEFINITE);
		mediaPlayer.play();
	}

}
