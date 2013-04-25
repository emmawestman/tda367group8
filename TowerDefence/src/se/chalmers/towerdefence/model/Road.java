package se.chalmers.towerdefence.model;

import java.util.ArrayList;


public class Road {
	private enum Direction {NORTH, SOUTH, EAST, WEST};
	private Direction direction;
	
	private ArrayList<RoadSquare> roadIterator;
	
	public Road(GameBoard gameBoard){
		this.roadIterator = new ArrayList<RoadSquare>();
		findRoad(gameBoard);
	}
	

	private void findRoad(GameBoard gameBoard){
		ISquare[][] gb = gameBoard.getGameBoard();
		int x = 0;
		int y = 5;
		for(int i = 0; i < gb[0].length; i++){
			if(gb[0][i].isRoad()){
				y = i;
				roadIterator.add(new RoadSquare(x-1, y));
			}
		}
//		roadIterator.add(new RoadSquare(x,y));
		setDirection(Direction.EAST);
		boolean temp = true;
		while (temp) {
			if(direction == Direction.EAST) {
				while(x < gb.length && gb[x+1][y].isRoad()) {
					x++;
				}
				roadIterator.add(new RoadSquare(x,y));
				if(y < gb[x].length && gb[x][y+1].isRoad()) {
					setDirection(Direction.SOUTH);
				}else if(y > 0 && gb[x][y-1].isRoad()){
					setDirection(Direction.NORTH);
				}else{
					roadIterator.add(new RoadSquare(x+1, y));
					temp = false;
				}
			}else if(direction == Direction.WEST) {
				while(x > 0 && gb[x-1][y].isRoad()) {
					x--;
				}
				roadIterator.add(new RoadSquare(x,y));
				if(y < gb[x].length && gb[x][y+1].isRoad()) {
					setDirection(Direction.SOUTH);
				}else if(y > 0 && gb[x][y-1].isRoad()){
					setDirection(Direction.NORTH);
				}else{
					roadIterator.add(new RoadSquare(x-1, y));
					temp = false;
				}
			}else if(direction == Direction.NORTH) {
				while(y-1 >= 0 && gb[x][y-1].isRoad()) {
					y--;
				}
				roadIterator.add(new RoadSquare(x,y));
				if(x < gb.length && gb[x+1][y].isRoad()) {
					setDirection(Direction.EAST);
				}else if(x > 0 && gb[x-1][y].isRoad()) {
					setDirection(Direction.WEST);
				}else{
					roadIterator.add(new RoadSquare(x, y-1));
					temp = false;
				}
			}else if(direction == Direction.SOUTH){
				while(y < gb[x].length && gb[x][y+1].isRoad()) {
					y++;
				}
				roadIterator.add(new RoadSquare(x,y));
				if(x < gb.length && gb[x+1][y].isRoad()) {
					setDirection(Direction.EAST);
				}else if(x > 0 && gb[x-1][y].isRoad()) {
					setDirection(Direction.WEST);
				}else{
					roadIterator.add(new RoadSquare(x, y+1));
					temp = false;
				}
			}else{
				temp = false;
			}
//			if(roadIterator.size() > 12){
//				temp = false;
//			}
		}
	}
		
	
	public RoadSquare getFirst(){
		return roadIterator.get(0); 
	}
	
	public RoadSquare getNext(RoadSquare tempSquare){
		for(int i = 0; i < roadIterator.size(); i++){

			if(roadIterator.get(i).equals(tempSquare) && !(getLast().equals(tempSquare))){
				return roadIterator.get(i+1);
			}
		}
		return getLast();
	}
	
	public RoadSquare getLast(){
		return roadIterator.get(roadIterator.size()-1);
	}
	
	public void typeToString(){
		for(RoadSquare RS : roadIterator){
			System.out.println("Road: " + RS.getX() + "  " + RS.getY());
		}
	}
	
	public void setDirection(Direction direction){
		this.direction = direction;
		
	}
	
	public String toString(){
		return roadIterator.toString();
	}
	
}