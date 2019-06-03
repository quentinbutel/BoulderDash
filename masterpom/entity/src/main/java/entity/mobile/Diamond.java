package entity.mobile;
import java.awt.Rectangle;
import java.io.IOException;

import entity.ControllerOrder;
import entity.IMap;
import entity.Map;

import entity.PERMEABILITY;
import entity.Sprite;
import entity.strategy.DiamondStrategy;
import entity.strategy.IStrategy;
/**
 * the class Diamond
 * @author Quentin
 *
 */
public class Diamond extends MobileEntity{
	private static IStrategy strategy = new DiamondStrategy();
	
	/**
	 * 
	 * @param x
	 * x coordinate of a diamond on the map
	 * @param y
	 * y coordinate of a diamond on the map
	 * @param map
	 * our map
	 * @throws IOException
	 * Signal an IOexception
	 */
	public Diamond(int x, int y, IMap map) throws IOException {
		super(x, y, sprite, map, PERMEABILITY.MINEABLE);
		sprite.loadImage();
		// TODO Auto-generated constructor stub
	}

	private static final Sprite sprite = new Sprite('D', Sprite.world, new Rectangle (64, 0, 16, 16));

	/**
	 * This manages the movement of the diamond on the map
	 * moveDown() moves the diamond downwards when the area underneath it is free
	 */
	
	@Override
	public void moveDown() {
		// TODO Auto-generated method stub
		super.moveDown();
	}
	
	/**
	 * moveRight() moves the diamond to the right if the area below it is full and that the areas to the right and bottom right are free
	 */

	@Override
	public void moveRight() {
		// TODO Auto-generated method stub
		super.moveRight();
	}
	
	/**
	 * moveLeft() moves the diamond to the left if the area below it is full and that the areas to the left and bottom left are free
	 */

	@Override
	public void moveLeft() {
		// TODO Auto-generated method stub
		super.moveLeft();
	}
	
	/**
	 * immobile() is for when the diamond is static on the map and cannot move in any direction
	 */

	@Override
	public void immobile() {
		// TODO Auto-generated method stub
		super.immobile();
	}
	
	/**
	 * diamondStrategy() lets the game know whether the player can take the diamond or not, and how it behaves according to the player
	 * @param y
	 * y coordinate of the diamond
	 * @param x
	 * x coordinate of the diamond
	 */
	public void strategy(int y, int x) {
		Diamond.strategy.strategy(this, this.getMap(), y, x);
	}

	

}
