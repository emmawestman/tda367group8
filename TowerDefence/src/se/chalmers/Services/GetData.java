package se.chalmers.Services;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import se.chalmers.TowerDefence.HighScore;

public class GetData {
	
	
	static FileInputStream fis = null;
	static ObjectInputStream in = null;
	
	public static int getHighScore(String levelName) {
		List<HighScore> highScores = null;
		int highScore = -1;
		try {
			highScores = readFromHighScoreFile();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int index = -1;
		for (int i=0; i<highScores.size(); i++ ) {
			
			if (highScores.get(i).getLevelName().equals(levelName)) {
				index = highScores.indexOf(highScores.get(i));
				highScore = highScores.get(index).getPoints();
			}
		}
		return highScore;
		
	}
	
//	public boolean isLevelUnlocked(HighScore hs) {
//		readFromHighScoreFile();
//		return highScores.contains(hs);
//		
//	}
	
	public static List <HighScore> readFromHighScoreFile() throws FileNotFoundException {
		List<HighScore> highScores = null;
		try {
			fis = new FileInputStream("highScore.txt");
			in = new ObjectInputStream(fis);
			highScores = (List <HighScore>) in.readObject();
			in.close();
		} catch (IOException e) {
			
		} catch (ClassNotFoundException e) {
			
		
	}
		return highScores;
	
	}
}
