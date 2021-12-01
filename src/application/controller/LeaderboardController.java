package application.controller;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;

public class LeaderboardController extends BaseController{
	
	@FXML
	Label leaderboardLabel;
	
	@Override
	public void update(long nanoSeconds) {
		// TODO Auto-generated method stub
		
	}
	
	public void initialize()
	{
		leaderboardLabel.setText("1. SAM\n2. JAS\n3.CAS\n4.STE\n5.TIM\n6.SAM\n7.SAM\n8.TIM\n9.CAS\n10.STE\n");
	}
	
	public void toTitleScreen()
	{
		   
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../view/MainMenu.fxml"));
			Main.stage.setScene(new Scene(root, 800,800));
			Main.stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}