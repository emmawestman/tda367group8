package se.chalmers.towerdefence.model.towers;

import java.util.List;

import se.chalmers.towerdefence.model.Wave;
import se.chalmers.towerdefence.model.interfaces.GameBoardObject;
import se.chalmers.towerdefence.model.monsters.AbstractMonster;
import se.chalmers.towerdefence.model.projectiles.AbstractProjectile;
import se.chalmers.towerdefence.model.projectiles.FireProjectile;

/**
 * A tower with burning effect.
 * @author Julia, Jonathan, Emma, Oskar
 *
 */

public class FlameTower extends AbstractTower {
	private int upgradeCost;
	private int upgrades;

	public FlameTower(float x, float y,
			List<GameBoardObject> projectiles, int squareHeight,
			int squareWidth) {
		super(x, y, projectiles, squareHeight, squareWidth);
		upgradeCost = 100;
		upgrades = 0;
		setCost(200);
		setDamage(0);
		setRange(100);
		setPriority(Priorities.FIRST);
		setReloadTime(40);
		setID(6);
	}

	@Override
	public void addProjectile(float xPos, float yPos, AbstractMonster monster,
			int damage, List<GameBoardObject> projectiles, List<Wave> waves) {
		AbstractProjectile p = new FireProjectile(xPos, yPos, monster, damage, upgrades);
		projectiles.add(p);

	}

	@Override
	public void upgradeTower() {
		if(upgrades <= 3){
			upgrades++;
			addRange(10);
			addCost(upgradeCost);
			decreaseReloadTime(2);
		}else if(upgrades == 4){
			upgrades++;
			upgradeCost = 0;
			addRange(10);
			addDamage(0);
			decreaseReloadTime(2);
		}
	}

	@Override
	public int getUpgradeCost() {
		return upgradeCost;
	}

	@Override
	public int getUpgrades() {
		return upgrades;
	}

}
