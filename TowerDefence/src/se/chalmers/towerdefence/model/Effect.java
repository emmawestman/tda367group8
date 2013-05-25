package se.chalmers.towerdefence.model;

/**
 * A class that represents an effect the projectiles can have on monsters.
 * @author Julia, Jonathan, Emma, Oskar
 *
 */
public class Effect implements IEffect{
	
	private int timer;
	private int maxTime;
	private int damage;
	private float slowing;
	private boolean isActive;
	private int effectLevel;
	private int effectType;
	
	
	//The reason why the class looks the way it does is becouse the group decided to only have one effect class
	//Which makes the interface unnecessary in this case. 
	public Effect(int level, int type){
		isActive = true;
		effectLevel = level;
		effectType = type;
		slowing = 1f;
		damage = 0; 
		timer = 0;
		maxTime = timer;
		switch(effectType){
			//freezing
			case 1: 
				switch(effectLevel){
					
					case 0:
						timer = 90;
						maxTime = timer;
						slowing = 0.90f;
						break;
					
					case 1:
						timer = 100;
						maxTime = timer;
						slowing = 0.80f;
						break;
					
					case 2:
						timer = 120;
						maxTime = timer;
						slowing = 0.65f;
						break;
					
					case 3:
						timer = 140;
						maxTime = timer;
						slowing = 0.55f;
						break;
						
					case 4:
						timer = 160;
						maxTime = timer;
						slowing = 0.45f;
						break;
					
				}
				break;
				
			//Burning
			case 2: 
				switch(effectLevel){
						
					case 0:
						timer = 100;
						maxTime = timer;
						damage = 2;
						break;
				
					case 1:
						timer = 100;
						maxTime = timer;
						damage = 2;
						break;
					
					case 2:
						timer = 120;
						maxTime = timer;
						damage = 4;
						break;
					
					case 3:
						timer = 140;
						maxTime = timer;
						damage = 6;
						break;
					
					case 4:
						timer = 160;
						maxTime = timer;
						damage = 8;
						break;
						
				}
				break;
				
			//Poisoned
			case 3: 
				switch(effectLevel){
					
				
					case 0:
						damage = 1;
						timer = 100;
						maxTime = timer;
						slowing = 0.80f;
						break;
					
					case 1:
						damage = 1;
						timer = 100;
						maxTime = timer;
						slowing = 0.80f;
						break;
					
					case 2:
						damage = 2;
						timer = 120;
						maxTime = timer;
						slowing = 0.68f;
						break;
					
					case 3:
						damage = 3;
						timer = 140;
						maxTime = timer;
						slowing = 0.52f;
						break;
					
					case 4:
						damage = 4;
						timer = 160;
						maxTime = timer;
						slowing = 0.38f;
						break;
			}
			break;
		}
	}
	public int getDamage() {
			timer--;
			if(timer <= 0){
				isActive = false;
			}
			return damage;	
	}

	@Override
	public void resetTimer() {
		timer = maxTime;
	}

	@Override
	public boolean isActive() {
		return isActive;
	}

	@Override
	public int getLevelOfEffect() {
		return effectLevel;
	}

	@Override
	public float getSlowingeEffect() {
		return slowing;
	}

	@Override
	public int getEffectType() {
		return effectType;
	}
	
	public void endEffect(){
		isActive = false;
	}
	
	public void upgrade(int newLevel){
		effectLevel = newLevel;
	}
	
	public IEffect copy(){
		return new Effect(effectLevel, effectType);
	}

}
