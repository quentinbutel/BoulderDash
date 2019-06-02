package entity;

import java.awt.Image;


public abstract class Entity implements IEntity{
	
	/**
	 * Instantiate a new entity
	 * @param sprite
	 * the sprite
	 * @param permeability
	 * the permeability
	 */
	public Entity(Sprite sprite, PERMEABILITY permeability) {
		this.permeability = permeability;
		this.sprite = sprite;
	}

	private PERMEABILITY permeability;
	private Sprite sprite;
	
	/**
	 * gets permeability
	 * @see PERMEABILITY
	 */
	public PERMEABILITY getPermeability() {
		return permeability;
	}
	
	/**
	 * sets a permeability
	 * @param permeability
	 * a new permeability
	 */
	public void setPermeability(PERMEABILITY permeability) {
		this.permeability = permeability;
	}
	
	/**
	 * gets sprite
	 * @see Sprite
	 */
	public Sprite getSprite() {
		return sprite;
	}
	
	/**
	 * sets a sprite
	 * @param sprite
	 * a new sprite
	 */
	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}
	
	/**
	 * gets the image.
	 * @see java.awt.Image
	 */
	public Image getImage() {
		return this.getSprite().getImage();
		
	}
}
