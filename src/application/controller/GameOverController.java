package application.controller;

import application.Main;

public class GameOverController extends BaseController {
	
	public void update(long nanoSeconds) {
		
	}

	public void toMainMenu()
	{
		Main.setView("view/MainMenu.fxml");
	}
}
