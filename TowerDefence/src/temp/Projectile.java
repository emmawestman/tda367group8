package temp;

import se.chalmers.towerdefence.model.AbstractMonster;
import se.chalmers.towerdefence.model.AbstractProjectile;


public class Projectile extends AbstractProjectile{

	public Projectile(float x, float y, AbstractMonster monster, int damage){
		super(x,y,monster, damage);
	}
}