package se.chalmers.towerdefence.model.monsters;

import se.chalmers.towerdefence.model.IEffect;
import se.chalmers.towerdefence.model.Player;
import se.chalmers.towerdefence.model.Road;

/**
 * A class used to create a enemy of the type MonsterFreezingImmune.
 * These monster are immune to the effect Freezing.
 * @author Emma, Julia, Oskar, Jonathan
 *
 */

public class MonsterFreezingImmune extends AbstractMonster {

	public MonsterFreezingImmune(Road road, Player player) {
		super(15, 2.0f, 30, 30, road, player, 2);
	}
	
	@Override
	protected boolean isImmune(IEffect effect) {
		return effect.getEffectType() == 1;
	}
}
