package application.controller;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;

public class InstructionsController extends BaseController
{
	@FXML
	private Label instructField;
	
	public void initialize()
	{
		instructField.setText("Welcome to Punch-Out(The School Project)!\r\n"
				+ "Your name is Big Cheese (compensating for something?) and you're a new boxer. You've got a couple matches today:\r\n"
				+ "Glass Smcho, King Elephant, and Mike Tyson. I'll be here to help coach you through it. The two things you gotta know are your punches and dodges. You punch with your left arm using the Z Key on your keyboard and punch with your right\r\n"
				+ "using the X Key on your keyboard. To dodge left, you're gonna wanna use your Left Arrow Key, and to dodge right, Right Arrow Key. \r\n"
				+ "Good luck out there, because you're gonna need it! ");
	}
	
	public void toMatchView()
	{
		   
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../view/MatchView.fxml"));
			Main.stage.setScene(new Scene(root, 800,800));
			Main.stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void toMainMenu()
	{
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../view/MainMenu.fxml"));
			Main.stage.setScene(new Scene(root, 800,800));
			Main.stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(long nanoSeconds) {
		// TODO Auto-generated method stub
		
	}
}
