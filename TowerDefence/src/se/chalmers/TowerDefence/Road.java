package se.chalmers.TowerDefence;

import java.util.LinkedList;

public class Road {
	
	private LinkedList<RoadSquare> roadIterator;
	
	public Road(GameBoard gameBoard){
		this.roadIterator = new LinkedList<RoadSquare>();
		findRoad(gameBoard);
	}
	
	public Road(Road clone){
		//TODO clone constuctor
	}
	
	private void findRoad(GameBoard gameBoard){
		int[][] gb = gameBoard.getGameBoard();
		//TODO better algoritm
		int x = 1;
    	int y = 0;
    	boolean temp = true;
    	roadIterator.add(new RoadSquare(x,y));
    	while(temp){
    		int lastX = roadIterator.getLast().getX();
    		int lastY = roadIterator.getLast().getY();
    		
    		if(gb[x+1][y] == 1 && !roadIterator.contains(new RoadSquare(x,y))){
    			roadIterator.add(new RoadSquare(x+1, y));
    		}else if(gb[x-1][y] == 1 && !roadIterator.contains(new RoadSquare(x,y))){
    			roadIterator.add(new RoadSquare(x-1, y));
    		}else if(gb[x][y+1] == 1 && !roadIterator.contains(new RoadSquare(x,y))){
    			roadIterator.add(new RoadSquare(x, y+1));
    		}else if(gb[x][y-1] == 1 && !roadIterator.contains(new RoadSquare(x,y))){
    			roadIterator.add(new RoadSquare(x, y+1));
    		}else{
    			temp = false;
    		}
    		/*
    		if(gb[x+1][y] == 1){
	    		roadIterator.add(new RoadSquare(x+1,y));
	    		x++;
	    	}else if(gb[x][y+1]==1){
	    		roadIterator.add(new RoadSquare(x,y+1));
	    		y++;
	    	}else{
	    		temp=false;
	    	}
	    	//*/
    	}
		
	}
	public RoadSquare getFirst(){
		//TODO
		return null;
	}
	
	public RoadSquare getNext(RoadSquare i){
		return null;
	}
	
	public RoadSquare getLast(){
		return null;
	}
	
}
