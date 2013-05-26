package se.chalmers.towerdefence.model.towers;

import java.util.ArrayList;
import java.util.List;

import se.chalmers.towerdefence.model.Effect;
import se.chalmers.towerdefence.model.IEffect;
import se.chalmers.towerdefence.model.Wave;
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
	private IEffect effect;

	public FreezingTower(float x, float y,
			ArrayList<AbstractProjectile> projectiles, int squareHeight,
			int squareWidth) {
		super(x, y, projectiles, squareHeight, squareWidth);
		upgradeCost = 50;
		upgrades = 0;
		effect = new Effect(1,1);
		setCost(200);
		setDamage(0);
		setRange(150);
		setPriority(Priorities.FIRST);
		setReloadTime(30);
		setID(4);
	}

	@Override
	public void addProjectile(float xPos, float yPos, AbstractMonster monster,
			int damage, List<AbstractProjectile> projectiles, List<Wave> waves) {
		AbstractProjectile p = new FreezingProjectile(xPos, yPos, monster, damage, effect);
		projectiles.add(p);

	}

	@Override
	public AbstractTower upgradeTower() {
		if(upgrades <= 3){
			upgrades++;
			addRange(10);
			addCost(upgradeCost);
			decreaseReloadTime(2);
			effect = new Effect(upgrades, 1);
			return this;
		}else if(upgrades == 4){
			upgrades++;
			upgradeCost = 0;
			effect = new Effect(upgrades, 1);
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