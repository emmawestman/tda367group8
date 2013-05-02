package se.chalmers.towerdefence.files;

public class ServiceFactory {
	public ServiceFactory() {
		
	}
	
	public FileHandler getFileHandler() {
		return new FileHandler();
		
	}

}
