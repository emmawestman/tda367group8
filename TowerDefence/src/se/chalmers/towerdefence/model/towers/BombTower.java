package se.chalmers.towerdefence.model.towers;

import java.util.List;

import se.chalmers.towerdefence.model.GameBoardObject;
import se.chalmers.towerdefence.model.Wave;
import se.chalmers.towerdefence.model.monsters.AbstractMonster;
import se.chalmers.towerdefence.model.projectiles.BombProjectile;

/**
 * A tower that shoots bombs at monsters.
 * @author Julia, Jonathan, Emma, Oskar
 *
 */
public class BombTower extends AbstractTower {
	private int upgradeCost;
	private int upgrades;

	public BombTower(float x, float y, List<GameBoardObject> projectiles, int squareHeight, int squareWidth) {
		super(x, y, projectiles, squareHeight, squareWidth);
		this.upgradeCost = 100;
		this.upgrades = 0;
		setCost(300);
		setDamage(800);
		setPriority(Priorities.FIRST);
		setRange(50);
		setReloadTime(150);
		setID(2);
	}

	@Override
	public AbstractTower upgradeTower() {
		if(upgrades <= 3){
			upgrades++;
			addRange(10);
			addDamage(50);
			addCost(upgradeCost);
			decreaseReloadTime(20);
			return this;
		}else if(upgrades == 4){
			upgrades++;
			this.upgradeCost = 0;
			addRange(10);
			addDamage(50);
			decreaseReloadTime(20);
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
			int damage, List<GameBoardObject> projectiles, List<Wave> waves) {
		BombProjectile p = new BombProjectile(xPos, yPos, damage, monster, waves, getRange());
		projectiles.add(p);
	}

	@Override
	public int getUpgrades() {
		return upgrades;
	}

}
