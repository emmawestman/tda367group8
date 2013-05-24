package se.chalmers.towerdefence.model.towers;

import java.util.ArrayList;
import java.util.List;

import se.chalmers.towerdefence.model.Wave;
import se.chalmers.towerdefence.model.monsters.AbstractMonster;
import se.chalmers.towerdefence.model.projectiles.AbstractProjectile;
import se.chalmers.towerdefence.model.projectiles.LaserProjectile;

/**
 * A tower that shoots like a laser.
 * @author Julia
 *
 */

public class LaserTower extends AbstractTower {
	private int upgradeCost;
	private int upgrades;

	public LaserTower(float x, float y, ArrayList<AbstractProjectile> projectiles, int squareHeight, int squareWidth) {
		super(x, y, projectiles, squareHeight, squareWidth);
		upgradeCost = 50;
		upgrades = 0;
		setCost(200);
		setDamage(1);
		setPriority(Priorities.FIRST);
		setRange(100);
		setReloadTime(2);
		setID(3);
	}

	@Override
	public AbstractTower upgradeTower() {
		if(upgrades <= 3){
			upgrades++;
			addRange(10);
			addDamage(1);
			addCost(upgradeCost);
			return this;
		}else{
			return null;
		}
	}

	@Override
	public int getUpgradeCost() {
		return upgradeCost;
	}

	@Override
	public void addProjectile(float xPos, float yPos, AbstractMonster monster,
			int damage, List<AbstractProjectile> projectiles, List<Wave> waves) {
			LaserProjectile p = new LaserProjectile(xPos, yPos, monster, damage);
			projectiles.add(p);
	}

	@Override
	public int getUpgrades() {
		return upgrades;
	}

}
