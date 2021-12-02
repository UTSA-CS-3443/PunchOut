package application;
	
import java.nio.file.Paths;

import application.controller.BaseController;
import application.controller.TitleScreenController;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;


public class Main extends Application {
	
	public static Main INSTANCE;
	
	public static Stage stage;
	
	public static BaseController activeController = new TitleScreenController();
	
	String songLoc = "src/data/music/EOT.mp3";
	Media media = new Media(Paths.get(songLoc).toUri().toString());
	AudioClip mediaPlayer = new AudioClip(media.getSource());
	
	/**
	 * Static method that shows the given scene on the main stage
	 * @param fxml view to show
	 */
	public static void changeScene(String fxml) {
		try {
			Parent pane = FXMLLoader.load(Main.class.getResource(fxml));
			
			stage.getScene().setRoot(pane);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void start(Stage primaryStage) {
		INSTANCE = this;
		stage = primaryStage;
		Main.setView("view/MainMenu.fxml");
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
	}
	
	public static void setView(String fxml) {
		
		try {
			FXMLLoader loader = new FXMLLoader(INSTANCE.getClass().getResource(fxml));
			Parent root = loader.load();
			
			BaseController controller = loader.<BaseController>getController();

			Scene scene = new Scene(root, 800,800);
			scene.addEventHandler(KeyEvent.KEY_PRESSED, controller);
			Main.stage.setScene(scene);
			Main.stage.show();
			scene.addEventHandler(KeyEvent.KEY_PRESSED, key -> {
				activeController.handle(key);
			});
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void setActiveController(BaseController tempController)
	{
		activeController = tempController;
	}
	
	public void music()
	{
		mediaPlayer.setVolume(1.0);
		mediaPlayer.setCycleCount(AudioClip.INDEFINITE);
		mediaPlayer.play();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
