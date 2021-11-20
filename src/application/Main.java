package application;
	
import application.controller.BaseController;
import application.controller.TitleScreenController;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	private BaseController activeController = new TitleScreenController();
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
			/**
			 * This is the main game loop.
			 * The active view controller should be referenced in this main class and that controller's update method
			 * will be called from here.
			 */
			new AnimationTimer() {

				/**
				 * @param now: time in nanoseconds
				 */
				@Override
				public void handle(long now) {
					activeController.update(now);
				}
				
			}.start();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}