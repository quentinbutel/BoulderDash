package entity;

import java.awt.Image;

import test.ISquare;



public interface IEntity extends ISquare{
	public Sprite getSprite();
	public PERMEABILITY getPermeability();
	public Image getImage();
}
