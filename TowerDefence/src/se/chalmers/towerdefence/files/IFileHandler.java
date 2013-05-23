package se.chalmers.towerdefence.files;

import java.io.FileNotFoundException;
import java.util.List;
import se.chalmers.towerdefence.model.HighScore;

/**
 * An interface to describe the class FileHandler. 
 * @author Jonathan, Oskar, Julia, Emma
 *
 */
public interface IFileHandler {
	
	public int getHighScore(String levelName);
	
	public boolean isLevelUnlocked(String levelName);
	
	public List <HighScore> readFromHighScoreFile() throws FileNotFoundException;
	
	public void saveHighScore(HighScore hs);
	
	public boolean isNewHighScore(HighScore hs);
	
	public HighScore findHighScore(HighScore hs);
	
	public String getWavesFromFile(String fileName);
	

}
