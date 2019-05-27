package entity;

public class Map {
	private String map;
	private final  int width = 1536;
	private final  int height = 768;
	private int level;
	private int diamondCount;
	
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getDiamondCount() {
		return diamondCount;
	}
	public void setDiamondCount(int diamondCount) {
		this.diamondCount = diamondCount;
	}
	public String getMap() {
		return map;
	}
	public  int getWidth() {
		return width;
	}
	public  int getHeight() {
		return height;
	}
	
	public Map(int level, String map) {
		
	}
	
	public Map() {
		this(0, "");
	}
	
	public Entity getOnTheMapXY(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void setOnTheMapXY(Entity entity, int x, int y) {
		
	}
}
