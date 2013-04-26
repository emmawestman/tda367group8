package se.chalmers.towerdefence.files;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


import se.chalmers.towerdefence.model.HighScore;

public class SaveData {
	static FileOutputStream fos = null;
	static ObjectOutputStream out = null;

	public static void saveHighScore(HighScore hs) {
		List <HighScore> highScores=null;
		if (isNewHighScore(hs) == false) {
			//do nothing
		}else {
			try {
				highScores = GetData.readFromHighScoreFile();
				if (isNewHighScore(hs) == true && findHighScore(hs) != null) {
					highScores.remove(findHighScore(hs));
				}

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
	public static boolean isNewHighScore(HighScore hs) {
		HighScore oldHighScore = findHighScore(hs);
		if (oldHighScore == null) {
			return true;
		}else {
			return (hs.getPoints() > oldHighScore.getPoints());
		}

	}


	public static HighScore findHighScore(HighScore hs) {
		List<HighScore> highScores = null;
		String levelName = hs.getLevelName();
		try {
			highScores = GetData.readFromHighScoreFile();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (highScores == null) {
			return null;
		}else {

			for (int i = 0; i < highScores.size(); i++) {
				if (highScores.get(i).getLevelName().equals(levelName)) {
					return highScores.get(i);
				}
			}
		} 
		return null;

	}
}