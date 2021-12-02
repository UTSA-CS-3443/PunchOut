package application.controller;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

/**
 * This is the base controller every other controller should inherit from
 */
public abstract class BaseController implements EventHandler<KeyEvent> {
	
	public abstract void update(long nanoSeconds);

	@Override
	public void handle(KeyEvent event) {}
}
