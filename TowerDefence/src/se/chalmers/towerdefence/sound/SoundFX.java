package se.chalmers.towerdefence.sound;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import se.chalmers.towerdefence.model.Tower;

/** 
 * A singleton class to handle the sound effects.
 * @author Jonathan, Oskar, Julia, Emma
 *
 */
public class SoundFX {

	private float volume;
	private static SoundFX instance = null;
	private Sound bounceSound;
	private Sound laserSound;
	private Sound bombSound;
	
	private SoundFX() {
		try {
			bounceSound = new Sound("res/BounceSound.wav");
			laserSound = new Sound("res/LaserSound.wav");
			bombSound = new Sound("res/BombSound.wav");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	} 
	
	public static SoundFX getInstance() {
		if (instance == null) {
			instance = new SoundFX();
		}
		return instance;
	}
	public void playBounceSound(Tower tower) throws SlickException {
			bounceSound.play(1.0f, getVolume());
	}
	
	public void playBounceSound() {
			laserSound.play(1.0f, getVolume());
	}
	
	public void playBombSound() {
			bombSound.play(1.0f, getVolume());
	}
	
	public void setVolume(float volume) {
		this.volume = volume;
	}
	
	public float getVolume() {
		return volume;
	}
	

}
