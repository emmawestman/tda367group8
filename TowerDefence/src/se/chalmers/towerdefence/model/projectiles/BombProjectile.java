package se.chalmers.towerdefence.model.projectiles;

import java.util.List;

import se.chalmers.towerdefence.model.Effect;
import se.chalmers.towerdefence.model.Wave;
import se.chalmers.towerdefence.model.interfaces.IEffect;
import se.chalmers.towerdefence.model.monsters.AbstractMonster;

/**
 * A projectile that hurts all monsters in the specified range, like a bomb.
 * @author Julia, Jonathan, Emma, Oskar
 *
 */
public class BombProjectile extends AbstractProjectile {
	
	private List<Wave> waves;
	private static IEffect effect = new Effect(1,1);
	private int range;
	
	public BombProjectile(float x, float y, int damage, AbstractMonster monster, List<Wave> waves, int range) {
		super(x, y, monster, damage, effect);
		this.range = range;
		this.waves = waves;
		setID(2);
		setSpeed(2);
	}
	
	@Override
	public void hitMonster() {
		for(Wave w : waves){
			for(AbstractMonster m: w.getMonstersOnGameBoard()){
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
