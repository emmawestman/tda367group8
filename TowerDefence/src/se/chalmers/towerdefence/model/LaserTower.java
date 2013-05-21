package se.chalmers.towerdefence.model;

import java.util.ArrayList;
import java.util.List;

/**
 * A tower that shoots like a laser.
 * @author Julia
 *
 */

public class LaserTower extends AbstractTower {
	private int upgradeCost;
	private int upgrades;
	private AbstractProjectile lastProjectile;

	public LaserTower(float x, float y, ArrayList<AbstractProjectile> projectiles, int squareHeight, int squareWidth) {
		super(x, y, projectiles, squareHeight, squareWidth);
		this.upgradeCost = 50;
		this.upgrades = 0;
		super.setCost(200);
		super.setDamage(1);
		super.setPriority(Priorities.FIRST);
		super.setRange(100);
		super.setReloadTime(100);
	}

	@Override
	public AbstractTower upgradeTower() {
		if(upgrades <= 3){
			upgrades++;
			this.addRange(50);
			this.addDamage(1);
			this.addCost(upgradeCost);
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
		if(lastProjectile == null || !lastProjectile.exists()) {
			LaserProjectile p = new LaserProjectile(xPos, yPos, monster, damage, getRange(), getReloadTime());
			projectiles.add(p);
			lastProjectile = p;
		}
		
	}

	@Override
	public int getUpgrades() {
		return upgrades;
	}

}
