package se.chalmers.towerdefence.model;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

import se.chalmers.towerdefence.model.monsters.Monster;
import se.chalmers.towerdefence.model.towers.Tower;

/**
 * A class to test methods in AbstractTower.
 * Methods tested: sellTower and MonsterInRange.
 * @author Emma Westman
 * @author Julia Friberg
 * @author Oskar Dahlberg
 * @author Jonathan Thunberg
 *
 */

public class AbstractTowerTest {
	private ArrayList<RoadSquare> roadIterator;
	
	@Test
	public void sellTowerTest() {
		Tower tower = new Tower(1.0f, 1.0f, null, 0, 0);
		assertTrue(tower.exists() == true);
		tower.sellTower();
		assertTrue(tower.exists() == false);
	}
	
	@Test
	public void monsterInRangeTest() {
		int hight = 40;
		int width = 40;
		this.roadIterator = new ArrayList<RoadSquare>();
		roadIterator.add(new RoadSquare(0, 0, hight, width));
		roadIterator.add(new RoadSquare(0, 4, hight, width));
		roadIterator.add(new RoadSquare(4, 4, hight, width));
		roadIterator.add(new RoadSquare(4, 0, hight, width));
		roadIterator.add(new RoadSquare(8, 0, hight, width));
		roadIterator.add(new RoadSquare(8, 4, hight, width));
		roadIterator.add(new RoadSquare(8, 8, hight, width));
		roadIterator.add(new RoadSquare(4, 8, hight, width));
		roadIterator.add(new RoadSquare(4, 12, hight, width));
		roadIterator.add(new RoadSquare(8, 12, hight, width));
		roadIterator.add(new RoadSquare(12, 12, hight, width));
		roadIterator.add(new RoadSquare(12, 8, hight, width));
		roadIterator.add(new RoadSquare(16, 8, hight, width));
		roadIterator.add(new RoadSquare(16, 12, hight, width));
		roadIterator.add(new RoadSquare(16, 16, hight, width));
		roadIterator.add(new RoadSquare(20, 16, hight, width));
		roadIterator.add(new RoadSquare(24, 16, hight, width));
		roadIterator.add(new RoadSquare(28, 16, hight, width));
		roadIterator.add(new RoadSquare(28, 12, hight, width));
		roadIterator.add(new RoadSquare(24, 12, hight, width));
		roadIterator.add(new RoadSquare(24, 8, hight, width));
		roadIterator.add(new RoadSquare(38, 8, hight, width));
	
		
		Tower tower = new Tower(1.0f, 1.0f, null, hight, width);
		Road road = new Road(roadIterator);
		Player player = new Player(0,0);
		Monster monster = new Monster(road, player);
		assertTrue(tower.monsterInRange(monster));
		for (int i = 0; i < 379; i++) {
			monster.move();
		}
		monster.move();
		System.out.println(tower.monsterInRange(monster));
		assertFalse(tower.monsterInRange(monster));
		tower.upgradeTower();
		assertTrue(tower.monsterInRange(monster));
	}

}