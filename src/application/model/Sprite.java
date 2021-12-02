package application.model;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * @author Grandma's Buttermilk Cookies
 * This class can be inherited by the player and the enemy npc
 */
public abstract class Sprite {

	protected Image image;
	
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
	
	public void render(GraphicsContext gc) {
		gc.drawImage(image, posX, posY);
	}
	
	public Rectangle2D getBoundry() {
		return new Rectangle2D(posX, posY, width, height);
	}
	
	public boolean intersects(Sprite s) {
		return s.getBoundry().intersects(this.getBoundry());
	}
}
