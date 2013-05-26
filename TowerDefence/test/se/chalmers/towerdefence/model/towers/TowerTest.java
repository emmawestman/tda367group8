package se.chalmers.towerdefence.model.towers;

import static org.junit.Assert.*;
import org.junit.Test;

import se.chalmers.towerdefence.model.towers.Tower;
/**
 * A class to test that Tower upgrades correctly.
 * @author Emma Westman
 * @author Julia Friberg
 * @author Oskar Dahlberg
 * @author Jonathan Thunberg
 *
 */

public class TowerTest {

	@Test
	public void upgradeTowerTest() {
		Tower tower = new Tower(1.0f, 1.0f, null, 40, 40);

		assertTrue(tower.getX() / 40 == 1.0f);
		assertTrue(tower.getY() / 40 == 1.0f);
		assertTrue(tower.getRange() == 75);
		assertTrue(tower.getProjectiles() == null);
		assertTrue(tower.getReloadTime() == 50);
		assertTrue(tower.getCost() == 200);
		assertTrue(tower.getDamage() == 350);
		// 1
		tower.upgradeTower();
		assertTrue(tower.getX()/40 == 1.0f); 		
		assertTrue(tower.getY()/40 == 1.0f);
		assertTrue(tower.getRange() == 90);
		assertTrue(tower.getProjectiles() == null);
		assertTrue(tower.getReloadTime() == 45);
		assertTrue(tower.getCost() == 300);
		assertTrue(tower.getDamage() == 420);
		//2
		tower.upgradeTower();
		assertTrue(tower.getX()/40 == 1.0f); 		
		assertTrue(tower.getY()/40 == 1.0f);
		assertTrue(tower.getRange() == 105);
		assertTrue(tower.getProjectiles() == null);
		assertTrue(tower.getReloadTime() == 40);
		assertTrue(tower.getCost() == 400);
		assertTrue(tower.getDamage() == 490);
		//3
		tower.upgradeTower();
		assertTrue(tower.getX()/40 == 1.0f); 		
		assertTrue(tower.getY()/40 == 1.0f);
		assertTrue(tower.getRange() == 120);
		assertTrue(tower.getProjectiles() == null);
		assertTrue(tower.getReloadTime() == 35);
		assertTrue(tower.getCost() == 500);
		assertTrue(tower.getDamage() == 560);
		//4		
		tower.upgradeTower();
		assertTrue(tower.getX()/40 == 1.0f); 		
		assertTrue(tower.getY()/40 == 1.0f);
		assertTrue(tower.getRange() == 135); 
		assertTrue(tower.getProjectiles() == null);
		assertTrue(tower.getReloadTime() == 30); 
		assertTrue(tower.getCost() == 600); 
		assertTrue(tower.getDamage() == 630); 
		//5		
		tower.upgradeTower();
		assertTrue(tower.getX()/40 == 1.0f); 		
		assertTrue(tower.getY()/40 == 1.0f);
		assertTrue(tower.getRange() == 155);
		assertTrue(tower.getProjectiles() == null);
		assertTrue(tower.getReloadTime() == 25); 
		assertTrue(tower.getCost() == 600); 
		assertTrue(tower.getDamage() == 730);

		//6 no more upgrades	
		tower.upgradeTower();
		assertTrue(tower.getX()/40 == 1.0f); 		
		assertTrue(tower.getY()/40 == 1.0f);
		assertTrue(tower.getRange() == 155); 
		assertTrue(tower.getProjectiles() == null);
		assertTrue(tower.getReloadTime() == 25); 
		assertTrue(tower.getCost() == 600); 
		assertTrue(tower.getDamage() == 730);


	}

}