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
	
	public static ScoreData PLAYER_SCORE = new ScoreData();
	
	private String username = "Player";
	private int wins = 0;
	
	public ScoreData() {}
	
	public ScoreData(String username, int wins) {
		this.username = username;
		this.wins = wins;
	}
	
	/**
	 * @param commaSeperatedData from csv
	 */
	public ScoreData(String commaSeperatedData) {
		String[] tokens = commaSeperatedData.split(",");
		
		if (tokens.length < 2) return;
		
		this.username = tokens[0];
		this.wins = Integer.parseInt(tokens[1]);
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
		PersistentStorageSingleton.getInstance().saveScore(this);
	}
	
	/**
	 * @return Data for csv
	 */
	public String getData() {
		return String.format("%s,%d", username, wins);
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
	 * @return the wins
	 */
	public Integer getWins() {
		return wins;
	}

	/**
	 * Increments wins
	 */
	public void win() {
		this.wins++;
	}

	@Override
	public String toString() {
		return String.format("%s : %d", this.username, this.wins);
	}
	
	
}
