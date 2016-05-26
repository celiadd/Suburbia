package suburbia;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

//import javax.swing.JPanel;

public abstract class Animal extends Sprite{
	String animalName;
	Boolean pest;
	int numFrames;
	static int imgWidth = 960;
	static int imgHeight = 960;
	int targetX; // plant location where animal wants to go
	int targetY; 
	
	
	public Animal (String name, int numFrames){
		this.numFrames = numFrames;
		this.animalName = name;
		
		BufferedImage[] img = createImage(animalName);
		
		image  = new BufferedImage[(numFrames)];
    	
    	for(int i = 0; i < (numFrames); i++){
    			
    		image[i] = img[i/numFrames].getSubimage(imgWidth*(i/numFrames), 0, imgWidth, imgHeight);
    	}  
		
	}
	
	@Override
	public String getName(){return animalName;}
	
	BufferedImage[] createImage(String animalName){
		   
	    	BufferedImage bufferedImage[]= new BufferedImage[numFrames];
	    	try {
	    		bufferedImage [0]= ImageIO.read(new File("images/orc/orc_forward_east.png"));
	    		bufferedImage [1]= ImageIO.read(new File("images/orc/orc_forward_west.png"));
	    		bufferedImage [2]= ImageIO.read(new File("images/orc/orc_forward_north.png"));
	    		bufferedImage [3]= ImageIO.read(new File("images/orc/orc_forward_south.png"));
	    		return bufferedImage;
	    	} catch (IOException e) {
	    		e.printStackTrace();
	    	}
	    	return null;
	    }
	   
	void load_image(String fileName){}

} 
