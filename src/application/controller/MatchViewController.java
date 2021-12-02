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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.paint.Color;
import javafx.util.Duration;


public class MatchViewController extends BaseController {

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
	
	String songLoc2 = "src/Punch.mp3";
	Media media2 = new Media(Paths.get(songLoc2).toUri().toString());
	AudioClip mediaPlayer2 = new AudioClip(media2.getSource());
	boolean block;
	int aiAction;
	private static final Integer STARTTIME = 60;
    private Timeline timeline;
    private IntegerProperty timeSeconds = new SimpleIntegerProperty(STARTTIME);
    
    public void countDown(){
        timeLabel.textProperty().bind(timeSeconds.asString());
        timeLabel.setTextFill(Color.RED);
        timeLabel.setStyle("-fx-font-size: 4em;");


        if (timeline != null) {
            timeline.stop();
        }
        timeSeconds.set(STARTTIME);
        timeline = new Timeline();
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(STARTTIME+1),new KeyValue(timeSeconds, 0)));
        timeline.playFromStart();
    }
    
    @FXML
    void fight(ActionEvent event)
    {
    	countDown();
    }
	
	BigDecimal progress = new BigDecimal(String.format("%.2f",1.0));
	
    public void initialize(URL arg0, ResourceBundle arg1) {

        healthPlayer1.setStyle("-fx-accent: #00FF00;");
        healthPlayer2.setStyle("-fx-accent: #00FF00;");

    }

    public void progess() {

    	progress = new BigDecimal(String.format("%.2f", progress.doubleValue() - 0.1));
        healthPlayer1.setProgress(progress.doubleValue());
        healthPlayer2.setProgress(progress.doubleValue());
    }
    
    public void drainPlayer1() {
    	progress = new BigDecimal(String.format("%.2f", progress.doubleValue() - 0.1));
    	healthPlayer1.setProgress(progress.doubleValue());
    	
    }
    
    public void drainPlayer2() {
    	progress = new BigDecimal(String.format("%.2f", progress.doubleValue() - 0.1));
    	healthPlayer2.setProgress(progress.doubleValue());
    }
    
    public void progressHealth(ActionEvent event) {
    	progess();
    }
	
	public void initialize()
	{
		joeCenter.setVisible(true);
		macCenter.setVisible(true);
		macRight.setVisible(false);
		macLeft.setVisible(false);
		countDown();
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
	
	public void toMainMenu()
	{
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../view/MainMenu.fxml"));
			Main.stage.setScene(new Scene(root, 800,800));
			Main.stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void userPunch()
	{
		if(macCenter.isVisible() == true && block == false)
		{
			System.out.println("User Punch");
			actionLabel.setText("Rocky punches Drago!");
			drainPlayer2();
			mediaPlayer2.setVolume(1.0);
			mediaPlayer2.play();
		}
		else
		{
			actionLabel.setText("Rocky stumbles and misses his punch!");
		}
	}
	
	public void enemyAI()
	{
		aiAction = (int)(Math.random() * ((2)));
	}
	
	public void enemyPunch()
	{
		if(macCenter.isVisible() == true)
		{
			drainPlayer1();
			actionLabel.setText("Drago punches Rocky!");
			mediaPlayer2.setVolume(1.0);
			mediaPlayer2.play();
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
		case L:		userPunch();
					break;
		case I:		enemyAI();
					if(aiAction == 0)
					{
						enemyPunch();
						block = false;
					}
					else if(aiAction == 1)
					{
						enemyBlock();
					}
					break;
		default:
					break;
		}
	}
}
