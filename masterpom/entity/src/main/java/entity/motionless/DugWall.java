package entity.motionless;

import entity.PERMEABILITY;
import entity.Sprite;

class DugWall extends MotionLessEntity{
	
	private static final Sprite sprite = new Sprite('O', "ground0.png");

	protected DugWall() {
		super(sprite, PERMEABILITY.PENETRABLE);
		
	}

}
