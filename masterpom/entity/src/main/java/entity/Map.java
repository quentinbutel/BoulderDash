package entity;

import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;

import entity.mobile.Charact;
import entity.mobile.IMobile;
import entity.mobile.MobileEntity;
public class Map extends Observable implements IMap{

	private final  static int width = 32;
	private final  static int height = 16;
	public static int getWidth() {
		return width;
	}
	public static int getHeight() {
		return height;
	}

	private int diamondCount = 0;
	private IEntity[][] map;	
	private ArrayList<IMobile> mEntity;
	private Charact character;
	private int level;
	
	
	public Charact getCharacter() {
		return character;
	}
	public void setCharacter(Charact character) {
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
		this.notifyObservers();
		this.hasChanged();
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
		 try {
		    for (int y = 0; y < Map.getHeight(); y++) {
		      for (int x = 0; x < Map.getWidth(); x++) {
		        System.out.print(this.getOnTheMapXY(x, y).getSprite().getCharImage());
		      }
		    
		    }
		  
		 }catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 return "fin";
	  }
	 
	
}
