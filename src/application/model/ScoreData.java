/**
 * 
 */
package application.model;

import java.util.*;

/**
 * @author cassidybaskerville
 *
 */
public class ScoreData {
	
	private String username;
	private int score;
	private String time;
	
	public ScoreData(String username, int score, String time) {
		this.username = username;
		this.score = score;
		this.time = time;
	}
	
	/**
	 * @param commaSeperatedData from csv
	 */
	public ScoreData(String commaSeperatedData) {
		String[] tokens = commaSeperatedData.split(",");
		
		if (tokens.length < 3) return;
		
		this.username = tokens[0];
		this.score = Integer.parseInt(tokens[1]);
		this.time = tokens[2];
	}
	
	/**
	 * @return All High Scores
	 */
	public static List<ScoreData> getAllScores() {
		return PersistentStorageSingleton.getInstance().getScores();
	}
	
	/**
	 * This method saves the score to a file in the data folder
	 */
	public void saveToPersistentStorage() {
		PersistentStorageSingleton storage = PersistentStorageSingleton.getInstance();
		storage.saveScore(this);
	}
	
	/**
	 * @return Data for csv
	 */
	public String getData() {
		return String.format("%s,%d,%s", username, score, time);
	}
	
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}
	
	
}
