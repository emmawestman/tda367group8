package se.chalmers.towerdefence.model;



public class Projectile extends AbstractProjectile{

	public Projectile(float x, float y, AbstractMonster monster, int damage){
		super(x,y,monster, damage);
	}
	public Projectile(float x, float y, AbstractMonster monster, int damage, IEffect effect){
		super(x,y,monster, damage, effect);
	}
}