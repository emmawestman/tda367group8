package se.chalmers.towerdefence.model.projectiles;

import se.chalmers.towerdefence.model.monsters.AbstractMonster;

/**
 * A projectile that keeps hurting a monster when in range, like a laser.
 * @author Julia, Jonathan, Emma, Oskar
 *
 */
public class LaserProjectile extends AbstractProjectile {
	private int range;
	private int timer;
	private int reloadTime;

	public LaserProjectile(float x, float y, AbstractMonster monster, int damage, int range, int reloadTime) {
		super(x, y, monster, damage);
		this.range = range;
		this.reloadTime = reloadTime;
		setID(3);
	}

	@Override
	public void hitMonster() {
		timer = 0;
		AbstractMonster monster = getMonster();
		while(monsterInRange(monster)) {
			if(monster.isAlive()){
				if(timer <= 0) {
				damage();
				timer = reloadTime;
				}else{
					timer--;
				}
			}else{
				break;
			}
		}
		setExists(false);
	}

	public boolean monsterInRange(AbstractMonster m) {
		return (m.getX()>=getX()-range && m.getX()<=getX()+range && m.getY()>=getY()-range && m.getY()<=getY()+range);
	}
}
