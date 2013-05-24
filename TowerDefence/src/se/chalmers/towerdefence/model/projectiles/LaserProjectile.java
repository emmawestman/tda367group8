package se.chalmers.towerdefence.model.projectiles;

import se.chalmers.towerdefence.model.monsters.AbstractMonster;

/**
 * A projectile that keeps hurting a monster when in range, like a laser.
 * @author Julia, Jonathan, Emma, Oskar
 *
 */
public class LaserProjectile extends AbstractProjectile {

	public LaserProjectile(float x, float y, AbstractMonster monster, int damage) {
		super(x, y, monster, damage);
		setID(3);
		setSpeed(4);
	}

}
