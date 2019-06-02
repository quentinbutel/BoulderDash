package entity;

import java.awt.Image;

import showboard.ISquare;



public interface IEntity extends ISquare{
	
	/**
     * Gets the sprite.
     * @return the sprite
     */
	public Sprite getSprite();
	
	/**
     * Gets the permeability.
     * @return the permeability
     */
	public PERMEABILITY getPermeability();
	public Image getImage();
}
