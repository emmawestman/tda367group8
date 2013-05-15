package se.chalmers.towerdefence.model;

import java.util.ArrayList;

/**
 * A tower that shoots like a laser.
 * @author Julia
 *
 */

public class LaserTower extends AbstractTower {
	private int upgradeCost;
	private int upgrades;

	public LaserTower(float x, float y, int range,
			ArrayList<AbstractProjectile> projectiles, int reloadTime,
			int cost, int damage) {
		super(x, y, range, projectiles, reloadTime, cost, damage);
		this.upgradeCost = 50;
		this.upgrades = 0;
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
			this.setExists(false);
			return new UpgradedTower(this.getX()/40, this.getY()/40, this.getRange() + 50, this.getProjectiles(), this.getReloadTime(), this.getCost() + upgradeCost, getDamage());
		}
	}

	@Override
	public int getUpgradeCost() {
		return upgradeCost;
	}

}
