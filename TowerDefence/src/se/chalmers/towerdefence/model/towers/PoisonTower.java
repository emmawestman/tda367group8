package se.chalmers.towerdefence.model.towers;

import java.util.List;

import se.chalmers.towerdefence.model.interfaces.GameBoardObject;
import se.chalmers.towerdefence.model.monsters.AbstractMonster;
import se.chalmers.towerdefence.model.projectiles.AbstractProjectile;
import se.chalmers.towerdefence.model.projectiles.PoisonProjectile;
import se.chalmers.towerdefence.model.wave.Wave;

/**
 * A tower with a poisonous effect.
 * @author Julia, Jonathan, Emma, Oskar
 *
 */
public class PoisonTower extends AbstractTower {
	private int upgradeCost;
	private int upgrades;

	public PoisonTower(float x, float y,
			List<GameBoardObject> projectiles, int squareHeight,
			int squareWidth) {
		super(x, y, projectiles, squareHeight, squareWidth);
		upgradeCost = 100;
		upgrades = 0;
		setCost(200);
		setDamage(0);
		setRange(100);
		setPriority(Priorities.WEAKEST);
		setReloadTime(40);
		setID(5);
	}

	@Override
	public void addProjectile(float xPos, float yPos, AbstractMonster monster,
			int damage, List<GameBoardObject> projectiles, List<Wave> waves) {
		AbstractProjectile p = new PoisonProjectile(xPos, yPos, monster, damage, upgrades);
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
