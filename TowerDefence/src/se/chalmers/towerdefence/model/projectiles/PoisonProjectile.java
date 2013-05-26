package se.chalmers.towerdefence.model.projectiles;

import se.chalmers.towerdefence.model.Effect;
import se.chalmers.towerdefence.model.monsters.AbstractMonster;

public class PoisonProjectile extends AbstractProjectile {

	public PoisonProjectile(float x, float y, AbstractMonster monster,
			int damage, int effectLevel) {
		super(x, y, monster, damage, new Effect(effectLevel, 3));
		setID(5); 
	}

}
