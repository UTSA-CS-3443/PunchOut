package application;
	
import application.controller.BaseController;
import application.controller.SaveScoreController;
import application.controller.TitleScreenController;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	private static Stage stage;
	
	private BaseController activeController = new SaveScoreController();
	
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
		try {
			stage = primaryStage;
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
