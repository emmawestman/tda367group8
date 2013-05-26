package se.chalmers.towerdefence.model;

import static org.junit.Assert.*;
import org.junit.Test;

import se.chalmers.towerdefence.model.interfaces.ISquare;
import se.chalmers.towerdefence.model.squares.RoadSquare;
import se.chalmers.towerdefence.model.squares.TowerSquare;
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
	

	private Level level1;
	private Level level2;
	private Level level3;
	private ISquare [][] gameBoard = new ISquare [4][4];
	private Player player;
	private int width = 40;
	private int hight = 40;
	
	public ISquare [][] createGameBoard() {
		
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
		level1 = new Level(createGameBoard(), 40, 40, "level1");
		player = level1.getPlayer();
		player.addResources(1000);
		
		AbstractTower tower = new Tower(2, 2, null, width, hight);
		level1.getGameBoard().addTower(2, 2, tower);
		TowerSquare towerSquare = (TowerSquare) level1.getGameBoard().getSquare(2, 2);
		Tower towerExists = (Tower) towerSquare.getTower();
		assertTrue(towerExists.exists());
		assertTrue(towerExists instanceof Tower);
		
		
		AbstractTower tower2 = new BombTower(0, 0, null, width, hight);
		level1.getGameBoard().addTower(2, 2, tower2);
		TowerSquare towerSquare2 = (TowerSquare) level1.getGameBoard().getSquare(2, 2);
		BombTower tower2Exists = (BombTower) towerSquare2.getTower();
		assertTrue(tower2Exists.exists());
		assertTrue(tower2Exists instanceof BombTower);
		
		AbstractTower tower3 = new LaserTower(0, 2, null, width, hight);
		level1.getGameBoard().addTower(2, 2, tower3);
		TowerSquare towerSquare3 = (TowerSquare) level1.getGameBoard().getSquare(2, 2);
		LaserTower tower3Exists = (LaserTower) towerSquare3.getTower();
		assertTrue(tower3Exists.exists());
		assertTrue(tower3Exists instanceof LaserTower);
		
		
		

	
	}
	
	@Test
	public void sellTowerTest() {
		level2 = new Level(createGameBoard(), 40, 40, "level1");
		
		
		AbstractTower tower = new Tower(2, 2, null, width, hight);
		level2.getGameBoard().addTower(2, 2, tower);
		TowerSquare towerSquare = (TowerSquare) level2.getGameBoard().getSquare(2, 2);
		Tower towerExists = (Tower) towerSquare.getTower();
		assertTrue(towerExists.exists());
		level2.getGameBoard().sellTower(2, 2);
		assertTrue(level2.getGameBoard().getSquare(2, 2) instanceof BuildableSquare);
		
		AbstractTower tower2 = new BombTower(0, 0, null, width, hight);
		level2.getGameBoard().addTower(2, 2, tower2);
		TowerSquare towerSquare2 = (TowerSquare) level2.getGameBoard().getSquare(2, 2);
		BombTower tower2Exists = (BombTower) towerSquare2.getTower();
		assertTrue(tower2Exists.exists());
		level2.getGameBoard().sellTower(0, 0);
		assertTrue(level2.getGameBoard().getSquare(0, 0) instanceof BuildableSquare);
		
		
		AbstractTower tower3 = new LaserTower(0, 2, null, width, hight);
		level2.getGameBoard().addTower(2, 2, tower3);
		TowerSquare towerSquare3 = (TowerSquare) level2.getGameBoard().getSquare(2, 2);
		LaserTower tower3Exists = (LaserTower) towerSquare3.getTower();
		assertTrue(tower3Exists.exists());
		level2.getGameBoard().sellTower(0, 2);
		assertTrue(level2.getGameBoard().getSquare(0, 2) instanceof BuildableSquare);
		

		
	}
	
	@Test
	public void upgradeTowerTest() {
		level3 = new Level(createGameBoard(), 40, 40, "level1");
		
		AbstractTower tower = new Tower(2, 2, null, width, hight);
		level3.getGameBoard().addTower(2, 2, tower);
		TowerSquare towerSquare = (TowerSquare) level3.getGameBoard().getSquare(2, 2);
		Tower towerExists = (Tower) towerSquare.getTower();
		towerExists.upgradeTower();
		assertTrue(towerExists.exists());
		level3.getGameBoard().sellTower(2, 2);
		try {
			towerExists.upgradeTower();
		}catch (Exception e) {
			assertTrue(e != null);
		}
	
		
		
		AbstractTower tower2 = new BombTower(0, 0, null, width, hight);
		level3.getGameBoard().addTower(2, 2, tower2);
		TowerSquare towerSquare2 = (TowerSquare) level3.getGameBoard().getSquare(2, 2);
		BombTower tower2Exists = (BombTower) towerSquare2.getTower();
		towerExists.upgradeTower();
		assertTrue(tower2Exists.exists());
		level3.getGameBoard().sellTower(2, 2);
		try {
			tower2Exists.upgradeTower();
		}catch (Exception e) {
			assertTrue(e != null);
		}
		
		
		AbstractTower tower3 = new LaserTower(0, 2, null, width, hight);
		level3.getGameBoard().addTower(2, 2, tower3);
		TowerSquare towerSquare3 = (TowerSquare) level3.getGameBoard().getSquare(2, 2);
		LaserTower tower3Exists = (LaserTower) towerSquare3.getTower();
		towerExists.upgradeTower();
		assertTrue(tower3Exists.exists());
		level3.getGameBoard().sellTower(2, 2);
		try {
			tower3Exists.upgradeTower();
		}catch (Exception e) {
			assertTrue(e != null);
		}
	}

}
