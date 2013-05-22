package se.chalmers.towerdefence.model;

/**
 * A class used to create a enemy of the type MonsterBurningImmune.
 * These monster are immune to the effect Burning.
 * @author Emma, Julia, Oskar, Jonathan
 *
 */

public class MonsterBurningImmune extends AbstractMonster{
	
	public MonsterBurningImmune(Road road, Player player) {
		super(20, 1.35f, 50, 50,road, player, 3);
	}
	@Override
	protected boolean isImmune(IEffect effect) {
		return effect.getEffectType() == 2;
	}

}
