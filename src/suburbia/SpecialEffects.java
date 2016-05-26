package suburbia;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class SpecialEffects {
	private BufferedImage AnimationPics[];
	private int NUMBER_OF_IMAGE_SETS;
	private int FRAME_COUNT;
	private int imgWidth;
	private int imgHeight;
	private int SIZEX;
	private int SIZEY;
	private int xlocation;
	private int ylocation;
	private int PicSelecter;
	private boolean visible;
	private String PicName;
	
	public SpecialEffects(int width,int height,int x, int y,String name, int numSets,int Fcount,int sizeX,int sizeY){
		this.NUMBER_OF_IMAGE_SETS = numSets;
		this.FRAME_COUNT = Fcount;
		this.PicSelecter = 0;
		this.imgWidth = width;
		this.imgHeight = height;
		this.SIZEX = sizeX;
		this.SIZEY = sizeY;
		this.xlocation = x;
		this.ylocation = y;
		this.visible = false;
		this.PicName = name;
		this.AnimationPics = new BufferedImage[(NUMBER_OF_IMAGE_SETS*FRAME_COUNT)];
		BufferedImage [] img =	createImage();
		
		for(int i = 0; i < (NUMBER_OF_IMAGE_SETS*FRAME_COUNT); i++){
			
    		AnimationPics[i] = img[i/FRAME_COUNT].getSubimage(imgWidth*(i%FRAME_COUNT), 0, imgWidth, imgHeight);
    	} 
		
	}
	
	  private BufferedImage[] createImage(){
	    		    	
	    	BufferedImage bufferedImage[]= new BufferedImage[NUMBER_OF_IMAGE_SETS];
	    	    	
	    	try {	    	
	    		for (int i =0;i<NUMBER_OF_IMAGE_SETS;i++){
	    			bufferedImage [i]= ImageIO.read(new File(PicName));
	    			    			
	    		}
	    		
	    			    		
	    		return bufferedImage;
	    		
	    	} catch (IOException e) {
	    		e.printStackTrace();
	    	}
	    	return null;
	    	    
	    }
	
	  //setters-------------------------------------------------------------
	  	void setVisible(){
	  		visible = true;
	  	}
	  	void setInvisible(){
	  		visible = false;
	  	}
	  	void setNextPicture(){
	  		PicSelecter = (PicSelecter + 1) % FRAME_COUNT;
	  	}
	  	 void setXlocation(int X){
			  xlocation = X;
		  }
		  
		  void setYlocation(int Y){
			  ylocation = Y;
		  }
	  //Getters-------------------------------------------------------------
	    int getFrameCount(){
	    	return FRAME_COUNT;
	    }
	    int getNextImage(){
	    	return PicSelecter;
	    }
	    int getXlocation(){
	    	return xlocation;
	    }
	    int getYlocation(){
	    	return ylocation;
	    }
	    BufferedImage [] getImages(){
	    	return AnimationPics;
	    }	    
	    
	    int getimgWidth(){
	    	return SIZEX;
	    }
	    
	    int getimgHeight(){
	    	return SIZEY;
	    }
	    
	    boolean IsVisible(){
	    	return visible;
	    }	

}
