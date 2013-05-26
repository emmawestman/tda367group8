package se.chalmers.towerdefence.model.monsters;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import se.chalmers.towerdefence.model.Player;
import se.chalmers.towerdefence.model.Road;
import se.chalmers.towerdefence.model.RoadSquare;
import se.chalmers.towerdefence.model.interfaces.GameBoardObject;
import se.chalmers.towerdefence.model.interfaces.IEffect;

/**
 * A class to describe the general characteristics of a monster.
 * @auther Emma Westman
 * @auther Julia Friberg
 * @auther Oskar Dahlberg
 * @auther Jonathan Thunberg
 *
 */
public abstract class AbstractMonster implements GameBoardObject {
	private RoadSquare currentSquare;
	private RoadSquare nextSquare;

	private List <IEffect> effects = new LinkedList<IEffect>();

	private Road road;
	private boolean alive;
	private float x;
	private float y;
	private int xDirection;
	private int yDirection;
	private float speed;
	private int life;
	private final int maxLife;
	private int pointsIfKilled;
	private int resorcesIfKilled;
	private Player player;
	private final int ID;

	public AbstractMonster(Road road, Player player, int ID){
		this.road = road;
		this.player = player;
		speed = 1.25f;
		life = 20;
		maxLife = life;
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
		this.road = road;
		this.player = player;
		this.life = life;
		this.maxLife = this.life;
		this.speed = speed;
		this.pointsIfKilled = pointsIfKilled;
		this.resorcesIfKilled = reasorcesOnDeath;
		this.ID = ID;
		currentSquare = road.getFirst();
		x = currentSquare.getX();
		y = currentSquare.getY();
		nextSquare = road.getNext(currentSquare);
		xDirection = getDirection(currentSquare.getX(),nextSquare.getX());
		yDirection = getDirection(currentSquare.getY(),nextSquare.getY());
		alive = true;
	}


	public void move() {
		if(Math.abs((int)(x-road.getLast().getX())) == 0 && Math.abs((int)(y-road.getLast().getY())) == 0) {
			playerLooseLife();
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

	public int getXDirection(){
		return xDirection;		
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

	public boolean exists() {
		return alive;
	}

	public void addEffect(IEffect effect){
		if(! isImmune(effect)) {
			int place = -1;
			for(int i = 0; i < effects.size(); i++){
				if(effects.get(i).getEffectType() == effect.getEffectType()){
					place = i;
				}
			}
			
			if(place != -1){
				if(effects.get(place).getLevelOfEffect() < effect.getLevelOfEffect()){
					effects.get(place).endEffect();
					effects.add(effect);
				}else{
					effects.get(place).resetTimer();
				}
			}else{
				effects.add(effect);
			}
			
		}
	}

	public float getPercentageOfHealth(){
		return (float)(life)/maxLife;
	}
	
	protected boolean isImmune(IEffect effect) {
		return false;
	}
	
	protected Player getPlayer() {
		return player;
	}

	public void playerLooseLife() {
		player.looseLife();
	}
}