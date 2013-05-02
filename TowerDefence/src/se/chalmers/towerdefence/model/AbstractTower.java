package se.chalmers.towerdefence.model;

import java.util.ArrayList;
import java.util.List;


public abstract class AbstractTower {
	private float xPos;
	private float yPos;
	private int range;
	private int timer;
	private int reloadTime;
	private ArrayList <AbstractProjectile> projectiles;
	private int cost;
	private int damage;
	private enum Priorities {FIRTS, WEAKEST};
	private Priorities priority;

	public AbstractTower(float x, float y, int range, ArrayList <AbstractProjectile> projectiles, int reloadTime, int cost, int damage) {
		this.xPos = x*40;
		this.yPos = y*40;
		this.range = range;
		this.projectiles = projectiles;
		this.timer = 0;
		this.reloadTime = reloadTime;
		this.cost = cost;
		this.damage = damage;
		this.priority = Priorities.WEAKEST;
	}
	
	
	public void tryShoot(List<Wave> waves) {
		if(timer<=0){
			if(priority == Priorities.FIRTS){
				outerloop:
				for(Wave w : waves){
					for(AbstractMonster m: w.getmonstersOnGameBoard()){
						if(monsterInRange(m)){
							Projectile p = new Projectile(xPos, yPos, m, damage);
							projectiles.add(p);
							timer = reloadTime;
							break outerloop;
						}
					}
				}			
			}else if(priority == Priorities.WEAKEST){
				AbstractMonster targetMonster = null;
				for(Wave w : waves){
					for(AbstractMonster m: w.getmonstersOnGameBoard()){
						if(monsterInRange(m)){
							if(targetMonster == null){
								targetMonster = m;
							}else if(m.getLife() < targetMonster.getLife()){
								targetMonster = m;
							}
						}
					}
				}	
				if(targetMonster != null){
					Projectile p = new Projectile(xPos, yPos, targetMonster, damage);
					projectiles.add(p);
					timer = reloadTime;
				}
			}
		
		}		
		timer--;
		
	}
	
	public int getCost() {
		return cost;
	}
	
	public float getX() {
		return xPos;
	}
	
	public float getY() {
		return yPos;
	}
	
	public int getRange() {
		return range;
	}
	
	public int getReloadTime() {
		return reloadTime;
	}
	
	public ArrayList<AbstractProjectile> getProjectiles() {
		return projectiles;
	}
	
	public int getDamage() {
		return damage;
	}
	
	public void addRange(int range) {
		this.range += range;
	}
	
	public void addDamage(int damage) {
		this.damage += damage;
	}
	
	public void decreaseReloadTime(int reloadTime) {
		this.reloadTime -= reloadTime;
	}
	
	public boolean monsterInRange(AbstractMonster m) {
		return (m.getX()>=xPos-range && m.getX()<=xPos+range && m.getY()>=yPos-range && m.getY()<=yPos+range);
	}
	
	public int sellTower() {
		return (int) (this.getCost()*0.5);
	}
	
	public abstract AbstractTower upgradeTower();
	
	public abstract int getUpgradeCost();

}