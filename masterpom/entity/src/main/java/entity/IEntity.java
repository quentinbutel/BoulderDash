package entity;

import java.awt.Image;

import showboard.ISquare;



public interface IEntity extends ISquare{
	public Sprite getSprite();
	public PERMEABILITY getPermeability();
	public Image getImage();
}
