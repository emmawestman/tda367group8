package se.chalmers.towerdefence.sound;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;


/** 
 * A singleton class to handle the sound effects.
 * @author Jonathan, Oskar, Julia, Emma
 *
 */
public class SoundFX {

	private float volume = 1;
	private static SoundFX instance = null;
	private Sound duckSound;
	private Sound antSound;
	private Sound scorpionSound;
	
	private SoundFX() {
		try {
			duckSound = new Sound("res/BounceSound.wav");
			antSound = new Sound("res/LaserSound.wav");
			scorpionSound = new Sound("res/BombSound.wav");
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
	public void playDuckSound() throws SlickException {
			duckSound.play(1.0f, getVolume());
	}
	
	public void playAntSound() {
			antSound.play(1.0f, getVolume());
	}
	
	public void playScorpionSound() {
			scorpionSound.play(1.0f, getVolume());
	}
	
	public void playGargamelSound() {
		
	}
	
	public void setVolume(float volume) {
		this.volume = volume;
	}
	
	public float getVolume() {
		return volume;
	}
	

}
