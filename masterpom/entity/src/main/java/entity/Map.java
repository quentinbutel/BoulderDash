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
	private int level;
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
	
	
	public Map(IEntity[][] map, int level) {
	this.map = map;
	this.mEntity= new ArrayList<IMobile>();
	this.level=level;
	}
	
	
	public IEntity getOnTheMapXY(int x, int y) {
		// TODO Auto-generated method stub
		return this.map[x][y];
	}
	
	public void setOnTheMapXY(IEntity entity, int x, int y) {
		this.map[x][y] = entity;
	}
	
	
	public void setMobHasChanged() {
		this.setChanged();
		this.notifyObservers();
	
	}
	
	public void add(IMobile mEntity) {
		this.mEntity.add(mEntity);
	}
	public ArrayList<IMobile> getmEntity() {
		return mEntity;
	}
	
	public void addDiamond() {
		this.diamondCount++;
	}
	
	public void decreaseDiamond() {
		this.diamondCount--;
	}
	 public PERMEABILITY getSquareIsOccupiedXY(final int x, final int y) {
		    Point point = new Point(x, y);
		    for(IMobile mEntity : this.getmEntity()) {
		      if (mEntity.getPosition().equals(point))
		        return mEntity.getPermeability();
		    }
		    
		    if(this.getCharacter().getPosition().equals(point))
		    	return this.getCharacter().getPermeability();
		    
		    return this.getOnTheMapXY(x, y).getPermeability();
		  }
	 
	 public final String toString() {
		 
			 String temp = new String();
		    for (int y = 0; y < Map.getHeight(); y++) {
		      for (int x = 0; x < Map.getWidth(); x++) {
		    	  temp += map[x][y].getSprite().getCharImage();
		  //      System.out.print(this.getOnTheMapXY(x, y).getSprite().getCharImage());
		      }
		      temp += '\n';
		    
		    }
		  
		 
		 return temp;
	  }
	
	 
	
}
