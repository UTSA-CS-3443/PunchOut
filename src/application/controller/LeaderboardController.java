package application.controller;

import java.util.List;
import java.util.stream.Collectors;

import application.Main;
import application.model.PersistentStorageSingleton;
import application.model.ScoreData;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * 
 * @author Grandma's Buttermilk Cookies
 * Controller for the Leaderboard view
 *
 */
public class LeaderboardController extends BaseController{
	
	@FXML
	Label leaderboardLabel;
	
	public void update(long nanoSeconds) {
		
	}
	
	public void initialize()
	{
		List<ScoreData> scores = PersistentStorageSingleton
		.getInstance()
		.getScores()
		.stream()
		.sorted((s1, s2) -> s2.getWins().compareTo(s1.getWins()))
		.collect(Collectors.toList());
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < scores.size(); ++i) {
			sb.append(String.format("%d. %s\n", i + 1, scores.get(i).toString()));
		}
		
		leaderboardLabel.setText(sb.toString());
	}
	
	public void toTitleScreen()
	{
		Main.setView("view/MainMenu.fxml");
	}

}