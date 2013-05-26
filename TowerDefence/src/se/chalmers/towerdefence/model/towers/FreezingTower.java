package se.chalmers.towerdefence.model.towers;

import java.util.List;

import se.chalmers.towerdefence.model.Wave;
import se.chalmers.towerdefence.model.interfaces.GameBoardObject;
import se.chalmers.towerdefence.model.monsters.AbstractMonster;
import se.chalmers.towerdefence.model.projectiles.AbstractProjectile;
import se.chalmers.towerdefence.model.projectiles.FreezingProjectile;

/**
 * A tower with freezing effect.
 * @author Julia, Jonathan, Emma, Oskar
 *
 */
public class FreezingTower extends AbstractTower {
	private int upgradeCost;
	private int upgrades;

	public FreezingTower(float x, float y,
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
		setID(4);
	}

	@Override
	public void addProjectile(float xPos, float yPos, AbstractMonster monster,
			int damage, List<GameBoardObject> projectiles, List<Wave> waves) {
		AbstractProjectile p = new FreezingProjectile(xPos, yPos, monster, damage, upgrades);
		projectiles.add(p);

	}

	@Override
	public AbstractTower upgradeTower() {
		if(upgrades <= 3){
			upgrades++;
			addRange(10);
			addCost(upgradeCost);
			decreaseReloadTime(2);
			return this;
		}else if(upgrades == 4){
			upgrades++;
			upgradeCost = 0;
			addRange(10);
			addDamage(0);
			decreaseReloadTime(2);
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
	public int getUpgrades() {
		return upgrades;
	}

}
