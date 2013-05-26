package se.chalmers.towerdefence.model.towers;


import java.util.List;

import se.chalmers.towerdefence.model.interfaces.GameBoardObject;
import se.chalmers.towerdefence.model.monsters.AbstractMonster;
import se.chalmers.towerdefence.model.projectiles.LaserProjectile;
import se.chalmers.towerdefence.model.wave.Wave;

/**
 * A tower that shoots like a laser.
 * @author Julia, Emma, Oskar, Jonathan
 *
 */

public class LaserTower extends AbstractTower {
	private int upgradeCost;
	private int upgrades;

	public LaserTower(float x, float y, List<GameBoardObject> projectiles, int squareHeight, int squareWidth) {
		super(x, y, projectiles, squareHeight, squareWidth);
		upgradeCost = 100;
		upgrades = 0;
		setCost(200);
		setDamage(15);
		setPriority(Priorities.WEAKEST);
		setRange(100);
		setReloadTime(2);
		setID(3);
	}

	@Override
	public void upgradeTower() {
		if(upgrades <= 3){
			upgrades++;
			addRange(10);
			addDamage(3);
			addCost(upgradeCost);
		}else if (upgrades == 4){
			upgrades++;
			upgradeCost = 0;
			addRange(10);
			addDamage(3);
			addCost(upgradeCost);
		}
	}

	@Override
	public int getUpgradeCost() {
		return upgradeCost;
	}

	@Override
	public void addProjectile(float xPos, float yPos, AbstractMonster monster,
			int damage, List<GameBoardObject> projectiles, List<Wave> waves) {
			LaserProjectile p = new LaserProjectile(xPos, yPos, monster, damage);
			projectiles.add(p);
	}

	@Override
	public int getUpgrades() {
		return upgrades;
	}

}
