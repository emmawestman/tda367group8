package se.chalmers.towerdefence.model;

import se.chalmers.towerdefence.model.monsters.AbstractMonster;

/**
 * A class that represents a normal projectile. Can have different effects.
 * @author Julia, Jonathan, Emma, Oskar
 *
 */

public class Projectile extends AbstractProjectile{

	public Projectile(float x, float y, AbstractMonster monster, int damage){
		super(x,y,monster, damage);
		setID(1);
	}
	public Projectile(float x, float y, AbstractMonster monster, int damage, IEffect effect){
		super(x,y,monster, damage, effect);
		setID(1);
	}
}