package entity.mobile;
import java.awt.Rectangle;
import java.io.IOException;

import entity.IMap;
import entity.Map;

import entity.PERMEABILITY;
import entity.Sprite;
import entity.strategy.DiamondStrategy;
import entity.strategy.IStrategy;

public class Diamond extends MobileEntity{
	private static IStrategy strategy = new DiamondStrategy();
	
	public Diamond(int x, int y, IMap map) throws IOException {
		super(x, y, sprite, map, PERMEABILITY.MINEABLE);
		sprite.loadImage();
		// TODO Auto-generated constructor stub
	}

	private static final Sprite sprite = new Sprite('A', Sprite.world, new Rectangle(64, 0, 16, 16));

	@Override
	public void moveDown() {
		// TODO Auto-generated method stub
		super.moveDown();
	}

	@Override
	public void moveRight() {
		// TODO Auto-generated method stub
		super.moveRight();
	}

	@Override
	public void moveLeft() {
		// TODO Auto-generated method stub
		super.moveLeft();
	}

	@Override
	public void immobile() {
		// TODO Auto-generated method stub
		super.immobile();
	}
	
	public void strategy() {
		Diamond.strategy.strategy(this, this.getMap());
	}
	
}
