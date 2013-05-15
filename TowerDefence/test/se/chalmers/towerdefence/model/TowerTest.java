package se.chalmers.towerdefence.model;

import static org.junit.Assert.*;
import org.junit.Test;

public class TowerTest {
	
	@Test
	public void upgradeTowerTest() {
		Tower tower = new Tower(1.0f, 1.0f, 150, null, 30, 200, 5);
// 1
		tower.upgradeTower();
		assertTrue(tower.getX()/40 == 1.0f); 		
		assertTrue(tower.getY()/40 == 1.0f);
		assertTrue(tower.getRange() == 200);
		assertTrue(tower.getProjectiles() == null);
		assertTrue(tower.getReloadTime() == 25);
		assertTrue(tower.getCost() == 250);
		assertTrue(tower.getDamage() == 7);
//2
		tower.upgradeTower();
		assertTrue(tower.getX()/40 == 1.0f); 		
		assertTrue(tower.getY()/40 == 1.0f);
		assertTrue(tower.getRange() == 250);
		assertTrue(tower.getProjectiles() == null);
		assertTrue(tower.getReloadTime() == 20);
		assertTrue(tower.getCost() == 300);
		assertTrue(tower.getDamage() == 9);
//3
		tower.upgradeTower();
		assertTrue(tower.getX()/40 == 1.0f); 		
		assertTrue(tower.getY()/40 == 1.0f);
		assertTrue(tower.getRange() == 300);
		assertTrue(tower.getProjectiles() == null);
		assertTrue(tower.getReloadTime() == 15);
		assertTrue(tower.getCost() == 350);
		assertTrue(tower.getDamage() == 11);
//4		
		tower.upgradeTower();
		assertTrue(tower.getX()/40 == 1.0f); 		
		assertTrue(tower.getY()/40 == 1.0f);
		assertTrue(tower.getRange() == 350); 
		assertTrue(tower.getProjectiles() == null);
		assertTrue(tower.getReloadTime() == 10); 
		assertTrue(tower.getCost() == 400); 
		assertTrue(tower.getDamage() == 13); 
//5		
		tower.upgradeTower();
		assertTrue(tower.getX()/40 == 1.0f); 		
		assertTrue(tower.getY()/40 == 1.0f);
		assertTrue(tower.getRange() == 350); 
		assertTrue(tower.getProjectiles() == null);
		assertTrue(tower.getReloadTime() == 10); 
		assertTrue(tower.getCost() == 400); 
		assertTrue(tower.getDamage() == 13);
//6		no more upgrades 
		tower.upgradeTower();
		assertTrue(tower.getX()/40 == 1.0f); 		
		assertTrue(tower.getY()/40 == 1.0f);
		assertTrue(tower.getRange() == 350); 
		assertTrue(tower.getProjectiles() == null);
		assertTrue(tower.getReloadTime() == 10); 
		assertTrue(tower.getCost() == 400); 
		assertTrue(tower.getDamage() == 13); 
		

	}
	
}