package se.chalmers.towerdefence.model;

public interface IEffect {
	
	public int getDamage();
	
	public void resetTimer();

	public boolean isActive();
	
	public int getLevelOfEffect();
	
	public float getSlowingeEffect();
	
	public int getEffectType();
}
