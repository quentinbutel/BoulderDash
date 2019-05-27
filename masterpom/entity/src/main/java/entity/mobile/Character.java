package entity.mobile;

import java.io.IOException;
import java.util.Map;

import entity.PERMEABILITY;
import entity.Sprite;

class Character extends MobileEntity{
	

	private static final Sprite sprite = new Sprite('C', "characterStandstill.png");
	private static final Sprite spriteLeft = new Sprite('C', "characterRunningLeft.png");
	private static final Sprite spriteRight = new Sprite('C', "characterRunningRight.png");
	private static final Sprite spriteDown = new Sprite('C', "characterRunningDown.png");
	private static final Sprite spriteUp = new Sprite('C', "characterRunningUp.png");
	
	public Character(int x, int y, Map map) throws IOException {
		super(x, y, sprite, map, PERMEABILITY.BLOCKING);
		spriteLeft.loadImage();
		spriteRight.loadImage();
		spriteDown.loadImage();
		spriteUp.loadImage();
		// TODO Auto-generated constructor stub
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

	@Override
	protected void die() {
		// TODO Auto-generated method stub
		super.die();
	}

	
}
