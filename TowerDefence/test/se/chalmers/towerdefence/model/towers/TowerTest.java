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
		assertTrue(tower.getRange() == 150);
		assertTrue(tower.getProjectiles() == null);
		assertTrue(tower.getReloadTime() == 30);
		assertTrue(tower.getCost() == 200);
		assertTrue(tower.getDamage() == 5);
		// 1
		tower.upgradeTower();
		assertTrue(tower.getX()/40 == 1.0f); 		
		assertTrue(tower.getY()/40 == 1.0f);
		assertTrue(tower.getRange() == 200);
		assertTrue(tower.getProjectiles() == null);
		assertTrue(tower.getReloadTime() == 20);
		assertTrue(tower.getCost() == 250);
		assertTrue(tower.getDamage() == 7);
		//2
		tower.upgradeTower();
		assertTrue(tower.getX()/40 == 1.0f); 		
		assertTrue(tower.getY()/40 == 1.0f);
		assertTrue(tower.getRange() == 250);
		assertTrue(tower.getProjectiles() == null);
		assertTrue(tower.getReloadTime() == 10);
		assertTrue(tower.getCost() == 300);
		assertTrue(tower.getDamage() == 9);
		//3
		tower.upgradeTower();
		assertTrue(tower.getX()/40 == 1.0f); 		
		assertTrue(tower.getY()/40 == 1.0f);
		assertTrue(tower.getRange() == 300);
		assertTrue(tower.getProjectiles() == null);
		assertTrue(tower.getReloadTime() == 0);
		assertTrue(tower.getCost() == 350);
		assertTrue(tower.getDamage() == 11);
		//4		
		tower.upgradeTower();
		assertTrue(tower.getX()/40 == 1.0f); 		
		assertTrue(tower.getY()/40 == 1.0f);
		assertTrue(tower.getRange() == 350); 
		assertTrue(tower.getProjectiles() == null);
		assertTrue(tower.getReloadTime() == -10); 
		assertTrue(tower.getCost() == 400); 
		assertTrue(tower.getDamage() == 13); 
		//5		
		tower.upgradeTower();
		assertTrue(tower.getX()/40 == 1.0f); 		
		assertTrue(tower.getY()/40 == 1.0f);
		assertTrue(tower.getRange() == 370); 
		assertTrue(tower.getProjectiles() == null);
		assertTrue(tower.getReloadTime() == -15); 
		assertTrue(tower.getCost() == 400); 
		assertTrue(tower.getDamage() == 14);

		//6 no more upgrades	
		tower.upgradeTower();
		assertTrue(tower.getX()/40 == 1.0f); 		
		assertTrue(tower.getY()/40 == 1.0f);
		assertTrue(tower.getRange() == 370); 
		assertTrue(tower.getProjectiles() == null);
		assertTrue(tower.getReloadTime() == -15); 
		assertTrue(tower.getCost() == 400); 
		assertTrue(tower.getDamage() == 14);


	}

}