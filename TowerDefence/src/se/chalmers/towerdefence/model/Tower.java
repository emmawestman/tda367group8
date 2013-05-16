package se.chalmers.towerdefence.model;

import java.util.ArrayList;
import java.util.List;



public class Tower extends AbstractTower{
	private int upgradeCost;
	private int upgrades;


	public Tower(float x, float y, ArrayList <AbstractProjectile> projectiles){
		super(x,y, projectiles);
		this.upgradeCost = 50;
		this.upgrades = 0;
		setCost(200);
		setDamage(5);
		setRange(150);
		setPriority(Priorities.FIRST);
		setReloadTime(30);
	}

	public AbstractTower upgradeTower() {
		if(upgrades <= 3){
			upgrades++;
			addRange(50);
			addDamage(2);
			addCost(upgradeCost);
			decreaseReloadTime(10);
			return this;
		}else if(upgrades == 4){
			upgrades++;
			this.upgradeCost = 0;
			addRange(20);
			addDamage(1);
			decreaseReloadTime(5);
			return null;
		}else{
			return null;
		}
	}

	
	public int getUpgradeCost() {
		return upgradeCost;
	}

	@Override
	public void addProjectile(float xPos, float yPos, AbstractMonster monster, int damage, List<AbstractProjectile> projectiles) {
		Projectile p = new Projectile(xPos, yPos, monster, damage);
		projectiles.add(p);
	}

	@Override
	public int getUpgrades() {
		return upgrades;
	}
	


}