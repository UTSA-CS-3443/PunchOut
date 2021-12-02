package application.model;

import javafx.scene.input.KeyEvent;

/**
 * 
 * @author Grandma's Buttermilk Cookies
 * Model for the Player 
 */
public class Player extends Sprite {
	
	public Player(String imageUrl, double width, double height, double posX, double posY) {
		super(imageUrl, width, height, posX, posY);
	}

	@Override
	public void update(long nanoSeconds) {
		// TODO Auto-generated method stub

	}

	public void onKeyPress(KeyEvent event) {
		
	}
}
