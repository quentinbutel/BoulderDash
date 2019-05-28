package entity.mobile;

import java.awt.Point;
import java.io.IOException;

import entity.ControllerOrder;
import entity.IMap;

import entity.PERMEABILITY;
import entity.Sprite;

public class Charact extends MobileEntity{
	

	private static final Sprite sprite = new Sprite('C', "characterStandstill.png");
	private static final Sprite spriteLeft = new Sprite('C', "characterRunningLeft.png");
	private static final Sprite spriteRight = new Sprite('C', "characterRunningRight.png");
	private static final Sprite spriteDown = new Sprite('C', "characterRunningDown.png");
	private static final Sprite spriteUp = new Sprite('C', "characterRunningUp.png");
	private static final Sprite spriteDeath = new Sprite('C', "characterDeath.png");
	public Charact(int x, int y, IMap map) throws IOException {
		super(x, y, sprite, map, PERMEABILITY.BLOCKING);
		spriteLeft.loadImage();
		spriteRight.loadImage();
		spriteDown.loadImage();
		spriteUp.loadImage();
		spriteDeath.loadImage();
		// TODO Auto-generated constructor stub
	}
	
	public void moveUp() {
		super.digg();
		super.moveUp();
		this.setSprite(spriteUp);
		
	}
	
	public void moveDown() {
		super.digg();
		super.moveDown();
		this.setSprite(spriteDown);
	}
	
	public void moveRight() {
		super.digg();
		super.moveRight();
		this.setSprite(spriteRight);
	}
	
	public void moveLeft() {
		super.digg();
		super.moveLeft();
		this.setSprite(spriteLeft);
	}
	
	public void immobile() {
		super.immobile();
		this.setSprite(sprite);
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		super.die();
		this.setSprite(spriteDeath);
	}

	@Override
	public boolean isCrashed() {
		// TODO Auto-generated method stub
		return super.isCrashed();
	}

	@Override
	public boolean canMove(ControllerOrder choice) {
		Boolean push = false;
		switch (choice) {
		case Right:
			push = this.getMap().getOnTheMapXY(getX() + 2, getY())
					.getPermeability() == PERMEABILITY.PENETRABLE;
			if (push) {
				for (MobileEntity pawn : this.getMap().getmEntity()) {
					if (pawn.getPosition().x == getX() + 2 && pawn.getPosition().y == getY()
							&& pawn.getPermeability() != PERMEABILITY.PENETRABLE) {
						push = false;
						break;
					}
				}
			}
			break;
		case Left:
			push = this.getMap().getOnTheMapXY(getX() - 2, getY())
					.getPermeability() == PERMEABILITY.PENETRABLE;
			if (push) {
				for (MobileEntity pawn : this.getMap().getmEntity()) {
					if (pawn.getPosition().x == getX() - 2 && pawn.getPosition().y == getY()
							&& pawn.getPermeability() != PERMEABILITY.PENETRABLE) {
						push = false;
						break;
					}
				}
			}
			break;
		case None:
		default:
			break;
		}
		
		//TODO factor
		final Point desiredPosition = this.getPositionAfterOrder(choice);
		for (MobileEntity pawn : this.getMap().getmEntity()) {
			if (pawn.getPosition().equals(desiredPosition)) {
				if (pawn.getPermeability() == PERMEABILITY.BLOCKING) {
					if (push) {
						if (choice == ControllerOrder.Right)
							pawn.moveRight();
						else
							pawn.moveLeft();
						return true;
					} else {

						return false;
					}

				} else if (pawn.getPermeability() == PERMEABILITY.MINEABLE) {
					// Player stepped on a diamond

					pawn.removemEntity();;
					this.getMap().decreaseDiamond();

					return true;
				}
			}
		}
		return true;
	}

	@Override
	protected boolean mapAllowsMvt(ControllerOrder choice) {
		switch (choice) {
		case Up : 
			return this.getMap().getOnTheMapXY(this.getX(), this.getY() - 1).getPermeability() != PERMEABILITY.BLOCKING;
			
		case Down : 
			return this.getMap().getOnTheMapXY(this.getX(), this.getY() + 1).getPermeability() != PERMEABILITY.BLOCKING;
			
		case Right : 
			return this.getMap().getOnTheMapXY(this.getX()+1, this.getY()).getPermeability() != PERMEABILITY.BLOCKING;
			
		case Left : 
			return this.getMap().getOnTheMapXY(this.getX()-1, this.getY()).getPermeability() != PERMEABILITY.BLOCKING;
		case None:
			default:
				return true;
		}
	}

	@Override
	protected boolean entityAllowsmvt(ControllerOrder choice) {
		// TODO Auto-generated method stub
		return super.entityAllowsmvt(choice);
	}

	
}
