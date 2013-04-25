package se.chalmers.Services;

import static org.junit.Assert.*;

import org.junit.Test;

import se.chalmers.TowerDefence.HighScore;
import se.chalmers.TowerDefence.Level;

public class SaveDataTest {
	@Test
	public void saveHighScoreTest() {
		HighScore hs1 = new HighScore(100, "level1");
		HighScore hs2 = new HighScore(200, "level2");
		HighScore hs3 = new HighScore(50, "level1");
		HighScore hs4 = new HighScore(400, "level4");
		HighScore hs5 = new HighScore(500, "level1");
		SaveData.saveHighScore(hs1);
		SaveData.saveHighScore(hs2);
		SaveData.saveHighScore(hs3);
		SaveData.saveHighScore(hs4);
		SaveData.saveHighScore(hs5);
	}

}