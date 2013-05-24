package se.chalmers.towerdefence.model.projectiles;

import se.chalmers.towerdefence.model.IEffect;
import se.chalmers.towerdefence.model.monsters.AbstractMonster;

public class FreezingProjectile extends AbstractProjectile {

	public FreezingProjectile(float x, float y, AbstractMonster monster,
			int damage, IEffect effect) {
		super(x, y, monster, damage, effect);
		setID(4);
	}
	
	

}
