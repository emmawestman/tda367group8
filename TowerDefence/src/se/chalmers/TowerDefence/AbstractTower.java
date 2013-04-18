package se.chalmers.TowerDefence;

import java.util.ArrayList;

import se.chalmers.slickTD.TowerView;

public class AbstractTower {
	private float xPos;
	private float yPos;
	private TowerView tV;
	private int range;
	private int timer=30;
	private ArrayList <Projectile> projectiles;
	private int cost = 100;

	public AbstractTower(float x, float y, int range, ArrayList <Projectile> projectiles) {
		this.xPos = x*40;
		this.yPos = y*40;
		this.range = range;
		this.projectiles = projectiles;
		tV=new TowerView();
	}
	
	public void draw() {
		tV.draw(xPos,yPos);
	}
	
	public void tryShoot(ArrayList<Wave> waves) {
		if(timer==20){
			outerloop:
			for(Wave w : waves){
				for(AbstractMonster m: w.getMonsterWave()){
					if(monsterInRange(m)){
						Projectile p=new Projectile(xPos,yPos,m);
						projectiles.add(p);
						break outerloop;
					}
				}
			}			
		}		
		timer--;
		if(timer<=0){
			timer=60;
		}
		
	}
	
	public int getCost() {
		return cost;
	}
	
	public boolean monsterInRange(AbstractMonster m) {
		return (m.getX()>=xPos-range && m.getX()<=xPos+range && m.getY()>=yPos-range && m.getY()<=yPos+range);
	}

}
