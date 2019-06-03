package entity;

import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;


import entity.mobile.IMobile;

public class Map extends Observable implements IMap{

		/** width */
	private final  static int width = 32;
	/** height*/
	private final  static int height = 16;
	/** Diamond Counter attribute*/
	private int diamondCount = 0;
	/** Board that contains motionless elements positions */
	private IEntity[][] map;	
	/** Array that contains motion elements */
	private ArrayList<IMobile> mEntity;
	/** character's creation */
	private IMobile character;
	
	/**
	 * gets map Width
	 * @return width
	 */
	public static int getWidth() {
		return width;
	}
	
	/**
	 * gets map Height
	 * @return Height
	 */
	public static int getHeight() {
		return height;
	}

	/**
	 * gets Character
	 * @return character
	 */
	public IMobile getCharacter() {
		return character;
	}
	
	/**
	 * sets character
	 */
	public void setCharacter(IMobile character) {
		this.character = character;
	}
	
	/**
	 * gets the amount of diamonds the player has gathered
	 */
	public int getDiamondCount() {
		return diamondCount;
	}
	
	/**
	 * change the amount of diamonds the player has gathered
	 * @param diamondCount
	 */
	public void setDiamondCount(int diamondCount) {
		this.diamondCount = diamondCount;
	}
	
	/**
	 * gets Observable
	 */
	public Observable getObservable() {
		return this;
	}
	/**
	 * Constructor
	 * @param map
	 * a new map
	 */
	
	public Map(IEntity[][] map) {
	this.map = map;
	this.mEntity= new ArrayList<IMobile>();
	
	}
	
	/**
	 * returns motionless elements coordonates off the board
	 */
	public IEntity getOnTheMapXY(int x, int y) {
		// we check if we are not at the edge of the map
		 if(x >= 0 && x < Map.getWidth() && y >= 0 && y < Map.getHeight())
		    	return this.map[x][y];
		    else
		    	return this.map[0][0];
		  
	}
	
	/**
	 * implements motionless elements in the board
	 */
	
	public void setOnTheMapXY(IEntity entity, int x, int y) {
		this.map[x][y] = entity;
	}
	
	/**
	 * trigger the view of the changes
	 */
	public void setMobHasChanged() {
		// method that informs the view(the observer) of the changes
		this.setChanged();
		this.notifyObservers();
	
	}
	
	public void add(IMobile mEntity) {
		this.mEntity.add(mEntity);
	}
	public ArrayList<IMobile> getmEntity() {
		return this.mEntity;
	}
	
	public void addDiamond() {
		this.diamondCount++;
	}
	
	public void decreaseDiamond() {
		this.diamondCount--;
	}
	
	//we need to know what permeability is on our side
	/**
	 * Return the permeability of an element
	 * @param x
	 * x
	 * @param y
	 * y
	 * @return permeability
	 */
	 public PERMEABILITY getMapElementXY(final int x, final int y) {
		    Point point = new Point(x, y);
		    for(IMobile mEntity : this.getmEntity()) {
		      if (mEntity.getPosition().equals(point))
		        return mEntity.getPermeability();
		    }
		    
		    if(this.getCharacter().getPosition().equals(point))
		    	return this.getCharacter().getPermeability();
		    
		    return this.getOnTheMapXY(x, y).getPermeability();
		  }
	 
	 
	 
	
}
