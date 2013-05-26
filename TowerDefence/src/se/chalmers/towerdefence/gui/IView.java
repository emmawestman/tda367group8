package se.chalmers.towerdefence.gui;

import se.chalmers.towerdefence.model.interfaces.GameBoardObject;

/**
 * An Interface for all GameBoardObjects 
 * @author Jonathan, Oskar, Emma, Julia
 *
 */

public interface IView {
	
	
	public void draw();

	public boolean exists();
	
	public void setResolution(int width, int height);
	
	public GameBoardObject getObject();
	
}
