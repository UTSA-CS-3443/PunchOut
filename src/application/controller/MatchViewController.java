package application.controller;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;


public class MatchViewController extends BaseController{
	
	@FXML
	ImageView joeCenter;
	@FXML
	ImageView macCenter;
	@FXML
	ImageView macRight;
	@FXML
	ImageView macLeft;
	
	public MatchViewController()
	{
		Main.setActiveController(this);
	}
	
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
	public void onKeyPress(KeyEvent event) 
	{

		/*
		switch(event.getCode())
		{
		case LEFT:  System.out.println("Left\n");
					macCenter.setVisible(false);
					macLeft.setVisible(true);
					macRight.setVisible(false);
					break;
		case RIGHT: System.out.println("Right\n");
					macCenter.setVisible(false);
					macLeft.setVisible(false);
					macRight.setVisible(true);
					break;
		case UP: 	System.out.println("Center\n");
					macCenter.setVisible(true);
					macLeft.setVisible(false);
					macRight.setVisible(false);
					break;
		default:
					break;
		}
		*/
	}
	
}
