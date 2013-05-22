package se.chalmers.towerdefence.model;

/**
 * An interface for effects
 * @author Julia, Jonathan, Emma, Oskar
 *
 */

public interface IEffect {
	
	public int getDamage();
	
	public void resetTimer();

	public boolean isActive();
	
	public int getLevelOfEffect();
	
	public float getSlowingeEffect();
	
	public int getEffectType();
}
