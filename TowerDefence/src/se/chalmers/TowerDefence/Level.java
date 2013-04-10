package se.chalmers.TowerDefence;

import java.util.LinkedList;

public class Level {
	private final int[][] road=new int[][]{
			new int[]{0,0,0,0,0,0},
			new int[]{1,1,1,0,0,0},
			new int[]{0,0,1,0,0,0},
			new int[]{0,0,1,1,1,0},
			new int[]{0,0,0,0,0,0}};
	private LinkedList<RoadSquare> roadIterator=new LinkedList<RoadSquare>();
	
	public Level(){
		int i=1;
    	int j=0;
    	boolean temp=true;
    	roadIterator.add(new RoadSquare(i,j));
    	while(temp){    		
	    	if(road[i+1][j]==1){
	    		roadIterator.add(new RoadSquare(i+1,j));
	    		i++;
	    	}else if(road[i][j+1]==1){
	    		roadIterator.add(new RoadSquare(i,j+1));
	    		j++;
	    	}else{
	    		temp=false;
	    	}
    	}
	}
	
	
	@Override
	public String toString(){
		String temp=new String();
		for(int i=0; i<road.length;i++){
			for(int j=0; j<road.length;j++){
				temp+=road[i][j]+" ";
			}
			temp+="\n";
		}
		
		for(RoadSquare rs : roadIterator){
			temp+=rs;
		}
		
		return temp;	
	}
	public int[][] getRoad(){
		return road;
	}
}
