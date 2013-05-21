package se.chalmers.towerdefence.model;

public class MonsterFreezingImmune extends AbstractMonster {

	public MonsterFreezingImmune(Road road, Player player) {
		super(15, 2.0f, 30, 30, road, player, 2);
	}
	
	@Override
	protected boolean isImmune(IEffect effect) {
		return effect.getEffectType() == 1;
	}
}
