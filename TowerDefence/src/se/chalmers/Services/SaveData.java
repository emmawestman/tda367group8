package se.chalmers.Services;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


import se.chalmers.TowerDefence.HighScore;

public class SaveData {
	static FileOutputStream fos = null;
	static ObjectOutputStream out = null;
	
	public static void saveHighScore(HighScore hs) {
		List <HighScore> highScores=null;
		try {
			highScores = GetData.readFromHighScoreFile();
			
			if(!(highScores==null)) {
				highScores.add(hs);
			}else{
				throw new FileNotFoundException();
			}
				
		}catch (FileNotFoundException e) {
			highScores = new ArrayList <HighScore> ();
			highScores.add(hs);
			
		}

		try {
			fos = new FileOutputStream("highScore.txt");
			out = new ObjectOutputStream(fos);
			out.writeObject(highScores);
			out.close();
		} catch (IOException e) {
			

		}

	}
}