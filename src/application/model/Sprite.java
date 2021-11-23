package application.model;

import javafx.scene.image.Image;

/**
 * This class can be inherited by the player and the enemy npc
 */
public abstract class Sprite {

	protected Image image;

	protected int health = 100;
	
	protected double posX = 0;
	protected double posY = 0;
	
	protected double width;
	protected double height;
	
	public Sprite(
			String imageUrl, 
			double width, 
			double height,
			double posX,
			double posY
			) {
		this.image = new Image(imageUrl, width, height, true, false);
		this.width = width;
		this.height = height;
		this.posX = posX;
		this.posY = posY;
	}
	
	public abstract void update(long nanoSeconds);
}
