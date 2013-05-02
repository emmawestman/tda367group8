package se.chalmers.towerdefence.files;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import se.chalmers.towerdefence.model.HighScore;

public class FileHandlerTest {
	private FileHandler fh = new FileHandler();
	
	@Test
	public void saveHighScoreTest() {
		HighScore hs1 = new HighScore(100, "level1");
		HighScore hs2 = new HighScore(200, "level2");
		HighScore hs3 = new HighScore(50, "level1");
		HighScore hs4 = new HighScore(400, "level4");
		HighScore hs5 = new HighScore(500, "level1");
		fh.saveHighScore(hs1);
		fh.saveHighScore(hs2);
		fh.saveHighScore(hs3);
		fh.saveHighScore(hs4);
		fh.saveHighScore(hs5);
	}
	@Test
	public void getHigScoreTest() {
		System.out.println(fh.getHighScore("level1")) ;
		//assertTrue (GetData.getHighScore("level1") == 100);
		assertTrue (fh.getHighScore("level2") == 200);
		assertTrue (fh.getHighScore("level1") == 500);
		assertTrue (fh.getHighScore("level4") == 400);
	}
	@Test
	public void getWavesFromFileTest() {
		String waves = fh.getWavesFromFile("level1.txt");
		assertTrue(waves.equals("123123123:321321321:12212312"));
	}

}
