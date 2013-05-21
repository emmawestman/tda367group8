package se.chalmers.towerdefence.sound;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;

/**
 * A class that handles the background music
 * @author Jonathan
 *
 */


public class BackgroundMusic {

	private Music music;
	private float pitch;
	private float volume;
	private static BackgroundMusic instance;
	
	private BackgroundMusic(){
		try {
			music = new Music("res/TheSmurfsThemeSong.wav");
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	public static BackgroundMusic getInstance() {
	      if(instance == null) {
	         instance = new BackgroundMusic();
	      }
	      return instance;
	 }
	
	public void loopMusic(){
		music.loop();
	}
	
	public void pauseMusic(){
		if(music.playing()){
			music.pause();
		}else{
			music.resume();
		}
		
	}
	public void playMusic(){
		music.play(pitch, volume);
	}
	public void stopMusic(){
		music.stop();
	}
	
	public void setVolume(float volume){
		music.setVolume(volume);
		this.volume=volume;
	}
}
