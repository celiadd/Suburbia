package suburbia;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SeedBag extends Sprite{
	final int DEFAULTIMGWIDTH = 320;
	final int DEFAULTIMGHEIGHT = 310;
	int imgHeight = DEFAULTIMGWIDTH; 
	int imgWidth = DEFAULTIMGHEIGHT; 
	String name;
	String imageName;
	boolean isVisible;
	String description;
	
	public SeedBag(){
		imageName = "images/misc/seedbag.png";
		createImage(imageName);
		this.name = "SeedBag";
		this.isVisible = true;
		this.description = "Reset seeds";
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