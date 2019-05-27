package entity.motionless;

import entity.PERMEABILITY;
import entity.Sprite;

class UnbreakableWall extends MotionLessEntity{
	private static final Sprite sprite = new Sprite('X', "wall.png");


	protected UnbreakableWall() {
		super(sprite, PERMEABILITY.BLOCKING);
		// TODO Auto-generated constructor stub
	}

}
