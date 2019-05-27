package entity.motionless;

import entity.PERMEABILITY;
import entity.Sprite;

class Exit extends MotionLessEntity{
	
	private boolean isOpened = false;
	private static final Sprite sprite = new Sprite('S', "endPortal.png");

	public boolean isOpened() {
		return isOpened;
	}

	public void setOpened(boolean isOpened) {
		this.isOpened = isOpened;
	}

	protected Exit() {
		super(sprite, PERMEABILITY.PENETRABLE);
		// TODO Auto-generated constructor stub
	}

}
