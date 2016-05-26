package suburbia;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Shovel extends Sprite{
	final int DEFAULTIMGWIDTH = 120;
	final int DEFAULTIMGHEIGHT = 120;
	int imgHeight = DEFAULTIMGWIDTH; 
	int imgWidth = DEFAULTIMGHEIGHT; 
	String name;
	String imageName;
	boolean isVisible;
	String description;
	
	public Shovel(){
		imageName = "images/misc/shovel.png";
		createImage(imageName);
		this.name = "Shovel";
		this.isVisible = true;
		this.description = "Use to Remove Plants";
	}
	
	
	public int getImgHeight(){return imgHeight;}
	public int getImgWidth(){return imgWidth;}
	public String getName(){return name;}
	public BufferedImage[] getImage(){return image;}
	
	@Override
	public String toString(){return name;}
	
	public void createImage(String imageName){
		try {
		BufferedImage temp = ImageIO.read(new File(imageName));
		image  = new BufferedImage[1];
		image[0] = temp;
		
		} catch (IOException e) {
			e.printStackTrace();
	
		}
	}
}