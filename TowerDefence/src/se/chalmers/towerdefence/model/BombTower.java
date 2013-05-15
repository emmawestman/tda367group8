package se.chalmers.towerdefence.model;

import java.util.ArrayList;
import java.util.List;

public class BombTower extends AbstractTower {
	private int upgradeCost;
	private int upgrades;

	public BombTower(float x, float y, int range,
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
			this.addDamage(3);
			this.addCost(upgradeCost);
			this.decreaseReloadTime(1);
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
	
	@Override
	public void tryShoot(List<Wave> waves) {
		//TODO add new logic for bomb damage
	}

}
