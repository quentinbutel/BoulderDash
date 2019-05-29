package entity;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite {
	private Image image;
	private String imageName;
	private char charImage;
	private boolean imageLoaded;
	private BufferedImage buffer;
	public static BufferedImage Chara;
	public static BufferedImage world;
	
	private int partX;
	private int partY;
	
	
public Sprite(char character, final BufferedImage buf, final int partX, final int partY) {
		this.setCharImage(character);
		this.buffer = buf;
		this.setPartX(partX);
		this.setPartY(partX);

	}

public int getPartX() {
	return partX;
}

public void setPartX(int partX) {
	this.partX = partX;
}

public int getPartY() {
	return partY;
}

public void setPartY(int partY) {
	this.partY = partY;
}

public static void loadSpriteSheet() {
	try {
		Sprite.Chara= ImageIO.read(new File("C:\\Users\\qbute\\Documents\\Projet\\Projet 5\\image\\74336.png"));
		Sprite.world= ImageIO.read(new File("C:\\Users\\qbute\\Documents\\Projet\\Projet 5\\image\\74359.png"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

	
	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public char getCharImage() {
		return charImage;
	}

	public void setCharImage(char charImage) {
		this.charImage = charImage;
	}

	
	
	
	public void loadImage() throws IOException {
		this.setImage(buffer.getSubimage(partX, partY, 16, 16));
		this.getImage().getScaledInstance(48, 48, Image.SCALE_DEFAULT);
	}
	
	public boolean isImageLoaded() {
		return imageLoaded;
		
	}
	
	public void setImageLoaded(boolean isImageLoaded) {
		
	}
}