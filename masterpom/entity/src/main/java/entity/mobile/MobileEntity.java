package entity.mobile;

import java.awt.Point;
import java.util.Map;

import entity.Entity;
import entity.PERMEABILITY;
import entity.Sprite;



 abstract  class MobileEntity extends Entity{
	  private boolean alive =true;
	  private Point position;
	  private Map map;
	  
	  public MobileEntity(Sprite sprite, Map map, PERMEABILITY permeability) {
		  
	  }
	  
	  public MobileEntity(int x, int y, Sprite sprite, Map map, PERMEABILITY permeability) {
		  
	  }
	
	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void setX(int x) {
		
	}
	
	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void setY(int y) {
		
	}
	
	public void moveUp() {
		// TODO Auto-generated method stub
		
	}
	
	public void moveDown() {
		// TODO Auto-generated method stub
		
	}
	
	public void moveRight() {
		// TODO Auto-generated method stub
		
	}
	
	public void moveLeft() {
		// TODO Auto-generated method stub
		
	}
	
	public void immobile() {
		// TODO Auto-generated method stub
		
	}
	
	public Point getPosition() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void setPosition(Point position) {
		
	}
	
	public boolean isAlive() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean isCrashed() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void setHasMoved() {
		
	}
	  
	protected void die() {
		
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}
	
}
