package se.chalmers.towerdefence.model;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

import se.chalmers.towerdefence.model.towers.AbstractTower;
import se.chalmers.towerdefence.model.towers.BombTower;
import se.chalmers.towerdefence.model.towers.LaserTower;
import se.chalmers.towerdefence.model.towers.Tower;

public class LevelTest {	
	/**
	 *A class to test methods in Level.
	 *Methods that are tested: sellTower, buildTower and upgradeTower.
	 * @author Emma Westman
	 * @author Julia Friberg
	 * @author Oskar Dahlberg
	 * @author Jonathan Thunberg
	 * 
	 */
	
	private ArrayList <AbstractTower> towers;
	private Level level1;
	private Level level2;
	private Level level3;
	private ISquare [][] gameBoard = new ISquare [4][4];
	private String allWaves ="123:123";
	private String [] split = allWaves.split(":");
	private Player player;
	
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
		level1 = new Level(createGameBoard(), split, 40, 40, "level1");
		player = level1.getPlayer();
		player.addResources(1000);
		
		level1.buildTower(2, 2, 1);
		towers = level1.getTowers();
		AbstractTower tower = towers.get(0);
		assertTrue(tower.exists());
		assertTrue(towers.get(0) instanceof Tower);
		
		level1.buildTower(0, 0, 2);
		towers = level1.getTowers();
		AbstractTower tower2 = towers.get(1);
		assertTrue(tower2.exists());
		assertTrue(towers.get(1) instanceof BombTower);
		
		level1.buildTower(0, 2, 3);
		towers = level1.getTowers();
		AbstractTower tower3 = towers.get(2);
		assertTrue(tower3.exists());
		assertTrue(towers.get(2) instanceof LaserTower);
	
	}
	
	@Test
	public void sellTowerTest() {
		level2 = new Level(createGameBoard(), split, 40, 40, "level1");
		level2.buildTower(2, 2, 1);
		level2.sellTower(2, 2);
		assertTrue(level2.getTowers().size() == 0);
		
		level2.buildTower(2, 2, 2);
		level2.sellTower(2, 2);
		assertTrue(level2.getTowers().size() == 0);
		
		level2.buildTower(2, 2, 3);
		level2.sellTower(2, 2);
		assertTrue(level2.getTowers().size() == 0);
		
	}
	
	@Test
	public void upgradeTowerTest() {
		level3 = new Level(createGameBoard(), split, 40, 40, "level1");
		level3.buildTower(2, 2, 1);
		level3.upgradeTower(2, 2);
		towers = level3.getTowers();
		Tower tower = (Tower) towers.get(0);
		assertTrue(tower.exists());
		level3.sellTower(2, 2);
		try {
			level3.upgradeTower(2, 2);
		}catch (Exception e) {
			assertTrue(e != null);
		}
		assertTrue(level3.getTowers().size() == 0);
		
		level3.buildTower(2, 2, 2);
		level3.upgradeTower(2, 2);
		towers = level3.getTowers();
		BombTower tower2 = (BombTower) towers.get(0);
		assertTrue(tower2.exists());
		level3.sellTower(2, 2);
		try {
			level3.upgradeTower(2, 2);
		}catch (Exception e) {
			assertTrue(e != null);
		}
		assertTrue(level3.getTowers().size() == 0);
		
		level3.buildTower(2, 2, 3);
		level3.upgradeTower(2, 2);
		towers = level3.getTowers();
		LaserTower tower3 = (LaserTower) towers.get(0);
		assertTrue(tower3.exists());
		level3.sellTower(2, 2);
		try {
			level3.upgradeTower(2, 2);
		}catch (Exception e) {
			assertTrue(e != null);
		}
		assertTrue(level3.getTowers().size() == 0);
	}

}
