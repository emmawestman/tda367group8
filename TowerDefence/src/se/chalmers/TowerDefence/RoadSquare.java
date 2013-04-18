package se.chalmers.TowerDefence;

public class RoadSquare implements ISquare{
	
	private final int x;
	private final int y;
	private final int length;
	
	public RoadSquare(int x, int y){
        length = 40;
		this.x = x * length;
        this.y = y * length;
    }
	
//	public int[] getPosition(){
//		return new int[] {x,y};
//	}
	
	public int getX(){
		return x;
	}
	
	public int getLength(){
		return length;
	}
	
	public int getY(){
		return y;
	}
	@Override
	public String toString(){
		return "\n" + x + " " + y ;
	}
	
	@Override
	public boolean equals(Object o){
		if(this == o){
			return true;
		}else if(o == null || o.getClass() != this.getClass()){
			return false;
		}else{
			RoadSquare tempSquare = (RoadSquare)o;
			return (tempSquare.getX() == this.getX() && tempSquare.getY() == this.getY());
		}
	}
	
	public boolean isBlocked(){
		return true;
	}

	@Override
	public boolean isRoad() {
		return true;
	}
}
