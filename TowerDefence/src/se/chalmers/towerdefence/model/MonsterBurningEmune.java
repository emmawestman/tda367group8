package se.chalmers.towerdefence.model;

public class MonsterBurningEmune extends AbstractMonster{
	
	public MonsterBurningEmune(Road road, Player player) {
		super(20, 1.35f, 50, 50,road, player, 3);
	}
	@Override
	protected boolean isEmune(IEffect effect) {
		return effect.getEffectType() == 2;
	}

}
