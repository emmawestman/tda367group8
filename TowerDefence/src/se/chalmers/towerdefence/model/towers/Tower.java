package se.chalmers.towerdefence.model.towers;

import java.util.List;

import se.chalmers.towerdefence.model.interfaces.GameBoardObject;
import se.chalmers.towerdefence.model.monsters.AbstractMonster;
import se.chalmers.towerdefence.model.projectiles.Projectile;
import se.chalmers.towerdefence.model.wave.Wave;

/**
 * A class that represents a normal tower.
 * @author Julia, Jonathan, Emma, Oskar
 *
 */

public class Tower extends AbstractTower{
	private int upgradeCost;
	private int upgrades;


	public Tower(float x, float y, List <GameBoardObject> projectiles, int squareHeight, int squareWidth){
		super(x,y, projectiles, squareHeight, squareWidth);
		this.upgradeCost = 100;
		this.upgrades = 0;
		setCost(200);
		setDamage(350);
		setRange(75);
		setPriority(Priorities.FIRST);
		setReloadTime(50);
		setID(1);
	}

	public void upgradeTower() {
		if(upgrades <= 3){
			upgrades++;
			addRange(15);
			addDamage(70);
			addCost(upgradeCost);
			decreaseReloadTime(5);
		}else if(upgrades == 4){
			upgrades++;
			this.upgradeCost = 0;
			addRange(20);
			addDamage(100);
			decreaseReloadTime(5);
		}
	}

	
	public int getUpgradeCost() {
		return upgradeCost;
	}

	@Override
	public void addProjectile(float xPos, float yPos, AbstractMonster monster, int damage, List<GameBoardObject> projectiles, List<Wave> waves) {
		Projectile p = new Projectile(xPos, yPos, monster, damage);
		projectiles.add(p);
	}

	@Override
	public int getUpgrades() {
		return upgrades;
	}
	


}