package application.controller;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * 
 * @author Grandma's Buttermilk Cookies 
 * Controller for the Instructions view
 *
 */
public class InstructionsController extends BaseController
{
	@FXML
	private Label instructField;
	
	public void initialize()
	{
		instructField.setText("\t\t\t\tWelcome to Punch-Out(The School Project)!!\r\n\n\n"
				+ "Your name is Big Cheese (compensating for something?) and you're a new boxer. \nYou've got a couple matches today:\r\n"
				+ "Glass Smcho, King Elephant, and Mike Tyson.\nI'll be here to help coach you through it. The two things you gotta know are your \npunches and dodges.\nYou punch with your left arm using the Z Key on your keyboard\nTo dodge left, you're gonna wanna use your A Key, and to dodge right, D Key.\r\n"
				+ "Press W after dodging to go back to the center.\r\n"
				+ "If the timer runs out, you lose.\r\n"
				+ "Good luck out there, because you're gonna need it!\n\n");
	}
	
	public void toMatchView()
	{
		Main.setView("view/Match.fxml");
	}
	
	public void toMainMenu()
	{
		Main.setView("view/MainMenu.fxml");
	}

	public void update(long nanoSeconds) {
		
	}
}
