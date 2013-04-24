package se.chalmers.TowerDefence;

import se.chalmers.slickTD.IMonsterView;
import se.chalmers.slickTD.MonsterView;

public abstract class AbstractMonster {
	private RoadSquare currentSquare;
	private RoadSquare nextSquare;

	private Road road;
	private boolean alive = true;
	private float x;
	private float y;
	private int xDirection;
	private int yDirection;
	private final float speed;
	private int life;
	private int pointsIfKilled;
	private int resorcesIfKilled;
	private IMonsterView mV;
	private Player player;

	public AbstractMonster(Road road, Player player, IMonsterView mV){
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
		this.mV = mV;
	}
	
	public AbstractMonster(int life, float speed, int pointsIfKilled, int reasorcesOnDeath,
						Road road, Player player, IMonsterView mV){
		this.road = road;
		this.player = player;
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
		this.mV = mV;
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
			x = x + xDirection*speed;
			y = y + yDirection*speed;
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

	public void draw(){
		mV.draw(x, y);		
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

}

