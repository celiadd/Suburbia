package suburbia;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Random;

import javax.imageio.ImageIO;

public class MegaCaterpillar implements Runnable{
	//Variables
		private int frameCount = 2;
		private int imgWidth = 1024;
		private int imgHeight = 1024;
		private int CATERPILLAR_SIZE_X = 150;
		private int CATERPILLAR_SIZE_Y = 150;
		private BufferedImage pics[];
		private String Direction="east";
		private int Xlocation;
		private int Ylocation;
		private final int NUMBER_OF_IMAGE_SETS = 2;
		private int speed;
		private int PicSelecter=0;
		Random genenator = new Random();
		private boolean MegaCaterpillar_is_Visible = false;
		private boolean CaterpillarIsMoving = false;
		//How to know if character should stop moving
		private int stopmovingoffset=(2*getSpeed())/3;
		
		public MegaCaterpillar(){
			BufferedImage img []= createImage();    	
	    	
	    	pics  = new BufferedImage[(NUMBER_OF_IMAGE_SETS*frameCount)];
	    	
	    	
	    	for(int i = 0; i < (NUMBER_OF_IMAGE_SETS*frameCount); i++){
	    			
	    		pics[i] = img[i/frameCount].getSubimage(imgWidth*(i%frameCount), 0, imgWidth, imgHeight);
	    	}  
		}
		
		
		  //Read image from file and return
	    private BufferedImage[] createImage(){
	    	
	    	//int NUMBER_OF_IMAGE_SETS=8;
	    	
	    	BufferedImage bufferedImage[]= new BufferedImage[NUMBER_OF_IMAGE_SETS];
	    	    	
	    	try {	    	
	    		bufferedImage [0]= ImageIO.read(new File("images/MegaCatterpillar/caterpillarLeft.png"));
	    		bufferedImage [1]= ImageIO.read(new File("images/MegaCatterpillar/caterpillarRight.png"));
	    		
	    		return bufferedImage;
	    		
	    	} catch (IOException e) {
	    		e.printStackTrace();
	    	}
	    	return null;
	    	
	    	// TODO: Change this method so you can load other orc animation bitmaps
	    	/* changes made to this method include: making an array of images to read multiple orc images*/
	    }
	    GameBoard BoardGetter = new GameBoard();
	    @Override
		public void run() {
	    		    	
	    	int Max_Int_for_Ran_SelX = BoardGetter.Boundaries.getRightBound();
	    	int Max_Int_for_Ran_SelY = BoardGetter.Boundaries.getBottomBound();
	    	
	    	//local variables that will hold a rand num
	    	int Xtarget=0;
	    	int Ytarget=0;
	    	int XDelete=0;
	    	int YDelete=0;
			while(BoardGetter.frame.isShowing()&&BoardGetter.Executing()){
				//BoardGetter.Glow.setNextPicture();
				while (!BoardGetter.PowerUP.isPowerIconPress(BoardGetter.getMouseClickX(), BoardGetter.getMouseClickY())){
					
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					BoardGetter.Glow.setNextPicture();								
				}
				BoardGetter.Glow.setInvisible();
				BoardGetter.PowerUP.setInvisible();
				BoardGetter.Metapod.setVisible();
				if (BoardGetter.Metapod.IsVisible()){
				
					BoardGetter.PowerUP.setInvisible();
					
					//BoardGetter.frame.repaint();
//=============>	CODE THAT GIVES THE CATERPILLAR THE LOCATION OF BAD PLANTS HAS TO GO SOMEWHERE BETWEEN THE ARROWS	
					/*
					 * if list of plants contains an invasive plant
					 * 		- get the location of the first one and set Xtarget and Ytarget of caterpillar
					 * 		- also set some kind of flag to know whether an invasive exist
					 * 	else do the loop below.
					 */	
					
					while(BoardGetter.IsIsBusy()){
						try {
							Thread.sleep(83);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		
					}
					Iterator<PlantLocation> plantedIterator = BoardGetter.gamePlantLocations.iterator();
					Plant p ;
					
					boolean invasive = false;
					while(plantedIterator.hasNext()&&!invasive){
						BoardGetter.setBeingUse(true);
						PlantLocation currentSprit = plantedIterator.next();
						if (currentSprit.getPlant() instanceof Plant ){
							p = (Plant)currentSprit.getPlant();
							if (p.getInvasive()){
								
								invasive = true;
								Xtarget = currentSprit.getX()+ currentSprit.getPlant().getImgWidth()/2;
								Ytarget = currentSprit.getY()+ currentSprit.getPlant().getImgHeight()-30;
								XDelete = currentSprit.getX();
								YDelete = currentSprit.getY();
							}else {
								
								invasive = false;
							
							}
						}
					}
					BoardGetter.setBeingUse(false);
					if (!invasive){
						do{System.out.println("trying to generate a point for the caterpillar to go to");
							Xtarget = this.genenator.nextInt(Max_Int_for_Ran_SelX);
							Ytarget = this.genenator.nextInt(Max_Int_for_Ran_SelY);
						}while(!BoardGetter.IsInsideGrid(Xtarget, Ytarget));
					}
//==============>
					MoveCaterpillar(Xtarget,Ytarget);
					/*
					 * if the flag is true
					 * 		- then use the delete method in the perform action area to get rid of plant
					 * 		-probably reset the flag
					 */
					
					if (invasive){
						BoardGetter.DoDeletingAction(Xtarget, Ytarget);
						deletePlant(XDelete,YDelete);
					}
					invasive =false;
					}
				//this slows down the thread just enough to allow the main thread to work properly
				//otherwise this thread would take so much proccessing power
				try {
					Thread.sleep(102);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				
			}
			
		}
	    void deletePlant(int x, int y){
	    	while(BoardGetter.IsIsBusy()){
				try {
					Thread.sleep(83);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
	    	Iterator<PlantLocation> spriteIterator = BoardGetter.gamePlantLocations.iterator();
	    	PlantLocation currentSprite;
	    	while(spriteIterator.hasNext()){
	    		currentSprite = spriteIterator.next();
	    		if (currentSprite.getX()==x&&currentSprite.getY()==y){
	    			spriteIterator.remove();
	    		}
	    	}
	    }
	    void MoveCaterpillar(int Xtarget, int Ytarget){
	    	    
	    	CaterpillarIsMoving =true;//ENABLE the loop
	    	while(CaterpillarIsMoving){
	    		this.setNextPicture();
	    		try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
	    		//this condition exits the loop, basically if the target point is somewhere within the caterpillar's area then that's it.
	    		if (Xtarget>=this.Xlocation&&Xtarget<=this.Xlocation+CATERPILLAR_SIZE_X&&Ytarget>=this.Ylocation&&Ytarget<=this.Ylocation+CATERPILLAR_SIZE_Y){
	    			CaterpillarIsMoving = false;
	    			
	    		}
	    		else{
	    	    
	    			//before moving chose a direction 
	    			ChangeDirection(Xtarget, Ytarget);
	    			if (this.Direction=="north"){
	    				this.Ylocation = this.Ylocation - this.speed;
	    				
	    			}
	    			if (this.Direction == "south"){
	    				this.Ylocation = this.Ylocation + this.speed;
	    				
	    			}
	    			if (this.Direction == "east"){
	    				this.Xlocation = this.Xlocation + this.speed;
	    				
	    			}
	    			if (this.Direction == "west"){
	    				this.Xlocation = this.Xlocation - this.speed;
	    				
	    			}
	    		}
	    	}
	    	
			
		}
	    
	    void ChangeDirection(int xtarget, int ytarget){
	    	if ((Ylocation+CATERPILLAR_SIZE_Y)<ytarget){
	    		setDirection("south");
	    	
	    	}else if(Ylocation > ytarget){
	    		setDirection("north");
	    		
	    	}else if(Xlocation > xtarget){
	    		setDirection("west");
	    		
	    	}else if ((Xlocation+CATERPILLAR_SIZE_X) < xtarget){
	    		Direction = "east";
	    	}
	    }
	    
	    //Setters----------------------------------------------------------------------------------------------------------
	    void setVisible(){
	    	MegaCaterpillar_is_Visible = true;
	    }
	    void setInvisible(){
	    	MegaCaterpillar_is_Visible = false;
	    }
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
	    
	    
	    void setSpeed(int speedinput){
	    	speed=speedinput;
	    }
	    

	    //Getters-----------------------------------------------------------------------------------------------------------------
	    boolean IsVisible(){
	    	return MegaCaterpillar_is_Visible;
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
	    BufferedImage [] getCreatureImages(){
	    	return pics;
	    }
	    
	    String getDirection(){
	    	return Direction;
	    }
	    
	    int getimgWidth(){
	    	return imgWidth;
	    }
	    
	    int getimgHeight(){
	    	return imgHeight;
	    }
	    
	    int getSpeed(){
	    	return speed;
	    }
	    
	    int getstopmovingoffset(){
	    	return stopmovingoffset;
	    }
	    
	    int getCaterpillarWidth(){
	    	return CATERPILLAR_SIZE_X;
	    }
	    int getCaterpillarHeight(){
	    	return CATERPILLAR_SIZE_Y;
	    }
	    int getFrameCount(){
	    	return frameCount;
	    }


		
		
}
