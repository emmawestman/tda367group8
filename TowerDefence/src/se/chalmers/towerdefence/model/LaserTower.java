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

	public LaserTower(float x, float y, ArrayList<AbstractProjectile> projectiles) {
		super(x, y, projectiles);
		this.upgradeCost = 50;
		this.upgrades = 0;
		super.setCost(200);
		super.setDamage(1);
		super.setPriority(Priorities.FIRST);
		super.setRange(100);
		super.setReloadTime(0);
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
//			this.setExists(false);
//			return new UpgradedTower(this.getX()/40, this.getY()/40, this.getRange() + 50, this.getProjectiles(), this.getReloadTime(), this.getCost() + upgradeCost, getDamage());
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
		//TODO do method when LaserProjectile is done
		
	}

	@Override
	public int getUpgrades() {
		return upgrades;
	}

}
