package se.chalmers.towerdefence.gui;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import se.chalmers.towerdefence.model.AbstractTower;
import se.chalmers.towerdefence.model.LaserTower;
import se.chalmers.towerdefence.model.Tower;

public class SoundFX {
	private static SoundFX soundFX;
	private float volume;
	
	private SoundFX() {
		
	}

	
	public void playTowerHitSound(AbstractTower tower) throws SlickException {
		if (tower instanceof Tower) {
			Sound fx = new Sound("res/BounceSound.wav");
			fx.play(1.0f, getVolume());
		}else if (tower instanceof LaserTower) {
			Sound fx = new Sound("res/LaserSound.wav");
			fx.play(1.0f, getVolume());
		}else {
			Sound fx = new Sound("res/BombSound.wav");
			fx.play(1.0f, getVolume());
		}
		
	}
	
	public void setVolume(float volume) {
		this.volume = volume;
	}
	
	public float getVolume() {
		return volume;
	}
	

}
