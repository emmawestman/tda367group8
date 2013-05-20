package se.chalmers.towerdefence.model;

import java.util.List;

public class BombProjectile extends AbstractProjectile {
	
	private List<Wave> waves;
	private static IEffect effect = new Effect(1,1);
	private int range;
	
	public BombProjectile(float x, float y, int damage, AbstractMonster monster, List<Wave> waves, int range) {
		super(x, y, monster, damage, effect);
		this.range = range;
		this.waves = waves;
	}
	
	@Override
	public void hitMonster() {
		for(Wave w : waves){
			for(AbstractMonster m: w.getmonstersOnGameBoard()){
				if(monsterInRange(m)){
					m.hurt(getDamage());
				}
			}
		}
		setExists(false);
	}
	
	public boolean monsterInRange(AbstractMonster m) {
		return (m.getX()>=getX()-range && m.getX()<=getX()+range && m.getY()>=getY()-range && m.getY()<=getY()+range);
	}

}
