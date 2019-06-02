package entity;

import java.util.ArrayList;
import java.util.Observable;

import entity.mobile.Charact;
import entity.mobile.IMobile;
import entity.mobile.MobileEntity;

public interface IMap {
	/**
	 * 
	 * @param x
	 * x
	 * @param y
	 * y
	 * @return element at x and y
	 */
	public IEntity getOnTheMapXY(int x, int y);
	
	/** @return diamondCount */
	public int getDiamondCount();
	
	
	public void add(IMobile mEntity);
	/** @return the character */
	public IMobile getCharacter();
	
	/**
	 * @return mobileEntity on the map
	 */
	public ArrayList<IMobile> getmEntity();
	/**
	 * @return the observable
	 */
	public Observable getObservable();
	
	/**
	 * add diamond to the diamondCount
	 */
	public void addDiamond();
	
	/**
	 * remove diamond to the diamondCount
	 */
	public void decreaseDiamond();
	
	/**
	 * Indicates that mobileEntity has changed
	 */
	public void setMobHasChanged();
	
	/**
	 * set a map location
	 * @param entity
	 * entity
	 * @param x
	 * x
	 * @param y
	 * y
	 */
	public void setOnTheMapXY(IEntity entity, int x, int y);
	
	/**
	 * Return the permeability of an element
	 * @param x
	 * x
	 * @param y
	 * y
	 * @return permeability
	 */
	public PERMEABILITY getMapElementXY(final int x, final int y);
	
	/**
	 * set the character
	 * @param character
	 * our character
	 */
	public void setCharacter(IMobile character);
	
	
}
