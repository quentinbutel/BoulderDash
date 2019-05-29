package entity.motionless;

import java.awt.Rectangle;

import entity.PERMEABILITY;
import entity.Sprite;

class UnbreakableWall extends MotionLessEntity{
	private static final Sprite sprite = new Sprite('X',  Sprite.world, 0, 0);


	protected UnbreakableWall() {
		super(sprite, PERMEABILITY.BLOCKING);
		// TODO Auto-generated constructor stub
	}

}
