package application.controller;

import javafx.scene.input.KeyEvent;

/**
 * This is the base controller every other controller should inherit from
 */
public abstract class BaseController {
	
	public abstract void update(long nanoSeconds);

	public void onKeyPress(KeyEvent event) {};
}
