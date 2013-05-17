package se.chalmers.towerdefence.model;

public class MonsterFreezingEmune extends AbstractMonster {

	public MonsterFreezingEmune(Road road, Player player) {
		super(15, 2.0f, 30, 30, road, player, 2);
	}
	
	@Override
	protected boolean isEmune(IEffect effect) {
		return effect.getEffectType() == 1;
	}
}
