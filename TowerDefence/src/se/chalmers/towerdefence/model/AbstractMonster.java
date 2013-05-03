package se.chalmers.towerdefence.model;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class AbstractMonster {
	private RoadSquare currentSquare;
	private RoadSquare nextSquare;
	
	private ArrayList <IEffect> effects = new ArrayList<IEffect>();
	
	private Road road;
	private boolean alive = true;
	private float x;
	private float y;
	private int xDirection;
	private int yDirection;
	private float speed;
	private int life;
	private int pointsIfKilled;
	private int resorcesIfKilled;
	private Player player;
	private final int ID;

	public AbstractMonster(Road road, Player player, int ID){
		this.road = road;
		this.player = player;
		speed = 1.25f;
		life = 20;
		currentSquare = road.getFirst();
		x = currentSquare.getX();
		y = currentSquare.getY();
		nextSquare = road.getNext(currentSquare);
		xDirection = getDirection(currentSquare.getX(),nextSquare.getX());
		yDirection = getDirection(currentSquare.getY(),nextSquare.getY());
		this.ID = ID;
	}
	
	public AbstractMonster(int life, float speed, int pointsIfKilled, int reasorcesOnDeath,
						Road road, Player player, int ID){
		this(road, player, ID);
		this.life = life;
		this.speed = speed;
		this.pointsIfKilled = pointsIfKilled;
		this.resorcesIfKilled = reasorcesOnDeath;
		currentSquare = road.getFirst();
		x = currentSquare.getX();
		y = currentSquare.getY();
		nextSquare = road.getNext(currentSquare);
		xDirection = getDirection(currentSquare.getX(),nextSquare.getX());
		yDirection = getDirection(currentSquare.getY(),nextSquare.getY());
	}
	

	public void move() {
		if(Math.abs((int)(x-road.getLast().getX())) == 0 && Math.abs((int)(y-road.getLast().getY())) == 0) {
			player.looseLife();
			die();


		}else if(Math.abs((int)(x-nextSquare.getX())) == 0 && Math.abs((int)(y-nextSquare.getY())) == 0) {	
			currentSquare = nextSquare;
			nextSquare = road.getNext(currentSquare);
			xDirection = getDirection(currentSquare.getX(),nextSquare.getX());
			yDirection = getDirection(currentSquare.getY(),nextSquare.getY());
		}else{
			if(effects.isEmpty()){
				x = x + xDirection*speed;
				y = y + yDirection*speed;
			}else{
				float slowing = 1f;
				for(Iterator<IEffect> it = effects.iterator(); it.hasNext();){
					IEffect e = it.next();
					if(e.isActive()){
						slowing = slowing*e.getSlowingeEffect();
						hurt(e.getDamage());
					}else{
						it.remove();
						System.out.println("AbstractMonster: removing monster");
					}
				}
				x = x + xDirection*speed*slowing;
				y = y + yDirection*speed*slowing;
			}
			
		} 
	}

	public int getDirection(int currentCordinate, int nextCordinate){
		if(currentCordinate > nextCordinate){
			return -1;
		}else if(currentCordinate < nextCordinate){
			return 1;
		}else{
			return 0;
		}
	}
	
	public float getX(){
		return x;		
	}

	public float getY(){
		return y;		
	}

	public int getLife() {
		return life;
	}

	public void die() {
		alive = false;
	}

	public void hurt(int damage) {
		life -= damage;
		if(life <= 0){
			player.addPoints(pointsIfKilled);
			player.addResources(resorcesIfKilled);
			die();
		}
	}

	public boolean isAlive() {
		return alive;
	}

	public boolean equals(Object o) {
		if(o == this){
			return true;
		}else if(o == null || !o.getClass().equals(this.getClass())) {
			return false;
		}else{
			Monster monster = (Monster)o;
			return this.getX()==monster.getX() && this.getY()==monster.getY() && this.getLife()==monster.getLife();
		}
	}

	public int getID() {
		return ID;
	}
	
	public void addEffect(IEffect effect){
		if(effects.isEmpty()){
			effects.add(effect);
		}else{
			for(Iterator<IEffect> it = effects.iterator(); it.hasNext();){
				IEffect e = it.next();
				if(effects.size() < 3 && effect.getEffectType() != e.getEffectType()){
					effects.add(effect);
				}else if(effect.getEffectType() == e.getEffectType() && 
					effect.getLevelOfEffect() > e.getLevelOfEffect()){
					it.remove();
				}else{
					e.resetTimer();
				}
			}
		}
	}

}