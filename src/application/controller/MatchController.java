package application.controller;

import java.math.BigDecimal;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import application.Main;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.paint.Color;
import javafx.util.Duration;

/**
 * 
 * @author view/Leaderboard.fxml
 * Controller for the Match view
 */
public class MatchController extends BaseController {

	@FXML
	ImageView joeCenter;
	@FXML
	ImageView macCenter;
	@FXML
	ImageView macRight;
	@FXML
	ImageView macLeft;
	@FXML
	ProgressBar healthPlayer1;
	@FXML
	ProgressBar healthPlayer2;
	@FXML
	Label timeLabel;
	@FXML
	Button testButton;
	@FXML
	Button beginGame;
	@FXML
	Label actionLabel;
	
	String songLoc2 = "src/data/music/Punch.mp3";
	Media media2 = new Media(Paths.get(songLoc2).toUri().toString());
	AudioClip mediaPlayer2 = new AudioClip(media2.getSource());
	
	
	boolean block;
	int aiAction;
	
	private static final Integer STARTTIME = 60;
    private Timeline timeline = new Timeline();
    private Timeline enemyPunching = new Timeline();
    private IntegerProperty timeSeconds = new SimpleIntegerProperty(STARTTIME);
    
    BigDecimal progress = new BigDecimal(String.format("%.2f",1.0));
    
    public void countDown(){
    	
        timeLabel.textProperty().bind(timeSeconds.asString());
        timeLabel.setTextFill(Color.RED);
        timeLabel.setStyle("-fx-font-size: 4em;");
        
        timeSeconds.set(STARTTIME);
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(STARTTIME+1),new KeyValue(timeSeconds, 0)));
        timeline.playFromStart();
        timeline.setOnFinished(e -> toGameOver());
        
    }
    
    
    public void fight()
    {
    	enemyPunching.getKeyFrames().add(new KeyFrame(Duration.seconds(2),
    			e -> enemyAction()));
    	enemyPunching.setCycleCount(60);
    	enemyPunching.play();
    	countDown();
    	
    }
	
    public void initialize(URL arg0, ResourceBundle arg1) {

        healthPlayer1.setStyle("-fx-accent: #00FF00;");
        healthPlayer2.setStyle("-fx-accent: #00FF00;");

    }
    
    public void drainPlayer1() {
    	progress = new BigDecimal(String.format("%.2f", progress.doubleValue() - 0.1));
    	healthPlayer1.setProgress(progress.doubleValue());
    	
    }
    
    public void drainPlayer2() {
    	progress = new BigDecimal(String.format("%.2f", progress.doubleValue() - 0.1));
    	healthPlayer2.setProgress(progress.doubleValue());
    }
	
	public void initialize()
	{
		joeCenter.setVisible(true);
		macCenter.setVisible(true);
		macRight.setVisible(false);
		macLeft.setVisible(false);
		fight();
	}
	
	public void update(long nanoSeconds) {
		
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
	
	public void toMainMenu()
	{
		Main.setView("view/MainMenu.fxml");
	}
	
	public void toGameOver()
	{
		timeline.stop();
		enemyPunching.stop();
		Main.setView("view/GameOver.fxml");
	}
	
	public void toSaveScore()
	{
		timeline.stop();
		enemyPunching.stop();
		Main.setView("view/SaveScore.fxml");
	}
	
	public void userPunch()
	{
		if(macCenter.isVisible() == true && block == false)
		{
			actionLabel.setText("Rocky punches Drago!");
			drainPlayer2();
			mediaPlayer2.setVolume(1.0);
			mediaPlayer2.play();
			if(healthPlayer2.getProgress() <= 0)
			{
				toSaveScore();
			}
		}
		else
		{
			actionLabel.setText("Rocky stumbles and misses his punch!");
		}
	}
	
	public int enemyAI()
	{
		return (int)(Math.random() * ((2)));
	}
	
	public void enemyPunch()
	{
		if(macCenter.isVisible() == true)
		{
			drainPlayer1();
			actionLabel.setText("Drago punches Rocky!");
			mediaPlayer2.setVolume(1.0);
			mediaPlayer2.play();
			
			if(healthPlayer1.getProgress() <= 0)
			{
				toGameOver();
			}
		}
		else
		{
			actionLabel.setText("Drago misses his punch!");
		}
	}
	
	public void enemyBlock()
	{
		block = true;
		actionLabel.setText("Drago raises his guard!");
	}
	
	public void enemyAction()
	{
		aiAction = enemyAI();
		if(aiAction == 0)
		{
			enemyPunch();
			block = false;
		}
		else if(aiAction == 1)
		{
			enemyBlock();
		}
	}

	@Override
	public void handle(KeyEvent event) 
	{	
		switch(event.getCode())
		{
		case A:  	setMacLeft();
					break;
		case D: 	setMacRight();
					break;
		case W: 	setMacCenter();
					break;
		case Z:		userPunch();
					break;
//		case I:		aiAction = enemyAI();
//					if(aiAction == 0)
//					{
//						enemyPunch();
//						block = false;
//					}
//					else if(aiAction == 1)
//					{
//						enemyBlock();
//					}
//					break;
		default:	
					break;
		}
	}
}
