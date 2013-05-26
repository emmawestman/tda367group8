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
	private Sound gargamelSound;
	private boolean playSounds;
	
	private SoundFX() {
		try {
			duckSound = new Sound("res/duckSound.wav");
			antSound = new Sound("res/antSound.wav");
			scorpionSound = new Sound("res/skorpionSound.wav");
			gargamelSound = new Sound("res/GargamelDying.wav");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		playSounds = true;
	} 
	
	public static SoundFX getInstance() {
		if (instance == null) {
			instance = new SoundFX();
		}
		return instance;
	}
	public void playDuckSound() throws SlickException {
		if(playSounds){	
			duckSound.play(1.0f, getVolume());
		}
	}
	
	public void playAntSound() throws SlickException{
		if(playSounds){	
			antSound.play(1.0f, getVolume());
		}
	}
	
	public void playScorpionSound() throws SlickException{
		if(playSounds){	
			scorpionSound.play(1.0f, getVolume());
		}
	}
	
	public void playGargamelSound() throws SlickException{
		if(playSounds){	
			gargamelSound.play(1.0f, getVolume());
		}
	}
	
	public void setVolume(float volume) {
		this.volume = volume;
	}
	
	public float getVolume() {
		return volume;
	}
	
	public void toggleSounds(){
		playSounds = !playSounds;
	}
	
	public boolean isPlaying() {
		return playSounds;
	}
}
