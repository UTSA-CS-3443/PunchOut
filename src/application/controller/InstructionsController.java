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
		instructField.setText("\t\t\t\t\t\t\tWelcome to Punch-Out(The School Project)!!\r\n\n\n"
				+ "Your name is Big Cheese (compensating for something?) and you're a new boxer. You've got a couple matches today:\r\n"
				+ "Glass Smcho, King Elephant, and Mike Tyson.\nI'll be here to help coach you through it. The two things you gotta know are your punches and dodges.\nYou punch with your left arm using the Z Key on your keyboard\nand punch with your right"
				+ "using the X Key on your keyboard.\nTo dodge left, you're gonna wanna use your Left Arrow Key, and to dodge right, Right Arrow Key.\r\n"
				+ "Good luck out there, because you're gonna need it!\n\n");
	}
	
	public void toMatchView()
	{
		Main.setView("view/MatchView.fxml");
		/*
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../view/MatchView.fxml"));
			Main.stage.setScene(new Scene(root, 800,800));
			Main.stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}*/
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
