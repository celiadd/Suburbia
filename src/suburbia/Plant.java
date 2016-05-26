package suburbia;


import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;

import javax.imageio.ImageIO;

/**
 * Parent class for all plants in the game.
 * 
 */


public abstract class Plant extends Sprite {
	final int DEFAULTIMGWIDTH = 70;
	final int DEFAULTIMGHEIGHT = 105;
	int imgHeight = DEFAULTIMGWIDTH; 
	int imgWidth = DEFAULTIMGHEIGHT; 
	String name;
	String nativeRegion;
	boolean invasive;
	String attract_good;
	String attract_bad;
	int shade;
	int root;
	int maintainTime;
	boolean engaging;
	boolean round1;
	boolean round2;
	boolean round3;
	boolean isVisible;
	static int HIGH = 10;
	static int MED = 5;
	static int LOW = 1;
	static int NONE = 0;
	
	public Plant(){}
	
	public Plant(String imageName, String name, String nativeRegion, boolean invasive, String attract_good, String attract_bad, int shade, 
			int root, int maintainTime, boolean engaging, boolean round1, boolean round2,
			boolean round3,	boolean isVisible){
		createImage(imageName);
		this.name = name;
		this.nativeRegion = nativeRegion;
		this.invasive = invasive;
		this.attract_good = attract_good;
		this.attract_bad = attract_bad;
		this.shade = shade;
		this.root = root;
		this.maintainTime = maintainTime;
		this.engaging = engaging;
		this.round1 = round1;
		this.round2 = round2;
		this.round3 = round3;
		this.isVisible = isVisible;
	}
	
	
	public int getImgHeight(){return imgHeight;}
	public int getImgWidth(){return imgWidth;}
	public String getName(){return name;}
	public String getNativeRegion(){return nativeRegion;}
	public boolean getInvasive(){return invasive;}
	public String getAttractGood(){return attract_good;}
	public String getAttractBad(){return attract_bad;}
	public int getShade(){return shade;}
	public int getRoots(){return root;}
	public int getMaintainTime(){return maintainTime;}
	public boolean getEngaging(){return engaging;}
	public BufferedImage[] getImage(){return image;}
	
	@Override
	public String toString(){return name;}
	
	public void createImage(String imageName){
	try {
	BufferedImage temp = ImageIO.read(new File("images/plants/"+imageName +".png"));
	image  = new BufferedImage[1];
	image[0] = temp;
	
	} catch (IOException e) {
		e.printStackTrace();

	}
	}
	
}
