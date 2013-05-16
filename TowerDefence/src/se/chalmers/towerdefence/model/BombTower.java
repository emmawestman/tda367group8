package se.chalmers.towerdefence.model;

import java.util.ArrayList;
import java.util.List;

public class BombTower extends AbstractTower {
	private int upgradeCost;
	private int upgrades;

	public BombTower(float x, float y, ArrayList<AbstractProjectile> projectiles) {
		super(x, y, projectiles);
		this.upgradeCost = 50;
		this.upgrades = 0;
		setCost(300);
		setDamage(10);
		setPriority(Priorities.ALL);
		setRange(50);
		setReloadTime(100);
	}

	@Override
	public AbstractTower upgradeTower() {
		if(upgrades <= 3){
			upgrades++;
			addRange(50);
			addDamage(3);
			addCost(upgradeCost);
			decreaseReloadTime(1);
			return this;
		}else if(upgrades == 4){
			upgrades++;
			this.upgradeCost = 0;
			addRange(50);
			addDamage(3);
			decreaseReloadTime(1);
			return null;
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
			int damage, List<AbstractProjectile> projectiles) {
		// TODO finish method when BombProjectile is done
		
	}

	@Override
	public int getUpgrades() {
		return upgrades;
	}

}
