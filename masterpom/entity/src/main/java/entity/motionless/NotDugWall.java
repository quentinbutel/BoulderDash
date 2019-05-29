package entity.motionless;



import entity.PERMEABILITY;
import entity.Sprite;

class NotDugWall extends MotionLessEntity{
	
	private static final Sprite sprite = new Sprite('W',  Sprite.world, 16, 0);

	protected NotDugWall() {
		super(sprite, PERMEABILITY.PENETRABLE);
		// TODO Auto-generated constructor stub
	}

}
