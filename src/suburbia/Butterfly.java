package suburbia;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Butterfly extends Animal{

	//String imageName;
	
	public Butterfly() {
		super("Butterfly",6);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	 BufferedImage[] createImage(String animalName){
    	
    	//int NUMBER_OF_IMAGE_SETS=8;
    	
    	BufferedImage bufferedImage[]= new BufferedImage[numFrames];
    	    	
    	try {
    		bufferedImage [0]= ImageIO.read(new File("images/Animals/"+animalName+".png"));
    		
    		return bufferedImage;
    		
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return null;
	
	}
}