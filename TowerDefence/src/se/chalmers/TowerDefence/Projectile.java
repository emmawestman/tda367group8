package se.chalmers.TowerDefence;

import org.newdawn.slick.SlickException;

public class Projectile extends AbstractProjectile{

	public Projectile(float x, float y, AbstractMonster monster) throws SlickException {
		super(x,y,monster);
	}
}