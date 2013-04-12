package se.chalmers.TowerDefence;

import java.util.Observable;
import java.util.Observer;
import javax.swing.text.Position;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import se.chalmers.TowerDefence.Road;
import se.chalmers.TowerDefence.RoadSquare;

	public abstract class AbstractMonster extends Observable {
		private Image image;
		private RoadSquare currentSquare;
		private RoadSquare nextSquare;
		private int currentSquareX;
		private int currentSquareY;
		private int nextSquareY;
		private int nextSquareX;
		private Road road;
		private boolean alive = true;
		private float x;
		private float y;

		public AbstractMonster(Road road) throws SlickException {
			road = road;
			currentSquare = road.getFirst();
			currentSquareX = currentSquare.getX();
			currentSquareY = currentSquare.getY();
			x = currentSquareX;
			y = currentSquareY;
			nextSquare = road.getNext(currentSquare);
			nextSquareX = nextSquare.getX();
			nextSquareY = nextSquare.getY();
			image = new Image("res/monster.gif");
		}
		
		public void move() {
			if(x >= nextSquareX && y >= nextSquareY) {
				currentSquare = nextSquare;
				nextSquare = road.getNext(currentSquare);
				currentSquareX = currentSquare.getX();
				currentSquareY = currentSquare.getY();
				nextSquareX = nextSquare.getX();
				nextSquareY = nextSquare.getY();
			}else{
				x = x + ((nextSquareX - currentSquareX)/60);
				y = y + ((nextSquareY - currentSquareY)/60);
			}
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

