package entity.mobile;



import java.awt.Point;
import java.io.IOException;

import entity.ControllerOrder;

import entity.Entity;
import entity.IMap;

import entity.PERMEABILITY;
import entity.Sprite;
import entity.motionless.MotionLessEntityFactory;
import entity.strategy.FallingStrategy;
import entity.strategy.IStrategy;




public abstract  class MobileEntity extends Entity implements IMobile{
	  private boolean alive =true;
	  private Point position;
	  private IMap map;
	  private boolean fall = false;
	 
	  
	  public void setFall(boolean fall) {
		this.fall = fall;
	}

	public MobileEntity(Sprite sprite, IMap map, PERMEABILITY permeability) {
		  super(sprite, permeability);
		  this.map = map;
		  this.position = new Point();
	  }
	  
	  public MobileEntity(int x, int y, Sprite sprite, IMap map, PERMEABILITY permeability) {
		  this(sprite, map, permeability);
		  this.getPosition().x=x;
		  this.getPosition().y = y;
	  }
	
	public int getX() {
		// TODO Auto-generated method stub
		return this.getPosition().x;
	}
	
	public void setX(int x) {
		this.getPosition().x = x;
		

	}
	
	public int getY() {
		// TODO Auto-generated method stub
		return this.getPosition().y;
	}
	
	public void setY(int y) {
		this.getPosition().y = y;
		

	}
	// we indicate a change with each movement
	public void moveUp() {
		this.setY(this.getY()-1);
		this.setHasMoved();
	}
	
	public void moveDown() {
		this.setY(this.getY()+1);
		this.fall=true;
		this.setHasMoved();
		
	}
	
	public void moveRight() {
		this.setX(this.getX()+1);
		this.setHasMoved();
	}
	
	public void moveLeft() {
		this.setX(this.getX()-1);
		this.setHasMoved();
		
	}
	
	public void immobile() {
		this.fall = false;
		this.setHasMoved();		
	}
	
	
	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	public boolean isAlive() {
		// TODO Auto-generated method stub
		return this.alive;
	}
	
	
	
	public void setHasMoved() {
		this.getMap().setMobHasChanged();
	}
	  
	public void die() {
		this.alive=false;
		this.setHasMoved();
	}

	public IMap getMap() {
		return map;
	}

	public void setMap(IMap map) {
		this.map = map;
	}
	
	

	public boolean canMove(ControllerOrder choice) {
		return this.mapAllowsMvt(choice) && this.entityAllowsmvt(choice);
		
	}
	public boolean mapAllowsMvt(ControllerOrder choice) {
		switch (choice) {
		case Up : 
			return this.getMap().getOnTheMapXY(this.getX(), this.getY() - 1).getPermeability() == PERMEABILITY.PENETRABLE;
			
		case Down : 
			return this.getMap().getOnTheMapXY(this.getX(), this.getY() + 1).getPermeability() == PERMEABILITY.PENETRABLE;
			
		case Right : 
			return this.getMap().getOnTheMapXY(this.getX()+1, this.getY()).getPermeability() == PERMEABILITY.PENETRABLE;
			
		case Left : 
			return this.getMap().getOnTheMapXY(this.getX()-1, this.getY()).getPermeability() == PERMEABILITY.PENETRABLE;
		case None:
			default:
				return true;
		}
	}
	
	public boolean entityAllowsmvt(ControllerOrder choice) {
		Point posAfter = this.getPositionAfterOrder(choice);
		for (IMobile mEntity: this.getMap().getmEntity()) {
			if (mEntity.getPosition().equals(posAfter)) {
				if (mEntity.getPermeability() != PERMEABILITY.PENETRABLE) {
					return false;
				}else {
					return true;
				}
			}
		}
		return true;
	}
	
	public Point getPositionAfterOrder(ControllerOrder choice) {
		Point posAfter = null;
			switch (choice) {
			case Up : 
				posAfter = new Point(this.getX(), this.getY()-1);
				break;
			case Down : 
				posAfter = new Point(this.getX(), this.getY()+1);
				break;
			case Right : 
				posAfter = new Point(this.getX()+1, this.getY());
				break;
			case Left : 
				posAfter = new Point(this.getX()-1, this.getY());
				break;
			}
			return posAfter;
	}
	public boolean isFalling() {
		return fall;
	}

	
	// Create a dugWall when our character moves
	public void digg() {		
		this.getMap().setOnTheMapXY(MotionLessEntityFactory.createDugWall(), this.getX(), this.getY());
		try {
			
			this.getMap().getOnTheMapXY(getX(), getY()).getSprite().loadImage();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void strategy() {
		
	}
}
