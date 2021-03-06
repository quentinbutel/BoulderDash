package entity.mobile;

import java.awt.Point;
import java.awt.Rectangle;
import java.io.IOException;

import entity.ControllerOrder;
import entity.IMap;


import entity.PERMEABILITY;
import entity.Sprite;
import entity.strategy.BoulderStrategy;
import entity.strategy.IStrategy;

/**
 * the class Boulder
 * @author Quentin
 *
 */
public class Boulder extends MobileEntity{
	
	private static IStrategy strategy = new BoulderStrategy();
	private static  final Sprite sprite = new Sprite('B',  Sprite.world,new Rectangle (48, 0, 16, 16));
	
	
	
	/**
	 * 
	 * @param x
	 * x
	 * @param y
	 * y
	 * @param map
	 *  map
	 * @throws IOException
	 * Signal an IOexception
	 */
	public Boulder(int x, int y, IMap map) throws IOException {
		super(x, y, sprite, map, PERMEABILITY.BLOCKING);
		sprite.loadImage();
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * move Boulder to the down
	 */
	@Override
	public void moveDown() {
		// TODO Auto-generated method stub
		super.moveDown();
	}


	/**
	 * move Boulder to the right
	 */
	@Override
	public void moveRight() {
		// TODO Auto-generated method stub
		super.moveRight();
	}


	/**
	 * move Boulder to the left
	 */
	@Override
	public void moveLeft() {
		// TODO Auto-generated method stub
		super.moveLeft();
	}


	/**
	 * Don't move
	 */
	@Override
	public void immobile() {
		// TODO Auto-generated method stub
		super.immobile();
	}


	/**
	 * Check if the boulder can move to the direction according to the over mEntity
	 */
	@Override
	public boolean entityAllowsmvt(ControllerOrder choice) {
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
		case None : 
			default : 
				return true;
		
		}
		if (this.getMap().getCharacter().getPosition().equals(posAfter)) {
			return false;
		}
		else {
			return super.entityAllowsmvt(choice);
		}
	}
	
	
	/**
	 * boulderStrategy
	 * @param y
	 * y
	 * @param x
	 * x
	 */
	public  void strategy(int y, int x) {
		Boulder.strategy.strategy(this, this.getMap(), y, x);
		
	}



	
}
