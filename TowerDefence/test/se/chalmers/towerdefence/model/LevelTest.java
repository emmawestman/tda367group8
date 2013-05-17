package se.chalmers.towerdefence.model;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

public class LevelTest {	
	
	private ArrayList <AbstractTower> towers;
	private Level level;
	private ISquare [][] gameBoard = new ISquare [4][4];
	
	public ISquare [][] createGameBoard() {
		this.gameBoard [0][0] = new BuildableSquare(0, 0);
		this.gameBoard [0][1] = new RoadSquare(0, 1);
		this.gameBoard [0][2] = new BuildableSquare(0, 2);
		this.gameBoard [0][3] = new BuildableSquare(0, 3);
		this.gameBoard [1][0] = new BuildableSquare(1, 0);
		this.gameBoard [1][1] = new RoadSquare(1, 1);
		this.gameBoard [1][2] = new BuildableSquare(1, 2);
		this.gameBoard [1][3] = new BuildableSquare(1, 3);
		this.gameBoard [2][0] = new BuildableSquare(2, 0);
		this.gameBoard [2][1] = new RoadSquare(2, 1);
		this.gameBoard [2][2] = new BuildableSquare(2, 2);
		this.gameBoard [2][3] = new BuildableSquare(2, 3);
		this.gameBoard [3][0] = new BuildableSquare(3, 0);
		this.gameBoard [3][1] = new BuildableSquare(3, 1);
		this.gameBoard [3][2] = new BuildableSquare(3, 2);
		this.gameBoard [3][3] = new BuildableSquare(3, 3);
		return gameBoard;
	}

	@Test
	public void buildTowerTest() {
		level = new Level(createGameBoard(), null);
		level.buildTower(2, 2);
		towers = level.getTowers();
		Tower tower = (Tower) towers.get(0);
		assertTrue(tower.exists());
		
	}
	
	@Test
	public void sellTowerTest() {
		level = new Level(createGameBoard(), null);
		level.buildTower(2, 2);
		level.sellTower(2, 2);
		assertTrue(towers == null);
	}
	
	@Test
	public void upgradeTowerTest() {
		level = new Level(createGameBoard(), null);
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
