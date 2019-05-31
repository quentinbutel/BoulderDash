package entity.mobile;

import java.awt.Point;
import java.io.IOException;

import entity.ControllerOrder;
import entity.IEntity;
import test.IPawn;

public interface IMobile extends IEntity, IPawn{
	public int getX();
	public int getY();
	public void setX(int x);
	public void setY(int y);
	public void moveUp();
	public void moveDown();
	public void moveLeft();
	public void moveRight();
	public void immobile();
	public void die();
	public Point getPosition();
	public void setPosition(Point position);
	public boolean isAlive();
	public boolean isCrashed();
	public void setHasMoved();
	public boolean canMove(ControllerOrder choice);	
	public void removeEntity();
	public Point getPositionAfterOrder(ControllerOrder choice);
	public boolean isFalling();
	public void setFall(boolean fall);
	public void digg();
	public void strategy(int y, int x);
}
