/**
 * 
 */
package application.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * @author cassidybaskerville
 */
public final class PersistentStorageSingleton {
	
	private final String highScoresFile = "high_scores.csv";
	
	private PersistentStorageSingleton() {}
	
	private static PersistentStorageSingleton INSTANCE = null;
	
	public static PersistentStorageSingleton getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new PersistentStorageSingleton();
		}
		return INSTANCE;
	}
	
	/**
	 * Saves your score to a csv file
	 * @param username of player
	 * @param score of player
	 */
	public void saveScore(String username, int score) {
		System.out.printf("Saving score for %s\n", username);
		
		File csvFile = new File(highScoresFile);
		
		try {
			PrintWriter out = new PrintWriter(csvFile);
			
			out.format("%s,%d", username, score);
			
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
