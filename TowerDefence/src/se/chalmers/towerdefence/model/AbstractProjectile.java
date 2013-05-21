package se.chalmers.towerdefence.model;



public class AbstractProjectile {
	private float xPos;
	private float yPos;
	private float width;
	private AbstractMonster monster;
	private float speed = 2.5f;
	private int damage;
	private boolean exists = true;
	private double angleX, angleY;
	private IEffect effect;

	public AbstractProjectile(float x, float y, AbstractMonster monster, int damage) {
		this.xPos = x + 20 + width;
		this.yPos = y + 20 + width;
		this.monster = monster;

		this.width = 5;
		this.damage = damage;

		this.effect = null;
	}

	public AbstractProjectile(float x, float y, AbstractMonster monster, int damage, IEffect effect) {
		this(x, y, monster, damage); 
		this.effect = effect;
	}

	public float getX() {
		return xPos;
	}
	public float getY() {
		return yPos;
	}

	public void move() {
		if(!monster.isAlive()){
			exists = false;
		}
		double devider = 1/Math.sqrt(Math.pow(monster.getX() + 20 - width - xPos,2) + Math.pow(monster.getY() + 20 - width - yPos, 2));
		this.angleX =  devider * (monster.getX() + 20 - width - xPos);
		this.angleY =  devider * (monster.getY() + 20 - width - yPos);
		xPos += angleX * speed;
		yPos += angleY * speed;
		if(xPos>=monster.getX()+10-width && yPos>=monster.getY()+10-width && xPos<=monster.getX()+30-width && yPos<=monster.getY()+30-width){
			hitMonster();
		}


	}

	public void hitMonster() {
		damage();
		if(effect != null){
			monster.addEffect(effect);
		}
		exists = false;
	}

	public void damage(){
		monster.hurt(damage);
	}

	public boolean exists(){
		return exists;
	}

	public boolean hasEffect(){
		if(effect == null){
			return false;
		}else{
			return true;
		}
	}

	public IEffect getEffect(){
		return effect;
	}

	public int getDamage() {
		return damage;
	}
	
	public AbstractMonster getMonster() {
		return monster;
	}
	
	public void setExists(boolean exists) {
		this.exists = exists;
	}
}