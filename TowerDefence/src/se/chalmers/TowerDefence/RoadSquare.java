package se.chalmers.TowerDefence;

public class RoadSquare implements ISquare{
	
	private int x;
	private int y;
	
	public RoadSquare(int x, int y){
        this.x = x;
        this.y = y;
    }
	
//	public int[] getPosition(){
//		return new int[] {x,y};
//	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	@Override
	public String toString(){
		return x + " " + y + "\n";
		
	}
}
