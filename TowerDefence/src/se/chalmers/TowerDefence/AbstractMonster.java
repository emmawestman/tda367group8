package se.chalmers.TowerDefence;

import java.util.Observable;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

	public abstract class AbstractMonster extends Observable {
		private Image image;
		private RoadSquare currentSquare;
		private RoadSquare nextSquare;
		
		private Road road;
		private boolean alive = true;
		private float x;
		private float y;
		private int xDirection;
		private int yDirection;
		private final float speed;
		public AbstractMonster(Road road) throws SlickException {
			this.road = road;
			speed = 0.5f;
			currentSquare = road.getFirst();
			x = currentSquare.getX();
			y = currentSquare.getY();
			nextSquare = road.getNext(currentSquare);
			xDirection = getDirection(currentSquare.getX(),nextSquare.getX());
			yDirection = getDirection(currentSquare.getY(),nextSquare.getY());
			image = new Image("res/monster.gif");
			
		}
		
		public void move() {
			//*
			if(Math.abs((int)(x-nextSquare.getX())) == 0 && Math.abs((int)(y-nextSquare.getY())) == 0) {	
				currentSquare = nextSquare;
				nextSquare = road.getNext(currentSquare);
				xDirection = getDirection(currentSquare.getX(),nextSquare.getX());
				yDirection = getDirection(currentSquare.getY(),nextSquare.getY());
			}else{
				x = x + xDirection*speed;
				y = y + yDirection*speed;
			} 
			//*/
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
			image.draw(x, y);		
		}
		
//		public void die() {
//			alive = false;
//			notifyObservers(alive);
//		}
		
//		public boolean equals(Object o) {
//			if(o == null || !o.getClass().equals(this.getClass())) {
//				return false;
//			}
//		}
		
	}

