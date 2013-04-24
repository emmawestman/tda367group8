package se.chalmers.Services;

import static org.junit.Assert.*;

import org.junit.Test;
import se.chalmers.TowerDefence.Level;

public class GetDataTest {
	@Test
	public void getHigScoreTest() {
		System.out.println(GetData.getHighScore("level1")) ;
		//assertTrue (GetData.getHighScore("level1") == 100);
		assertTrue (GetData.getHighScore("level2") == 200);
		assertTrue (GetData.getHighScore("level1") == 300);
		assertTrue (GetData.getHighScore("level4") == 400);
		
	}


}
