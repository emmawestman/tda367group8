package se.chalmers.towerdefence.model;

public class Effect implements IEffect{
	
	private int timer;
	private final int maxTime;
	private int damage;
	private float slowing;
	private boolean isActive;
	private int effectLevel;
	private int effectType;
	
	public Effect(int level, int type){
		isActive = true;
		effectLevel = level;
		effectType = type;
		
		switch(effectType){
			//freezing
			case 1: 
				switch(effectLevel){
					
				case 1:
						timer = 60;
						maxTime = timer;
						slowing = 0.90f;
						break;
					
					case 2:
						timer = 80;
						maxTime = timer;
						slowing = 0.75f;
						break;
					
					case 3:
						timer = 100;
						maxTime = timer;
						slowing = 0.50f;
						break;
					
					default:
						slowing = 0.95f;
						timer = 20;
						maxTime = timer;
				}
				break;
				
			//Burning
			case 2: 
				switch(effectLevel){
					
					case 1:
						timer = 40;
						maxTime = timer;
						damage = 2;
						break;
					
					case 2:
						timer = 60;
						maxTime = timer;
						damage = 3;
						break;
					
					case 3:
						timer = 80;
						maxTime = timer;
						damage = 4;
						break;
					
					default:
						timer = 20;
						maxTime = timer;
			}
				break;
				
			//Poisoned
			case 3: 
				switch(effectLevel){
					
					case 1:
						damage = 1;
						timer = 60;
						maxTime = timer;
						slowing = 0.95f;
						break;
					
					case 2:
						damage = 2;
						timer = 17;
						maxTime = timer;
						slowing = 0.83f;
						break;
					
					case 3:
						damage = 3;
						timer = 80;
						maxTime = timer;
						slowing = 0.70f;
						break;
					
					default:
						timer = 100;
						maxTime = timer;
			}
			break;
			
			default:
				timer = 20;
				maxTime = timer;
			
		}
	}
	public int getDamage() {
		timer--;
		if(timer <= 0){
			isActive = false;
			return damage;
		}
		if(timer% 20 == 0){
			return damage;	
		}else{
			return 0;
		}
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

}
