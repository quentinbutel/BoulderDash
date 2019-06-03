package entity.mobile;

import java.awt.Point;
import java.io.IOException;

import entity.ControllerOrder;
import entity.IEntity;
import showboard.IPawn;

/**
 * the interface IMobile
 * @author Quentin
 *
 */
public interface IMobile extends IEntity, IPawn{
	/**
	 * gets X
	 * return x
	 * x
	 */
	public int getX();
	/**
	 * gets Y
	 * return y
	 * y
	 */
	public int getY();
	/**
	 * sets X
	 * @param x
	 * x
	 */
	public void setX(int x);
	/**
	 * sets y
	 * @param y
	 * y
	 */
	public void setY(int y);
	/** move mEntity to the Up*/
	public void moveUp();
	/** move mEntity to the Down*/
	public void moveDown();
	/** move mEntity to the Left*/
	public void moveLeft();
	/** move mEntity to the Right*/
	public void moveRight();
	/** Don't move*/
	public void immobile();
	 /** mEntity dies*/
	public void die();
	/**
	 * gets position
	 * @return position
	 * position
	 */
	public Point getPosition();
	/**
	 * sets position
	 * @param position
	 * position
	 */
	public void setPosition(Point position);
	public boolean isAlive();
	/**
	 * sets if it moves
	 */
	public void setHasMoved();
	/**
	 * if mEntity can move
	 * @param choice
	 * choice
	 *  @return choice
	 * true or false
	 */
	public boolean canMove(ControllerOrder choice);	
	
	
	public boolean isFalling();
	public void setFall(boolean fall);
	/**
	 * Create a dugWall when our character moves
	 */
	public void digg();
	public void strategy(int y, int x);
}
