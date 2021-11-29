package application.controller;

import application.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class LeaderboardController extends BaseController{
	
	@Override
	public void update(long nanoSeconds) {
		// TODO Auto-generated method stub
		
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