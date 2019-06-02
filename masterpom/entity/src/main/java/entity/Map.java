package entity;

import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;


import entity.mobile.IMobile;

public class Map extends Observable implements IMap{

	private final  static int width = 32;
	
	private final  static int height = 16;
	private int diamondCount = 0;
	private IEntity[][] map;	
	private ArrayList<IMobile> mEntity;
	private IMobile character;
	
	public static int getWidth() {
		return width;
	}
	public static int getHeight() {
		return height;
	}

	public IMobile getCharacter() {
		return character;
	}
	public void setCharacter(IMobile character) {
		this.character = character;
	}
	
	public int getDiamondCount() {
		return diamondCount;
	}
	public void setDiamondCount(int diamondCount) {
		this.diamondCount = diamondCount;
	}
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
	
	
	public IEntity getOnTheMapXY(int x, int y) {
		// we check if we are not at the edge of the map
		 if(x >= 0 && x < Map.getWidth() && y >= 0 && y < Map.getHeight())
		    	return this.map[x][y];
		    else
		    	return this.map[0][0];
		  
	}
	
	public void setOnTheMapXY(IEntity entity, int x, int y) {
		this.map[x][y] = entity;
	}
	
	
	public void setMobHasChanged() {
		// It's our methode that will tell the view(the observer) if there is change
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
