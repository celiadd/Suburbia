package suburbia;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.event.MouseInputListener;


public class MainCreature{
	
	//Variables
	private int frameCount =10;
	private int imgWidth = 543;
	private int imgHeight = 1031;
	private BufferedImage pics[];
	private int numSubImages = 10;
	private String Direction="east";
	private int Xlocation;
	private int Ylocation;
	private final int NUMBER_OF_IMAGE_SETS = 4;
	private int SIZEX = 87;
	private int SIZEY = 165;
	// How many pixels main creature moves per method call
	private int speed = 50;
	private int PicSelecter=0;
	//How to know if character should stop moving
	private double stopmovingoffset=(2*getSpeed())/3;
	
	
	public MainCreature(){
	    BufferedImage img []= createImage();    	
    	
    	pics  = new BufferedImage[(NUMBER_OF_IMAGE_SETS*frameCount)];
    	
    	
    	for(int i = 0; i < (NUMBER_OF_IMAGE_SETS*frameCount); i++){
    			
    		pics[i] = img[i/numSubImages].getSubimage(imgWidth*(i%numSubImages), 0, imgWidth, imgHeight);
    	}    	
      
	}
	
	  //Read image from file and return
    private BufferedImage[] createImage(){
    	
    	//int NUMBER_OF_IMAGE_SETS=8;
    	
    	BufferedImage bufferedImage[]= new BufferedImage[NUMBER_OF_IMAGE_SETS];
    	    	
    	try {
    		//bufferedImage [0]= ImageIO.read(new File("images/orc/orc_forward_north.png"));
    		//bufferedImage [1]= ImageIO.read(new File("images/orc/orc_forward_south.png"));
    		bufferedImage [0]= ImageIO.read(new File("images/orc/moogleRight.png"));
    		bufferedImage [1]= ImageIO.read(new File("images/orc/moogleLeft.png"));
    		//bufferedImage [4]= ImageIO.read(new File("images/orc/orc_forward_northeast.png"));
    		bufferedImage [2]= ImageIO.read(new File("images/orc/moogleLeft.png"));
    		bufferedImage [3]= ImageIO.read(new File("images/orc/moogleRight.png"));
    		//bufferedImage [7]= ImageIO.read(new File("images/orc/orc_forward_southwest.png"));
    		
    		return bufferedImage;
    		
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return null;
    	
    	// TODO: Change this method so you can load other orc animation bitmaps
    	/* changes made to this method include: making an array of images to read multiple orc images*/
    }
    
    //Setters
    void setNextPicture(){
    	PicSelecter = (PicSelecter + 1) % frameCount;
    }
    void setXlocation(int x){
    	Xlocation = x;
    }
    
    void setYlocation(int y){
    	Ylocation = y;
    }
    void setDirection(String new_direction){
    	Direction = new_direction;
    }
    void ChangeDirection(int xtarget, int ytarget){
    	if (Ylocation > ytarget && Ylocation > ytarget - 10){
    		Direction = "south";
    	
    	}else if(Ylocation < ytarget && Ylocation < ytarget -10){
    		Direction = "north";
    		
    	}else if(Xlocation > xtarget){
    		Direction = "west";
    		
    	}else if (Xlocation < xtarget){
    		Direction = "east";
    	}
    }
    
    void setSpeed(int speedinput){
    	speed=speedinput;
    }
    

    //Getters
    int getFrameCount(){
    	return frameCount;
    }
    int getNextPic(){
    	return PicSelecter;
    }
    int getXlocation(){
    	return Xlocation;
    }
    int getYlocation(){
    	return Ylocation;
    }
    BufferedImage [] getMainCreatureImages(){
    	return pics;
    }
    
    String getDirection(){
    	return Direction;
    }
    
    int getimgWidth(){
    	return SIZEX;
    }
    
    int getimgHeight(){
    	return SIZEY;
    }
    
    int getSpeed(){
    	return speed;
    }
    
    double getstopmovingoffset(){
    	return stopmovingoffset;
    }
}
