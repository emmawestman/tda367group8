package se.chalmers.towerdefence.model.interfaces;

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
	
	public void endEffect();
	
	public void upgrade(int newLevel);
	
	public IEffect copy();
}
