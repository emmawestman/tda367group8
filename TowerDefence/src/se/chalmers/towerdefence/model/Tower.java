package se.chalmers.towerdefence.model;

import java.util.ArrayList;

import temp.AbstractProjectile;
import temp.UpgradedTower;

public class Tower extends AbstractTower{
	private int upgradeCost;

	public Tower(float x, float y, int range, ArrayList <AbstractProjectile> projectiles, int timer, int cost, int damage){
		super(x,y,range, projectiles, timer, cost, damage);
	}

	public void upgradeTower() {
		new UpgradedTower(this.getX(), this.getY(), this.getRange() + 50, this.getProjectiles(), this.getTimer(), this.getCost() + upgradeCost, getDamage());
	}
	
	public int getUpgradeCost() {
		return upgradeCost;
	}
	
}