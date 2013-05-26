package se.chalmers.towerdefence.model.projectiles;

import se.chalmers.towerdefence.model.Effect;
import se.chalmers.towerdefence.model.monsters.AbstractMonster;
/**
 * A class to represent a projectile of the type snow 
 * the projectile slows the monsters movement.
 * Freezing tower uses this projectile.
 * @author Julia, Emma, Oskar, jonathan
 *
 */
public class FreezingProjectile extends AbstractProjectile {

	public FreezingProjectile(float x, float y, AbstractMonster monster,
			int damage, int effectLevel) {
		super(x, y, monster, damage, new Effect(effectLevel, 1));
		setID(4);
	}
	
	

}
