package se.chalmers.TowerDefence;

public class RoadSquare{
	private int x;
	private int y;
	public RoadSquare(int posx,int posy){
        x=posx;
        y=posy;
    }
	public int[] getXY(){
		return new int[]{x,y};
	}
	@Override
	public String toString(){
		return x+" "+y+";";
		
	}
}
