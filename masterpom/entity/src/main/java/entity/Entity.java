package entity;

import java.awt.Image;


public abstract class Entity implements IEntity{
	public Entity(Sprite sprite, PERMEABILITY permeability) {
		this.permeability = permeability;
		this.sprite = sprite;
	}

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
