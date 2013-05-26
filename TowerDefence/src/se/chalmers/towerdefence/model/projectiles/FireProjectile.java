package se.chalmers.towerdefence.model.projectiles;

import se.chalmers.towerdefence.model.Effect;
import se.chalmers.towerdefence.model.monsters.AbstractMonster;

public class FireProjectile extends AbstractProjectile {

	public FireProjectile(float x, float y, AbstractMonster monster,
			int damage, int effectLevel) {
		super(x, y, monster, damage, new Effect(effectLevel, 2));
		setID(6);
	}

}
