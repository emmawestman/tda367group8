package se.chalmers.towerdefence.model.projectiles;

import se.chalmers.towerdefence.model.Effect;
import se.chalmers.towerdefence.model.monsters.AbstractMonster;
/**
 * A class to represent a projectile of the type poison the projectile 
 * hurts the monster over time and slows the monsters movement.
 * @author Emma, Julia, Oskar, Jonathan
 *
 */
public class PoisonProjectile extends AbstractProjectile {

	public PoisonProjectile(float x, float y, AbstractMonster monster,
			int damage, int effectLevel) {
		super(x, y, monster, damage, new Effect(effectLevel, 3));
		setID(5); 
	}

}
