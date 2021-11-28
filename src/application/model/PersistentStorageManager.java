/**
 * 
 */
package application.model;

import java.io.File;
import java.io.PrintWriter;

/**
 * @author cassidybaskerville
 */
public final class PersistentStorageManager {
	
	private final String highScoresFile = "high_scores.csv";
	
	private PersistentStorageManager() {}
	
	private static PersistentStorageManager INSTANCE = null;
	
	public static PersistentStorageManager getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new PersistentStorageManager();
		}
		return INSTANCE;
	}
	
	/**
	 * Saves your score to a csv file
	 * @param username of player
	 * @param score of player
	 */
	public void save(String username, int score) {
		
		File csvFile = new File(highScoresFile);
		
		try {
			PrintWriter out = new PrintWriter(csvFile);
			
		} catch (FileNotFoundException e) {
			
		}
		
	}
}
