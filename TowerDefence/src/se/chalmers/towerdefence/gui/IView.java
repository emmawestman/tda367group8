package se.chalmers.towerdefence.gui;

public interface IView {
	
	
	public void draw();

	public boolean exists();
	
	public void setResolution(int width, int height);
	
}
