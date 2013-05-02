package se.chalmers.towerdefence.model;

import java.util.ArrayList;



public class Tower extends AbstractTower{
	private int upgradeCost = 50;
	private int upgrades = 0;

	public Tower(float x, float y, int range, ArrayList <AbstractProjectile> projectiles, int timer, int cost, int damage){
		super(x,y,range, projectiles, timer, cost, damage);
	}

	public AbstractTower upgradeTower() {
		if(upgrades <= 3){
			upgrades++;
			System.out.println(upgrades);
			this.addRange(50);
			this.addDamage(2);
			this.decreaseReloadTime(5);
			return this;
		}else{
			return new UpgradedTower(this.getX()/40, this.getY()/40, this.getRange() + 50, this.getProjectiles(), this.getReloadTime(), this.getCost() + upgradeCost, getDamage());
		}
	}

	public int getUpgradeCost() {
		return upgradeCost;
	}

}