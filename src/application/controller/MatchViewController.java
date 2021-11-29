package application.controller;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;


public class MatchViewController extends BaseController {

	@FXML
	ImageView joeCenter;
	@FXML
	ImageView macCenter;
	@FXML
	ImageView macRight;
	@FXML
	ImageView macLeft;
	
	public void initialize()
	{
		joeCenter.setVisible(true);
		macCenter.setVisible(true);
		macRight.setVisible(false);
		macLeft.setVisible(false);
	}
	
	@Override
	public void update(long nanoSeconds) {
		// TODO Auto-generated method stub
		
	}
	
	public void setMacCenter()
	{
		macCenter.setVisible(true);
		macRight.setVisible(false);
		macLeft.setVisible(false);
	}
	
	public void setMacRight()
	{
		macCenter.setVisible(false);
		macRight.setVisible(true);
		macLeft.setVisible(false);
	}
	
	public void setMacLeft()
	{
		macCenter.setVisible(false);
		macRight.setVisible(false);
		macLeft.setVisible(true);
	}

	@Override
	public void handle(KeyEvent event) {
		
		
		switch (event.getCode()) {
		
			default:
				System.out.println(event);
		}
	}

	
	
}
