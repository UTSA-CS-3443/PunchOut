/**
 * 
 */
package application.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author Grandma's Buttermilk Cookies
 * Model for the storage or player scores
 */
public final class PersistentStorageSingleton {
	
	private static final String dataFolder = "src/data";
	
	private static final String highScoresFile = "high_scores.csv";
	
	private static PersistentStorageSingleton INSTANCE = null;
	
	public static PersistentStorageSingleton getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new PersistentStorageSingleton();
		}
		return INSTANCE;
	}
	
	/**
	 * Saves your score to a csv file
	 * @param score of the user
	 */
	public void saveScore(ScoreData score) {
		
		File csvFile = new File(String.format("%s/%s", dataFolder, highScoresFile));

		try {

			PrintWriter out = new PrintWriter(new FileOutputStream(csvFile, true));
			
			out.write("\n" + score.getData());
			
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @returns List of all high scores
	 */
	public List<ScoreData> getScores() {
		
		File csvFile = new File(String.format("%s/%s", dataFolder, highScoresFile));
		
		try {
			Scanner sc = new Scanner(csvFile);
			sc.useDelimiter("\n");
			List<ScoreData> scores = sc.tokens().map(ScoreData::new).collect(Collectors.toList());
			sc.close();
			return scores;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return List.of();
		}
	}
}
