package se.chalmers.towerdefence.model.monsters;

import se.chalmers.towerdefence.model.Player;
import se.chalmers.towerdefence.model.Road;
import se.chalmers.towerdefence.model.interfaces.IEffect;

/**
 * A class used to create a enemy of the type MonsterFreezingImmune.
 * These monster are immune to the effect Freezing.
 * @author Emma, Julia, Oskar, Jonathan
 *
 */

public class MonsterFreezingImmune extends AbstractMonster {

	public MonsterFreezingImmune(Road road, Player player) {
		super(1500, 2.0f, 40, 40, road, player, 2);
	}
	
	@Override
	protected boolean isImmune(IEffect effect) {
		return effect.getEffectType() == 1;
	}
}
