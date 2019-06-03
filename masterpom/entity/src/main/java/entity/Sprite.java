package entity;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
/**
 * the class Sprite
 * @author Quentin, Edouard, Mohamad
 *
 */
public class Sprite {
	/**The image*/
	private Image image;
	/**The imageName*/
	private String imageName;
	/**The charImage*/
	private char charImage;
	/**The is Image loaded*/
	private boolean imageLoaded;
	/**The buffer*/
	private BufferedImage buffer;
	/**The buffer for the player image*/
	public static BufferedImage Chara;
	/**The buffer for the map image*/
	public static BufferedImage world;
	/**a part of buffer*/
	private Rectangle part;
	
	
	/**
	 * Instantiates a new sprite
	 * @param character
	 * symbol
	 * @param buf
	 * buffer
	 * @param part
	 * part of the buffer
	 */
public Sprite(char character, final BufferedImage buf, final Rectangle part) {
		this.setCharImage(character);
		this.buffer = buf;
		this.part=part;
	

	}


/**
 * load the two spriteSheet
 */
public static void loadSpriteSheet() {
	try {
		int randomNum = (int) (Math.random() * 6);
		Sprite.Chara= ImageIO.read(new File("C:\\Users\\qbute\\Documents\\Projet\\Projet 5\\image\\74336.png"));
		Sprite.world= ImageIO.read(new File("C:\\Users\\qbute\\Documents\\Projet\\Projet 5\\image\\74359.png"));
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

	/**
	 * gets image
	 * @return image
	 * an image
	 */
	public Image getImage() {
		return image;
	}

	/**
	 * sets image
	 * @param image
	 * a new image
	 */
	public void setImage(Image image) {
		this.image = image;
	}
/**
 * gets ImageName
 * @return imageName
 * url of the image
 */
	public String getImageName() {
		return imageName;
	}
	/**
	 * sets Imagename
	 * @param imageName
	 * imageName
	 */
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	/**
	 * gets CharImage
	 * @return charImage
	 * symbol
	 */
	public char getCharImage() {
		return charImage;
	}
	/**
	 * sets CharImage
	 * @param charImage
	 * a new symbol
	 */
	public void setCharImage(char charImage) {
		this.charImage = charImage;
	}

	
	
	/**
	 * each element calls this method to load its image
	 * @throws IOException
	 * Signal an IO exception
	 */
	public void loadImage() throws IOException {
		this.setImage(buffer.getSubimage(part.x, part.y, part.width, part.height));
		
	}
	/**
	 * 
	 * @return imageLoaded
	 * true or false
	 */
	public boolean isImageLoaded() {
		return imageLoaded;
		
	}
	/**
	 * sets ImageLoaded
	 * @param isImageLoaded
	 * true or false
	 */
	public void setImageLoaded(boolean isImageLoaded) {
		this.imageLoaded = isImageLoaded;
	}
	
	
}