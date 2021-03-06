package entity.mobile;

import java.awt.Point;
import java.awt.Rectangle;
import java.io.IOException;

import entity.ControllerOrder;
import entity.IMap;

import entity.PERMEABILITY;
import entity.Sprite;
import showboard.IBoard;
/**
 * the class Charact
 * @author All
 *
 */
public class Charact extends MobileEntity{
	
	private static final Sprite sprite = new Sprite('C', Sprite.Chara,new Rectangle (0, 0, 16, 16));
	private static final Sprite spriteLeft = new Sprite('C', Sprite.Chara, new Rectangle (0, 16, 16, 16));
	private static final Sprite spriteRight = new Sprite('C', Sprite.Chara,new Rectangle (0, 48, 16, 16));
	private static final Sprite spriteDown = new Sprite('C', Sprite.Chara, new Rectangle (0, 64, 16, 16));
	private static final Sprite spriteUp = new Sprite('C', Sprite.Chara, new Rectangle (0, 0, 16, 16));
	private static final Sprite spriteDeath = new Sprite('C', Sprite.Chara, new Rectangle (80, 80, 16, 16));
	
	/**
	 * @param x
	 * x
	 * @param y
	 * y
	 * @param map
	 * our map
	 * @throws IOException
	 * Signal an IOexception
	 */
	public Charact(int x, int y, IMap map) throws IOException {
		super(x, y, sprite, map, PERMEABILITY.BLOCKING);
		spriteLeft.loadImage();
		spriteRight.loadImage();
		spriteDown.loadImage();
		spriteUp.loadImage();
		spriteDeath.loadImage();
	}
	
	/**
	 * move character to the up
	 */
	public void moveUp() {
		super.moveUp();
		this.setSprite(spriteUp);	
		super.digg();
	}
	/**
	 * move character to the down
	 */
	public void moveDown() {
		
		super.moveDown();
		this.setSprite(spriteDown);
		super.digg();
	}
	/**
	 * move character to the right
	 */
	public void moveRight() {
		
		super.moveRight();
		this.setSprite(spriteRight);
		super.digg();
	}
	/**
	 * move character to the left
	 */
	public void moveLeft() {
		super.moveLeft();
		this.setSprite(spriteLeft);
		super.digg();
	}
	/**
	 * Don't move
	 */
	public void immobile() {
		super.immobile();
		this.setSprite(sprite);
	}
	/**
	 * character dies
	 */
	public void die() {
		// TODO Auto-generated method stub
		super.die();
		this.setSprite(spriteDeath);
	}
	/**
	 * entity allows movement 
	 * @param choice
	 * choice
	 *  @return choice
	 * true or false
	 */
	public boolean entityAllowsmvt(final ControllerOrder choice) {
		
		//Can our character push a boulder
		Boolean push = false;
		switch (choice) {
		case Right:
			push = this.getMap().getOnTheMapXY(getX() + 2, getY()).getPermeability() == PERMEABILITY.PENETRABLE;
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
			push = this.getMap().getOnTheMapXY(getX() - 2, getY()).getPermeability() == PERMEABILITY.PENETRABLE;
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
					//if he can, the boulder moves
					if (push) {
						if (choice == ControllerOrder.Right) {
							mEntity.moveRight();
						this.getMap().decreaseCompteur(50);
						}
						else {
							mEntity.moveLeft();
							this.getMap().decreaseCompteur(50);
						}
						return true;
					} else {

						return false;
					}

				} else if (mEntity.getPermeability() == PERMEABILITY.MINEABLE) {
					// Our character recovered a diamond
					mEntity.setPosition(new Point(-1, -1));
					this.getMap().getmEntity().remove(mEntity);
					
					this.getMap().decreaseDiamond();
					this.getMap().addCompteur(300);

					return true;
				}
			}
		}
		return true;
	}
	
	/**
	 * map allows movement 
	 * @param choice
	 * choice
	 *  @return choice
	 * true or false
	 */
	public boolean mapAllowsMvt(final ControllerOrder choice) {
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
	
	/**
	 * if player can move
	 * @param choice
	 * choice
	 *  @return choice
	 * true or false
	 */
	public boolean canMove(final ControllerOrder choice) {
		// TODO Auto-generated method stub
		return this.entityAllowsmvt(choice) && this.mapAllowsMvt(choice);
	}
	
	@Override
	public void strategy(int y, int x) {
		// TODO Auto-generated method stub
		
	}
	
	
}
