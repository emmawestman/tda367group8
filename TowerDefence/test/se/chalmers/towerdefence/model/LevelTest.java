package se.chalmers.towerdefence.model;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

public class LevelTest {	
	
	private ArrayList <AbstractTower> towers;
	private Level level;
	private ISquare [][] gameBoard = new ISquare [4][4];
	private String allWaves ="123:123";
	private String [] split = allWaves.split(":");
	
	public ISquare [][] createGameBoard() {
		int width = 40;
		int hight = 40;
		this.gameBoard [0][0] = new BuildableSquare(0, 0, hight, width);
		this.gameBoard [0][1] = new RoadSquare(0, 1, hight, width);
		this.gameBoard [0][2] = new BuildableSquare(0, 2, hight, width);
		this.gameBoard [0][3] = new BuildableSquare(0, 3, hight, width);
		this.gameBoard [1][0] = new BuildableSquare(1, 0, hight, width);
		this.gameBoard [1][1] = new RoadSquare(1, 1, hight, width);
		this.gameBoard [1][2] = new BuildableSquare(1, 2, hight, width);
		this.gameBoard [1][3] = new BuildableSquare(1, 3, hight, width);
		this.gameBoard [2][0] = new BuildableSquare(2, 0, hight, width);
		this.gameBoard [2][1] = new RoadSquare(2, 1, hight, width);
		this.gameBoard [2][2] = new BuildableSquare(2, 2, hight, width);
		this.gameBoard [2][3] = new BuildableSquare(2, 3, hight, width);
		this.gameBoard [3][0] = new BuildableSquare(3, 0, hight, width);
		this.gameBoard [3][1] = new BuildableSquare(3, 1, hight, width);
		this.gameBoard [3][2] = new BuildableSquare(3, 2, hight, width);
		this.gameBoard [3][3] = new BuildableSquare(3, 3, hight, width);
		return gameBoard;
	}

	@Test
	public void buildTowerTest() {
		level = new Level(createGameBoard(), split, 40, 40, "level1");
		level.buildTower(2, 2);
		towers = level.getTowers();
		Tower tower = (Tower) towers.get(0);
		assertTrue(tower.exists());
		
	}
	
	@Test
	public void sellTowerTest() {
		level = new Level(createGameBoard(), split, 40, 40, "level1");
		level.buildTower(2, 2);
		level.sellTower(2, 2);
		assertTrue(towers == null);
	}
	
	@Test
	public void upgradeTowerTest() {
		level = new Level(createGameBoard(), split, 40, 40, "level1");
		level.buildTower(2, 2);
		level.upgradeTower(2, 2);
		towers = level.getTowers();
		Tower tower = (Tower) towers.get(0);
		assertTrue(tower.exists());
		level.sellTower(2, 2);
//		level.upgradeTower(2, 2);
		System.out.println(towers);
		assertTrue(towers == null);
	}

}
