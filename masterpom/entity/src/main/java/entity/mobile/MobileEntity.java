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



/**
 * The class  MobileEntity
 * @author Quentin
 *
 */
public abstract  class MobileEntity extends Entity implements IMobile{
	/** alive*/
	  private boolean alive =true;
	  /**position*/
	  private Point position;
	  /**map*/
	  private IMap map;
	  /**fall*/
	  private boolean fall = false;
	 
	  /**
	   * sets fall
	   * @param fall
	   * fall
	   */
	  public void setFall(boolean fall) {
		this.fall = fall;
	}

	  /**
		 * Instantiates a mobile entity
		 *
		 * @param sprite
		 * Instantiates the sprite
		 * @param map
		 * Instantiates the map
		 * @param permeability
		 * Instantiates the permeability of the entity
		 */
	public MobileEntity(Sprite sprite, IMap map, PERMEABILITY permeability) {
		  super(sprite, permeability);
		  this.map = map;
		  this.position = new Point();
	  }
	
	/**
	 * Instantiates a  mobile.
	 *
	 * @param x
	 * Instantiates the x coordinate of the mobile
	 * @param y
	 * Instantiates the y coordinate of the mobile
	 * @param sprite
	 * Instantiates the sprite
	 * @param map
	 * Instantiates the map
	 * @param permeability
	 * Instantiates the permeability of the mobile
	 */
	  public MobileEntity(int x, int y, Sprite sprite, IMap map, PERMEABILITY permeability) {
		  this(sprite, map, permeability);
		  this.getPosition().x=x;
		  this.getPosition().y = y;
	  }
	/**
	 * gets X
	 * return x
	 * x
	 */
	public int getX() {
		// TODO Auto-generated method stub
		return this.getPosition().x;
	}
	/**
	 * sets X
	 * @param x
	 * x
	 */
	public void setX(int x) {
		this.getPosition().x = x;
		

	}
	/**
	 * gets Y
	 * return y
	 * y
	 */
	public int getY() {
		// TODO Auto-generated method stub
		return this.getPosition().y;
	}
	/**
	 * sets y
	 * @param y
	 * y
	 */
	public void setY(int y) {
		this.getPosition().y = y;
		

	}
	
	/**
	 * indicates that the entity has moved each time it moves
	 */
	
	// we indicate a change with each movement
	/** move mEntity to the Up*/
	public void moveUp() {
		this.setY(this.getY()-1);
		this.setHasMoved();
	}
	/** move mEntity to the Down*/
	public void moveDown() {
		this.setY(this.getY()+1);
		this.fall=true;
		this.setHasMoved();
		
	}
	/** move mEntity to the Right*/
	public void moveRight() {
		this.setX(this.getX()+1);
		this.setHasMoved();
	}
	/** move mEntity to the left*/
	public void moveLeft() {
		this.setX(this.getX()-1);
		this.setHasMoved();
		
	}
	/**Don't move*/
	public void immobile() {
		this.fall = false;
		this.setHasMoved();		
	}
	
	/**
	 * gets position
	 * @return position
	 * position
	 */
	public Point getPosition() {
		return position;
	}
	/**
	 * sets position
	 * @param position
	 * position
	 */
	public void setPosition(Point position) {
		this.position = position;
	}

	public boolean isAlive() {
		// TODO Auto-generated method stub
		return this.alive;
	}
	
	
	/**
	 * sets if it moves
	 */
	public void setHasMoved() {
		this.getMap().setMobHasChanged();
	}
	  /** mEntity dies*/
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
	
	
	/**
	 * if mEntity can move
	 * @param choice
	 * choice
	 *  @return choice
	 * true or false
	 */
	public boolean canMove(ControllerOrder choice) {
		return this.mapAllowsMvt(choice) && this.entityAllowsmvt(choice);
		
	}
	/**
	 * map allows movement 
	 * @param choice
	 * choice
	 * @return choice
	 * true or false
	 */
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
	/**
	 * entity allows movement 
	 * @param choice
	 * choice
	 *  @return choice
	 * true or false
	 */
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
	
	/**
	 * gets position after we choose a direction
	 * @param choice
	 * choice
	 * @return Point
	 */
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

	
	/**
	 * Create a dugWall when our character moves
	 */
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
