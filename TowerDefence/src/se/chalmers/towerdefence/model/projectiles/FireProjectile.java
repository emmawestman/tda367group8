package se.chalmers.towerdefence.model.projectiles;

import se.chalmers.towerdefence.model.Effect;
import se.chalmers.towerdefence.model.monsters.AbstractMonster;
/**
 * A class to represent a projectile of the type fire 
 * the projectile hurts the monster.
 * Flame tower uses this projectile.
 * @author Emma, Julia, Oskar, Jonathan
 *
 */
public class FireProjectile extends AbstractProjectile {

	public FireProjectile(float x, float y, AbstractMonster monster,
			int damage, int effectLevel) {
		super(x, y, monster, damage, new Effect(effectLevel, 2));
		setID(6);
	}

}
