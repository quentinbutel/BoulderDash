package entity.mobile;

import java.awt.Point;
import java.awt.Rectangle;
import java.io.IOException;

import entity.ControllerOrder;
import entity.IMap;

import entity.PERMEABILITY;
import entity.Sprite;

public class Charact extends MobileEntity{
	private static final Sprite sprite = new Sprite('C', Sprite.Chara, 0, 0);
	private static final Sprite spriteLeft = new Sprite('C', Sprite.Chara, 0, 16 );
	private static final Sprite spriteRight = new Sprite('C', Sprite.Chara, 0, 48);
	private static final Sprite spriteDown = new Sprite('C', Sprite.Chara, 0, 64);
	private static final Sprite spriteUp = new Sprite('C', Sprite.Chara, 0, 32);
	private static final Sprite spriteDeath = new Sprite('C', Sprite.Chara, 80, 80);
	public Charact(int x, int y, IMap map) throws IOException {
		super(x, y, sprite, map, PERMEABILITY.BLOCKING);
		spriteLeft.loadImage();
		spriteRight.loadImage();
		spriteDown.loadImage();
		spriteUp.loadImage();
		spriteDeath.loadImage();
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
	public void die() {
		// TODO Auto-generated method stub
		super.die();
		this.setSprite(spriteDeath);
	}
	public boolean isCrashed() {
		// TODO Auto-generated method stub
		return super.isCrashed();
	}
	public boolean canMove(ControllerOrder choice) {
		Boolean push = false;
		switch (choice) {
		case Right:
			push = this.getMap().getOnTheMapXY(getX() + 2, getY())
					.getPermeability() == PERMEABILITY.PENETRABLE;
			if (push) {
				for (IMobile mEntity : this.getMap().getmEntity()) {
					if (mEntity.getPosition().x == getX() + 2 && mEntity.getPosition().y == getY()
							&& mEntity.getPermeability() != PERMEABILITY.PENETRABLE) {
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
				for (IMobile mEntity : this.getMap().getmEntity()) {
					if (mEntity.getPosition().x == getX() - 2 && mEntity.getPosition().y == getY()
							&& mEntity.getPermeability() != PERMEABILITY.PENETRABLE) {
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
		final Point desiredPosition = this.getPositionAfterOrder(choice);
		for (IMobile mEntity : this.getMap().getmEntity()) {
			if (mEntity.getPosition().equals(desiredPosition)) {
				if (mEntity.getPermeability() == PERMEABILITY.BLOCKING) {
					if (push) {
						if (choice == ControllerOrder.Right)
							mEntity.moveRight();
						else
							mEntity.moveLeft();
						return true;
					} else {

						return false;
					}

				} else if (mEntity.getPermeability() == PERMEABILITY.MINEABLE) {
					// Player stepped on a diamond

					mEntity.removeEntity();;
					this.getMap().decreaseDiamond();

					return true;
				}
			}
		}
		return true;
	}
	public boolean mapAllowsMvt(ControllerOrder choice) {
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
	public boolean entityAllowsmvt(ControllerOrder choice) {
		// TODO Auto-generated method stub
		return super.entityAllowsmvt(choice);
	}
	@Override
	public void removeEntity() {
		// TODO Auto-generated method stub
		
	}
	
	
}
