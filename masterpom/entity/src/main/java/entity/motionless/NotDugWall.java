package entity.motionless;

import entity.PERMEABILITY;
import entity.Sprite;

class NotDugWall extends MotionLessEntity{
	
	private static final Sprite sprite = new Sprite('D', "ground1.png");

	protected NotDugWall() {
		super(sprite, PERMEABILITY.MINEABLE);
		// TODO Auto-generated constructor stub
	}

}
