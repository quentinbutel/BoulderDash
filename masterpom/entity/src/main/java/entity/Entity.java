package entity;

import java.awt.Image;



/**
 * The Class Entity.
 *
 * @author Jean-Aymeric Diet
 */
public abstract class Entity {
	private PERMEABILITY permeability;
	private Sprite sprite;
	
	public PERMEABILITY getPermeability() {
		return permeability;
	}
	public void setPermeability(PERMEABILITY permeability) {
		this.permeability = permeability;
	}
	public Sprite getSprite() {
		return sprite;
	}
	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}
	
	public Image getImage() {
		return this.getSprite().getImage();
		
	}
}
