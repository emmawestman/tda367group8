package se.chalmers.towerdefence.model;

import java.util.ArrayList;

public class UpgradedTower extends AbstractTower{
	public UpgradedTower(float x, float y, int range, ArrayList <AbstractProjectile> projectiles, int timer, int cost, int damage) {
		super(x,y,range, projectiles, timer, cost, damage);
		
	}

	@Override
	public AbstractTower upgradeTower() {
		return null;
		//Not able to upgrade this kind of tower
	}

	@Override
	public int getUpgradeCost() {
		//Not able to upgrade this kind of tower
		return 0;
	}

}
